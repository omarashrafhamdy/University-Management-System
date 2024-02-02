create table students(
    StudentID number primary key,
    FirstName varchar2(50) not null,
    LastName varchar2(50) not null,
    Email varchar2(100) not null unique,
    DOB date not null,
    Gender char(1) not null,
    PhoneNumber number not null,
    DepartmentID number references Departments(DepartmentID) on delete set null
);

create table login(
    Username varchar2(50) primary key,
    Password varchar2(50) unique not null
);
insert into login
values('admin','admin');

create table departments(
    DepartmentID number primary key,
    DepartmentName varchar2(50) unique not null
);

create table courses(
    CourseID number primary key,
    CourseName varchar2(50) unique not null,
    NoOfHours number not null
);

create table DepartmentCourses(
    DepartmentID number references Departments(DepartmentID) on delete cascade,
    CourseID number references Courses(CourseID) on delete cascade,
    primary key (DepartmentID,CourseID)
);

create table StudentRegisterCourse(
    StudentID number references Students(StudentID) on delete cascade,
    CourseID number references Courses(CourseID) on delete cascade,
    Year number not null,
    Semester number not null,
    Grade number default null,
    primary key(StudentID,CourseID,Year,Semester)
);

INSERT INTO departments (DepartmentID, DepartmentName) VALUES (1, 'Computer Science');
INSERT INTO departments (DepartmentID, DepartmentName) VALUES (2, 'Information System');
INSERT INTO departments (DepartmentID, DepartmentName) VALUES (3, 'Artificial Intelligence');
INSERT INTO departments (DepartmentID, DepartmentName) VALUES (4, 'Software Engineering');
INSERT INTO departments (DepartmentID, DepartmentName) VALUES (5, 'Information Technology');
INSERT INTO departments (DepartmentID, DepartmentName) VALUES (6, 'Medical Informatics');
INSERT INTO departments (DepartmentID, DepartmentName) VALUES (7, 'Bioinformatics');
--students data
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (1, 'John', 'Doe', 'john.doe@example.com', TO_DATE('1995-03-15', 'YYYY-MM-DD'), 'M', 1234567890, 1);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (2, 'Jane', 'Smith', 'jane.smith@example.com', TO_DATE('1998-07-22', 'YYYY-MM-DD'), 'F', 9876543210, 2);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (3, 'Robert', 'Johnson', 'robert.johnson@example.com', TO_DATE('1996-11-10', 'YYYY-MM-DD'), 'M', 5555555555, 3);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (4, 'Emily', 'Brown', 'emily.brown@example.com', TO_DATE('1997-04-05', 'YYYY-MM-DD'), 'F', 1111111111, 4);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (5, 'Michael', 'Taylor', 'michael.taylor@example.com', TO_DATE('1999-09-18', 'YYYY-MM-DD'), 'M', 9999999999, 5);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (6, 'Sophia', 'Miller', 'sophia.miller@example.com', TO_DATE('1994-02-28', 'YYYY-MM-DD'), 'F', 4444444444, 6);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (7, 'Matthew', 'Wilson', 'matthew.wilson@example.com', TO_DATE('1993-08-07', 'YYYY-MM-DD'), 'M', 7777777777, 7);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (8, 'Olivia', 'Anderson', 'olivia.anderson@example.com', TO_DATE('1996-06-12', 'YYYY-MM-DD'), 'F', 3333333333, 1);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (9, 'Daniel', 'Clark', 'daniel.clark@example.com', TO_DATE('1992-12-25', 'YYYY-MM-DD'), 'M', 8888888888, 2);

INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID)
VALUES (10, 'Ava', 'Garcia', 'ava.garcia@example.com', TO_DATE('1997-10-30', 'YYYY-MM-DD'), 'F', 6666666666, 3);


INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(11, 'Grace', 'Anderson', 'grace.a@example.com', TO_DATE('1994-11-11', 'YYYY-MM-DD'), 'F', 5555555555, 6);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(12, 'Jake', 'Wilson', 'jake.w@example.com', TO_DATE('1993-12-12', 'YYYY-MM-DD'), 'M', 6666666666, 7);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(13, 'Olivia', 'Johnson', 'olivia.j@example.com', TO_DATE('1992-01-01', 'YYYY-MM-DD'), 'F', 7777777777, 1);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(14, 'Nathan', 'Taylor', 'nathan.t@example.com', TO_DATE('1991-02-02', 'YYYY-MM-DD'), 'M', 8888888888, 2);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(15, 'Sophie', 'Brown', 'sophie.b@example.com', TO_DATE('1990-03-03', 'YYYY-MM-DD'), 'F', 9999999999, 3);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(16, 'Caleb', 'Smith', 'caleb.s@example.com', TO_DATE('1989-04-04', 'YYYY-MM-DD'), 'M', 1111111111, 4);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(17, 'Lily', 'Miller', 'lily.m@example.com', TO_DATE('1988-05-05', 'YYYY-MM-DD'), 'F', 2222222222, 5);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(18, 'Ethan', 'Anderson', 'ethan.a@example.com', TO_DATE('1987-06-06', 'YYYY-MM-DD'), 'M', 3333333333, 6);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(19, 'Zoe', 'Wilson', 'zoe.w@example.com', TO_DATE('1986-07-07', 'YYYY-MM-DD'), 'F', 4444444444, 7);
INSERT INTO students (StudentID, FirstName, LastName, Email, DOB, Gender, PhoneNumber, DepartmentID) VALUES 
(20, 'Andrew', 'Johnson', 'andrew.j@example.com', TO_DATE('1985-08-08', 'YYYY-MM-DD'), 'M', 5555555555, 1);

