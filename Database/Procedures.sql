--update student data
create or replace procedure updateStudent(V_StudentID number,V_FirstName varchar2,V_LastName varchar2,V_Email varchar2,V_DOB date,V_Gender char,V_PhoneNumber number,V_DepartmentID number)
is
begin
    update students
    set FirstName = V_FirstName , LastName = V_LastName , Email = V_Email , DOB = V_DOB, Gender = V_Gender , PhoneNumber = V_PhoneNumber , DepartmentID = V_DepartmentID
    where StudentID = V_StudentID;
end;

