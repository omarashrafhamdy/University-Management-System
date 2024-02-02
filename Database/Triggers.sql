-- add trigger to prevent inserting same course if he succeded
create or replace trigger checkCourseInsert
before insert
on StudentRegisterCourse
for each row
declare
    v_grade number;
begin

    SELECT grade
    into v_grade
    FROM (
        SELECT grade
        FROM StudentRegisterCourse
        WHERE studentid = :new.studentid AND courseid = :new.courseid
        ORDER BY year DESC, semester DESC
    )
    WHERE ROWNUM = 1;

    if v_grade >= 50 then
        raise_application_error(-20001, 'Student Already Passed the course');
    elsif v_grade is null then
        raise_application_error(-20002, 'Student Didnt Complete Course Yet');
    end if;
    
exception
    when no_data_found then
        null;
end;

-- create trigger and sequence for each table
declare
    cursor tab_columns_cursor is
        select TABLE_NAME , COLUMN_NAME
        from USER_CONS_COLUMNS
        join USER_TAB_COLUMNS using(TABLE_NAME,COLUMN_NAME)
        join USER_CONSTRAINTS using(TABLE_NAME,CONSTRAINT_NAME)
        where DATA_TYPE = 'NUMBER'
        and CONSTRAINT_TYPE = 'P';
    cursor seq_cursor is
        select *
        from user_sequences;
    num_seq number(20);
begin
    for seq_record in seq_cursor loop
        execute immediate 'drop sequence ' || seq_record.sequence_name;
    end loop;
    for tab_columns_record in tab_columns_cursor loop
        execute immediate 'select nvl(max(' || tab_columns_record.column_name || '),0)+1  from ' ||tab_columns_record.table_name
        into num_seq;
        
        execute immediate 'create sequence ' || tab_columns_record.table_name ||'_SEQ
        start with ' || num_seq ||
        ' maxvalue 9999999999999999';
        
        execute immediate 'create or replace trigger ' || tab_columns_record.table_name ||'_TRG
        before insert on ' || tab_columns_record.table_name || ' 
        for each row
        begin
            :new.' || tab_columns_record.column_name || ' := ' || tab_columns_record.table_name ||'_SEQ.nextval;
        end;';
    end loop;
    
end;