--courses data
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (1, 'Introduction to Computer Science', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (2, 'Database Management', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (3, 'Software Engineering Principles', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (4, 'Artificial Intelligence', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (5, 'Information Systems Design', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (6, 'Medical Informatics Basics', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (7, 'Network Security', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (8, 'Data Structures and Algorithms', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (9, 'Human-Computer Interaction', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (10, 'Mobile App Development', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (11, 'Database Design', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (12, 'Machine Learning Fundamentals', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (13, 'Computer Graphics', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (14, 'Web Development', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (15, 'Operating Systems', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (16, 'Software Testing', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (17, 'Information Security', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (18, 'Cloud Computing', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (19, 'Bioinformatics Tools', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (20, 'Natural Language Processing', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (21, 'Computer Networks', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (22, 'Cybersecurity Fundamentals', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (23, 'Big Data Analytics', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (24, 'Information Retrieval', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (25, 'Embedded Systems', 3);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (26, 'Human Rights', 2);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (27, 'English 1', 2);
INSERT INTO courses (CourseID, CourseName, NoOfHours) VALUES (28, 'English 2', 2);


--departmentcourses data
-- Populating the DepartmentCourses table with data
-- Computer Science Department courses
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (1, 1);  -- Computer Science - Introduction to Computer Science
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (1, 2);  -- Computer Science - Database Management
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (1, 3);  -- Computer Science - Software Engineering Principles
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (1, 4);  -- Computer Science - Artificial Intelligence
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (1, 7);  -- Computer Science - Network Security
-- ... (add more Computer Science courses as needed)

-- Information System Department courses
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (2, 1);  -- Information Systems - Introduction to Computer Science
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (2, 5);  -- Information Systems - Information Systems Design
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (2, 9);  -- Information Systems - Human-Computer Interaction
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (2, 10); -- Information Systems - Mobile App Development
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (2, 15); -- Information Systems - Operating Systems
-- ... (add more Information Systems courses as needed)

-- Software Engineering Department courses
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (3, 3);  -- Software Engineering - Software Engineering Principles
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (3, 11); -- Software Engineering - Database Design
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (3, 14); -- Software Engineering - Web Development
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (3, 16); -- Software Engineering - Software Testing
-- ... (add more Software Engineering courses as needed)

-- Medical Informatics Department courses
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (4, 6);  -- Medical Informatics - Medical Informatics Basics
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (4, 19); -- Medical Informatics - Bioinformatics Tools
-- ... (add more Medical Informatics courses as needed)

-- Artificial Intelligence Department courses
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (5, 4);  -- Artificial Intelligence - Artificial Intelligence
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (5, 12); -- Artificial Intelligence - Machine Learning Fundamentals
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (5, 13); -- Artificial Intelligence - Computer Graphics

-- Information Technology Department courses
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (6, 7);  -- Information Technology - Network Security
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (6, 10); -- Information Technology - Mobile App Development
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (6, 11); -- Information Technology - Database Design
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (6, 14); -- Information Technology - Web Development
-- ... (add more Information Technology courses as needed)

-- Bioinformatics Department courses
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (7, 19); -- Bioinformatics - Bioinformatics Tools
INSERT INTO DepartmentCourses (DepartmentID, CourseID) VALUES (7, 21); -- Bioinformatics - Computer Networks


-- Existing courses with mapped grades
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (11, 1, 2022, 1, 90);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (11, 2, 2022, 1, 85);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (12, 3, 2022, 1, 78);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (13, 4, 2022, 1, 95);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (14, 5, 2022, 1, 82);

-- Not yet graded (N) for some courses
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (15, 6, 2022, 1, NULL);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (16, 7, 2022, 1, NULL);

-- Additional data with mapped grades
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (15, 1, 2022, 1, 88);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (15, 3, 2022, 1, 75);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (16, 2, 2022, 2, 92);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (16, 4, 2022, 2, 68);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (17, 3, 2022, 1, 87);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (17, 5, 2022, 1, 94);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (18, 1, 2022, 2, 79);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (18, 4, 2022, 2, 85);

-- Not yet graded (N) for some courses
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (19, 6, 2022, 1, NULL);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (19, 7, 2022, 1, NULL);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (20, 5, 2022, 2, NULL);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (20, 2, 2022, 2, NULL);

-- Student 11
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (11, 1, 2023, 1, 85);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (11, 5, 2023, 1, 60);

-- Student 12
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (12, 2, 2023, 1, 75);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (12, 8, 2023, 1, 40);

-- Student 13
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (13, 3, 2023, 1, 92);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (13, 11, 2023, 1, 48);

-- Student 14
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (14, 4, 2023, 1, 70);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (14, 14, 2023, 1, 55);

-- Student 15
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (15, 9, 2023, 1, 78);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (15, 19, 2023, 1, null);

-- Student 16
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (16, 6, 2023, 1, 65);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (16, 23, 2023, 1, 85);

-- Student 17
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (17, 7, 2023, 1, 92);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (17, 13, 2023, 1, 40);

-- Student 18
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (18, 10, 2023, 1, null);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (18, 16, 2023, 1, 75);

-- Student 19
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (19, 12, 2023, 1, 88);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (19, 21, 2023, 1, 45);

-- Student 20
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (20, 15, 2023, 1, 68);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (20, 22, 2023, 1, null);

-- Student 21
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (21, 1, 2023, 1, 40);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (21, 5, 2023, 1, 30);

-- Student 22
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (22, 2, 2023, 1, 25);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (22, 8, 2023, 1, 48);

-- Student 23
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (23, 3, 2023, 1, 42);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (23, 11, 2023, 1, 38);

-- Student 24
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (24, 4, 2023, 1, 49);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (24, 14, 2023, 1, 45);

-- Student 25
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (25, 9, 2023, 1, null);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (25, 19, 2023, 1, 42);

-- Student 26
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (26, 6, 2023, 1, null);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (26, 23, 2023, 1, 38);

-- Student 27
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (27, 7, 2023, 1, 49);
INSERT INTO StudentRegisterCourse (StudentID, CourseID, Year, Semester, Grade) VALUES (27, 13, 2023, 1, 50);

