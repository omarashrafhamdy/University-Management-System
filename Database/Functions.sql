-- calculate gpa for each student
create or replace function calculateStudentGPA(v_studentID number)
return number
is
    cursor studentData is
        select *
        from studentregistercourse
        join courses using(courseID)
        where studentid =v_studentID and grade is not null;
    sumHours number;
    initialGPA number :=0;
        
begin
    for studentData_record in studentData loop
         if studentData_record.grade >= 90 then
            initialGPA := initialGPA + 4.0*studentData_record.NoOfHours;
        elsif studentData_record.grade >=85 and studentData_record.grade <=89 then
            initialGPA := initialGPA + 3.7*studentData_record.NoOfHours;
        elsif studentData_record.grade >=80 and studentData_record.grade <=84 then
            initialGPA := initialGPA + 3.3*studentData_record.NoOfHours;
        elsif studentData_record.grade >=75 and studentData_record.grade <=79 then
            initialGPA := initialGPA + 3.0*studentData_record.NoOfHours;
        elsif studentData_record.grade >=70 and studentData_record.grade <=74 then
            initialGPA := initialGPA + 2.7*studentData_record.NoOfHours;
        elsif studentData_record.grade >=65 and studentData_record.grade <=69 then
            initialGPA := initialGPA + 2.0*studentData_record.NoOfHours;
        elsif studentData_record.grade >=60 and studentData_record.grade <=64 then
            initialGPA := initialGPA + 1.7*studentData_record.NoOfHours;
        elsif studentData_record.grade >=50 and studentData_record.grade <=59 then
            initialGPA := initialGPA + 1.0*studentData_record.NoOfHours;
        else
            initialGPA := initialGPA + 0.0*studentData_record.NoOfHours;
        end if;    
    end loop;
   select sum(NoOfHours)
   into sumHours
   from StudentRegisterCourse
   join courses using(CourseID)
   where studentID = v_studentID and grade is not null;
   return initialGPA/sumHours;
end;

-- calculate course grade for student
create or replace function calculateCourseGrade(v_gradeNum number)
return varchar2
is
    v_grade varchar2(50);
        
begin
    
         if v_gradeNum >= 90 then
            v_grade := 'A+' ;
        elsif v_gradeNum >=85 and v_gradeNum <=89 then
            v_grade := 'A';
        elsif v_gradeNum >=80 and v_gradeNum <=84 then
            v_grade := 'B+';
        elsif v_gradeNum >=75 and v_gradeNum <=79 then
            v_grade := 'B';
        elsif v_gradeNum >=70 and v_gradeNum <=74 then
            v_grade := 'C+';
        elsif v_gradeNum >=65 and v_gradeNum <=69 then
            v_grade := 'C';
        elsif v_gradeNum >=60 and v_gradeNum <=64 then
            v_grade := 'D+';
        elsif v_gradeNum >=50 and v_gradeNum <=59 then
            v_grade := 'D';
        elsif v_gradeNum is null then
            v_grade := 'Not Graded Yet';
        else
            v_grade := 'F';
        end if;    
    
   return v_grade;
end;

--calculate avg course GPA
create or replace function calculateCourseGPA(v_courseID number)
return number
is
    cursor courseData is
        select *
        from studentregistercourse
        join courses using(courseID)
        where courseid =v_courseID and grade is not null;
    sumHours number;
    initialGPA number :=0;
        
begin
    for courseData_record in courseData loop
         if courseData_record.grade >= 90 then
            initialGPA := initialGPA + 4.0*courseData_record.NoOfHours;
        elsif courseData_record.grade >=85 and courseData_record.grade <=89 then
            initialGPA := initialGPA + 3.7*courseData_record.NoOfHours;
        elsif courseData_record.grade >=80 and courseData_record.grade <=84 then
            initialGPA := initialGPA + 3.3*courseData_record.NoOfHours;
        elsif courseData_record.grade >=75 and courseData_record.grade <=79 then
            initialGPA := initialGPA + 3.0*courseData_record.NoOfHours;
        elsif courseData_record.grade >=70 and courseData_record.grade <=74 then
            initialGPA := initialGPA + 2.7*courseData_record.NoOfHours;
        elsif courseData_record.grade >=65 and courseData_record.grade <=69 then
            initialGPA := initialGPA + 2.0*courseData_record.NoOfHours;
        elsif courseData_record.grade >=60 and courseData_record.grade <=64 then
            initialGPA := initialGPA + 1.7*courseData_record.NoOfHours;
        elsif courseData_record.grade >=50 and courseData_record.grade <=59 then
            initialGPA := initialGPA + 1.0*courseData_record.NoOfHours;
        else
            initialGPA := initialGPA + 0.0*courseData_record.NoOfHours;
        end if;    
    end loop;
   select sum(NoOfHours)
   into sumHours
   from StudentRegisterCourse
   join courses using(CourseID)
   where courseid =v_courseID and grade is not null;
   return initialGPA/sumHours;
end;

-- calculate number of passed students in specifiec course
create or replace function calculateCoursePassedNumber(v_courseID number)
return number
is
    v_passed number;
        
begin
   select count(*) 
   into v_passed
   from StudentRegisterCourse 
   where grade >= 50 and grade is not null and courseID = v_courseID;
   return v_passed;
exception
    when no_data_found then
        v_passed := null;
end;

-- calculate number of failed students in specifiec course
create or replace function calculateCourseFailedNumber(v_courseID number)
return number
is
    v_failed number;
        
begin
   select count(*) 
   into v_failed
   from StudentRegisterCourse 
   where grade < 50 and grade is not null and courseID = v_courseID;
   return v_failed;
exception
    when no_data_found then
        v_failed := null;
end;