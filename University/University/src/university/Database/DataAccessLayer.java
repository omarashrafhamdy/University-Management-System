package university.Database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import university.DTO.CourseDTO;
import university.DTO.DepartmentDTO;
import university.DTO.HomeReportDTO;
import university.DTO.RegisterCourseDTO;
import university.DTO.StudentCoursesDTO;
import university.DTO.StudentDTO;
import university.DTO.StudentReportDTO;

/**
 *
 * @author OMAR
 */
public class DataAccessLayer {
    
    public static boolean checkLogin(String username , String password , Connection conn){
        Connection con = conn;
        PreparedStatement prepare;
        ResultSet rs;
        String sql = "select * from login where username = ? and password = ?";
        try {
                prepare = con.prepareStatement(sql);
                prepare.setString(1, username);
                prepare.setString(2, password);
                rs = prepare.executeQuery();
                if (rs.next()) {
                    // correct username and password
                    //System.out.println("Login Success");
                    return true;
                } else {
                    //incorrect username or password
                    //System.out.println("Login Failed");
                    return false;
                }
               
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public static ObservableList<StudentDTO> getStudentData(Connection conn){
        ObservableList<StudentDTO> studentsData = FXCollections.observableArrayList();
        
        Connection con = conn;
        try {
            PreparedStatement prepare;
            ResultSet rs;
            String sql = "select StudentID, FirstName, LastName, Email,"
                    + " DOB, Gender, PhoneNumber, DepartmentID,"
                    + "DepartmentName,round(calculateStudentGPA(studentID),2) as gpa "
                    + ", calculateStudentLevel(StudentID) as \"level\" "
                    + "from students left join departments using(DepartmentID) order by studentid";
            prepare = con.prepareStatement(sql);
            rs = prepare.executeQuery();
            while (rs.next()){
                
                String studentCoursesSql = "select courseid,studentid,year,semester,grade,coursename,noofhours ,calculateCourseGrade(grade) as gradeC from StudentRegisterCourse join courses using(courseID) where studentID = ? order by studentid";
                PreparedStatement studentCoursesPrepare = con.prepareStatement(studentCoursesSql);
                studentCoursesPrepare.setInt(1, rs.getInt("StudentID"));
                ResultSet studentCoursesResult = studentCoursesPrepare.executeQuery();
                ObservableList<StudentCoursesDTO> studentCourses = FXCollections.observableArrayList();
                while(studentCoursesResult.next()){
                    StudentCoursesDTO singleStudentCourses = new StudentCoursesDTO(studentCoursesResult.getInt("CourseID"),studentCoursesResult.getString("CourseName"),studentCoursesResult.getInt("Year"),studentCoursesResult.getInt("Semester"),studentCoursesResult.getInt("Grade"),studentCoursesResult.getString("gradeC"));
                    studentCourses.add(singleStudentCourses);
                }
                StudentDTO studentData = new StudentDTO(rs.getInt("StudentID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getDate("DOB"), rs.getString("Gender"), rs.getLong("PhoneNumber"),rs.getInt("DepartmentID"),rs.getString("DepartmentName"),rs.getDouble("gpa"),studentCourses, rs.getInt("level"));
                studentsData.add(studentData);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentsData;
    }
    
    public static ObservableList<StudentDTO> getStudentCoursesData(Connection conn){
        ObservableList<StudentDTO> studentsData = FXCollections.observableArrayList();
        
        Connection con = conn;
        try {
            PreparedStatement prepare;
            ResultSet rs;
            String sql = "select StudentID, FirstName, LastName, Email,"
                    + " DOB, Gender, PhoneNumber, DepartmentID,"
                    + "DepartmentName "
                    + "from students join departments using(DepartmentID) order by studentid";
            prepare = con.prepareStatement(sql);
            rs = prepare.executeQuery();
            while (rs.next()){
                
                String studentCoursesSql = "SELECT * FROM departmentcourses JOIN courses USING (courseID) "
                        + "JOIN students USING (departmentid) LEFT JOIN studentregistercourse USING (studentid, courseid) "
                        + "WHERE studentid = ?  AND departmentid = ?";
                PreparedStatement studentCoursesPrepare = con.prepareStatement(studentCoursesSql);
                studentCoursesPrepare.setInt(1, rs.getInt("StudentID"));
                studentCoursesPrepare.setInt(2, rs.getInt("DepartmentID"));
                ResultSet studentCoursesResult = studentCoursesPrepare.executeQuery();
                ObservableList<StudentCoursesDTO> studentCourses = FXCollections.observableArrayList();
                while(studentCoursesResult.next()){
                    StudentCoursesDTO singleStudentCourses = new StudentCoursesDTO(studentCoursesResult.getInt("courseID"),studentCoursesResult.getString("courseName"),studentCoursesResult.getInt("NoOfHours"));
                    studentCourses.add(singleStudentCourses);
                }
                StudentDTO studentData = new StudentDTO(rs.getInt("StudentID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getDate("DOB"), rs.getString("Gender"), rs.getLong("PhoneNumber"),rs.getInt("DepartmentID"),rs.getString("DepartmentName"),studentCourses);
                studentsData.add(studentData);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentsData;
    }
    
    public static ObservableList<String> getDepartmentNamesData(Connection conn){
        ObservableList<String> departmentsData = FXCollections.observableArrayList();
        
        Connection con = conn;
        try {
            PreparedStatement prepare;
            ResultSet rs;
            String sql = "select departmentName from departments";
            prepare = con.prepareStatement(sql);
            rs = prepare.executeQuery();
            while (rs.next()){
                departmentsData.add(rs.getString("departmentName"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departmentsData;
    }
    
    public static ObservableList<DepartmentDTO> getDepartmentData(Connection conn){
        ObservableList<DepartmentDTO> departmentsData = FXCollections.observableArrayList();
        Connection con = conn;
        try {
            
            PreparedStatement prepare;
            ResultSet rs;
            String sql = "select * from departments order by departmentid";
            prepare = con.prepareStatement(sql);
            rs = prepare.executeQuery();
            while (rs.next()){
                String departmentCoursesSql = "select * from departmentCourses join courses using(courseid) where departmentid = ? order by courseid";
                PreparedStatement departmentCoursesPrepare = con.prepareStatement(departmentCoursesSql);
                departmentCoursesPrepare.setInt(1, rs.getInt("DepartmentID"));
                ResultSet departmentCoursesResult = departmentCoursesPrepare.executeQuery();
                ObservableList<CourseDTO> departmentCourses = FXCollections.observableArrayList();
                
                while(departmentCoursesResult.next()){
                    CourseDTO singleDepartmentCourses = new CourseDTO(departmentCoursesResult.getInt("CourseID"),departmentCoursesResult.getString("CourseName"),departmentCoursesResult.getInt("NoOfHours"));
                    departmentCourses.add(singleDepartmentCourses);
                }
                
                ObservableList<CourseDTO> departmentNotAssignedCourses = FXCollections.observableArrayList();
                String departmentNotAssignedCoursesSql = "SELECT * FROM courses WHERE courseid NOT IN (SELECT courseid FROM departmentCourses WHERE departmentid = ?) order by courseid";
                PreparedStatement departmentNotAssignedCoursesPrepare = con.prepareStatement(departmentNotAssignedCoursesSql);
                departmentNotAssignedCoursesPrepare.setInt(1, rs.getInt("DepartmentID"));
                ResultSet departmentNotAssignedCoursesResult = departmentNotAssignedCoursesPrepare.executeQuery();
                while(departmentNotAssignedCoursesResult.next()){
                    CourseDTO singleDepartmentNotAssignedCourses = new CourseDTO(departmentNotAssignedCoursesResult.getInt("CourseID"),departmentNotAssignedCoursesResult.getString("CourseName"),departmentNotAssignedCoursesResult.getInt("NoOfHours"));
                    departmentNotAssignedCourses.add(singleDepartmentNotAssignedCourses);
                }
                DepartmentDTO departmentData = new DepartmentDTO(rs.getInt("DepartmentID"),rs.getString("DepartmentName"),departmentCourses , departmentNotAssignedCourses);
                departmentsData.add(departmentData);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departmentsData;
    }
    
    public static ObservableList<CourseDTO> getCourseData(Connection conn){
        ObservableList<CourseDTO> coursesData = FXCollections.observableArrayList();
        Connection con = conn;
        try {
            PreparedStatement prepare;
            ResultSet rs;
            String sql = "select * from courses order by courseid";
            prepare = con.prepareStatement(sql);
            rs = prepare.executeQuery();
            while (rs.next()){
                CourseDTO singleCourseData = new CourseDTO(rs.getInt("CourseID"),rs.getString("CourseName"),rs.getInt("NoOfHours"));
                coursesData.add(singleCourseData);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coursesData;
    }
    
    /*public static ObservableList<String> getStudentCoursesData(int studentID,Connection conn){
        ObservableList<String> coursesData = FXCollections.observableArrayList();
        Connection con = conn;
        try {
            int departmentID;
            PreparedStatement prepare;
            ResultSet rs;
            String sql = "select departmentid from students where studentid = ?";
            prepare = con.prepareStatement(sql);
            prepare.setInt(1, studentID);
            rs = prepare.executeQuery();
            if(rs.next())
                departmentID = rs.getInt("departmentID");
            else
                return null;
            sql = "SELECT courseName FROM departmentcourses JOIN courses USING (courseID) JOIN students USING (departmentid) LEFT JOIN studentregistercourse USING (studentid, courseid) WHERE studentid = ?  AND departmentid = ?  AND (year IS NULL OR semester IS NULL OR grade < 50)";
            prepare = con.prepareStatement(sql);
            prepare.setInt(1, studentID);
            prepare.setInt(2, departmentID);
            rs = prepare.executeQuery();
            while (rs.next()){
                
                coursesData.add(rs.getString("courseName"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coursesData;
    }*/
    
    public static ObservableList<RegisterCourseDTO> getRegisterCourseData(Connection conn){
        ObservableList<RegisterCourseDTO> registerCoursesData = FXCollections.observableArrayList();
        Connection con = conn;
        try {
            PreparedStatement prepare;
            ResultSet rs;
            String sql = "select studentid,firstname||' '||lastname as studentName,courseid,coursename,year,semester,grade,calculateCourseGrade(grade) as gradeC from studentRegisterCourse join courses using(courseid) join students using(studentid)";
            prepare = con.prepareStatement(sql);
            rs = prepare.executeQuery();
            while (rs.next()){
                RegisterCourseDTO singleRegisterCourseData = new RegisterCourseDTO(rs.getInt("Studentid"),rs.getString("StudentName"),rs.getInt("Courseid"),rs.getString("Coursename"),rs.getInt("year"),rs.getInt("semester"),rs.getInt("grade"),rs.getString("gradeC"));
                registerCoursesData.add(singleRegisterCourseData);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registerCoursesData;
    }
    
    public static HomeReportDTO getHomeReportData(Connection conn){
        ObservableList<CourseDTO> courseReportData = FXCollections.observableArrayList();
        HomeReportDTO homeReportData=null;
        
        Connection con = conn;
        try {
            int totalStudents=0;
            int totalDepartments=0;
            int totalCourses=0;
            PreparedStatement prepare;
            ResultSet rs;
            // get total students
            prepare = con.prepareStatement("select count(*) as count from students");
            rs = prepare.executeQuery();
            while (rs.next()){
                totalStudents = rs.getInt("count");
            }
            //get total departments
            prepare = con.prepareStatement("select count(*) as count from departments");
            rs = prepare.executeQuery();
            while (rs.next()){
                totalDepartments = rs.getInt("count");
            }
            // get total courses
            prepare = con.prepareStatement("select count(*) as count from courses");
            rs = prepare.executeQuery();
            while (rs.next()){
                totalCourses = rs.getInt("count");
            }
            
            prepare = con.prepareStatement("select courseid , coursename, noofhours , round(calculateCourseGPA(courseid),2) as coursegpa"
                    + ", calculateCoursePassedNumber(courseid) as passnum,calculateCourseFailedNumber(courseid) as failnum from courses");
            rs = prepare.executeQuery();
            while (rs.next()){
                PreparedStatement studentPrepare = con.prepareStatement("select studentid,firstname,lastname,year,semester,"
                        + "grade,calculateCourseGrade(grade) as gradeC "
                        + "from studentregistercourse join students using (studentid) where courseid =?");
                studentPrepare.setInt(1, rs.getInt("courseid"));
                ResultSet studentRS = studentPrepare.executeQuery();
                ObservableList<StudentReportDTO> singleStudentReport = FXCollections.observableArrayList();
                while (studentRS.next()){
                    StudentReportDTO studentReportData = new StudentReportDTO(studentRS.getInt("studentid"), studentRS.getString("firstname"), studentRS.getString("lastname"), studentRS.getInt("year"), studentRS.getInt("semester"), studentRS.getInt("grade"), studentRS.getString("gradeC"));
                    singleStudentReport.add(studentReportData);
                }
                
                CourseDTO singleCourseData = new CourseDTO(rs.getInt("courseid"), rs.getString("coursename"), rs.getDouble("coursegpa"), rs.getInt("noofhours"), rs.getInt("passnum"), rs.getInt("failnum"),singleStudentReport);
                courseReportData.add(singleCourseData);
            }
            homeReportData = new HomeReportDTO(totalStudents, totalDepartments, totalCourses, courseReportData);
            con.close();
            return homeReportData;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return homeReportData;
    }

    
    public static int addStudent(String firstName, String lastName , String email , Date DOB , String gender , long phoneNumber , String departmentName , Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            PreparedStatement prepare;
            int departmentID=0;
            //check for department id if exist
            PreparedStatement departmentIDPreapare = null;
            ResultSet rs = null;
            String query = "SELECT departmentID FROM departments WHERE DepartmentName = ?";
            departmentIDPreapare = con.prepareStatement(query);
            departmentIDPreapare.setString(1, departmentName);
            rs = departmentIDPreapare.executeQuery();
            if(rs.next())
                departmentID = rs.getInt("departmentID");
            //check for email is unique
            PreparedStatement emailCheck = null;
            rs = null;
            query = "SELECT 1 FROM students WHERE Email = ?";
            emailCheck = con.prepareStatement(query);
            emailCheck.setString(1, email);
            rs = emailCheck.executeQuery();
            if(rs.next())
                return -3;
            
            // if all satisfied then it will insert
            PreparedStatement pst = con.prepareStatement("insert into students(FIRSTNAME, LASTNAME, EMAIL, DOB, GENDER, PHONENUMBER, DEPARTMENTID)"
                    + " values (?,?,?,?,?,?,?)");
            //pst.setInt(1, studentID);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setDate(4, DOB);
            pst.setString(5, gender);
            pst.setLong(6, phoneNumber);
            pst.setLong(7, departmentID);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int updateStudent(int studentID, String firstName, String lastName , String email , Date DOB , String gender , long phoneNumber , String departmentName , Connection conn){
        int result = -1;
        try {
            //check for department id if exist
            PreparedStatement departmentCheck = null;
            ResultSet rs = null;
            int departmentID=0;
            //check for department id if exist
            PreparedStatement departmentIDPreapare = null;
            String query = "SELECT departmentID FROM departments WHERE DepartmentName = ?";
            departmentIDPreapare = conn.prepareStatement(query);
            departmentIDPreapare.setString(1, departmentName);
            rs = departmentIDPreapare.executeQuery();
            if(rs.next())
                departmentID = rs.getInt("departmentID");
            
            // Prepare the stored procedure call
            CallableStatement callableStatement = conn.prepareCall("{call updateStudent(?, ?, ?, ?, ?, ?, ?, ?)}");

            // Set the input parameters
            callableStatement.setInt(1, studentID);
            callableStatement.setString(2, firstName);
            callableStatement.setString(3, lastName);
            callableStatement.setString(4, email);
            callableStatement.setDate(5, DOB);
            callableStatement.setString(6, gender);
            callableStatement.setLong(7, phoneNumber);
            callableStatement.setInt(8, departmentID);

            // Execute the stored procedure
            result = callableStatement.executeUpdate();

            // Close the CallableStatement
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 00001) {
                result = -3;
            
            }
            else
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int deleteStudent(int studentID, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement pst = con.prepareStatement("delete from students where studentID = ? ");
            pst.setInt(1, studentID);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int addDepartmentCourse(int departmentID, int courseID, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            //check for course already in department if exist
            PreparedStatement departmentCheck = null;
            ResultSet rs = null;
            String query = "SELECT 1 FROM departmentcourses WHERE DepartmentID = ? and courseid = ?";
            departmentCheck = conn.prepareStatement(query);
            departmentCheck.setInt(1, departmentID);
            departmentCheck.setInt(2, courseID);
            rs = departmentCheck.executeQuery();
            if (rs.next())
                return -2;
            
            PreparedStatement pst = con.prepareStatement("insert into departmentcourses values (?,?)");
            pst.setInt(1, departmentID);
            pst.setInt(2, courseID);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int deleteDepartmentCourse(int departmentID, int courseID, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement departmentCheck = null;
            ResultSet rs = null;
            String query = "SELECT 1 FROM departmentcourses WHERE DepartmentID = ? and courseid = ?";
            departmentCheck = conn.prepareStatement(query);
            departmentCheck.setInt(1, departmentID);
            departmentCheck.setInt(2, courseID);
            rs = departmentCheck.executeQuery();
            if (!rs.next())
                return -2;
            
            PreparedStatement pst = con.prepareStatement("delete from departmentcourses where departmentid = ? and courseid = ?");
            pst.setInt(1, departmentID);
            pst.setInt(2, courseID);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int addDepartment(String departmentName, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement pst = con.prepareStatement("insert into departments (DEPARTMENTNAME) values (?)");
            //pst.setInt(1, departmentID);
            pst.setString(1, departmentName);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 00001) {
                result = -3;
            
            }
            else
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int deleteDepartment(int departmentID, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement pst = con.prepareStatement("delete from departments where departmentID = ?");
            pst.setInt(1, departmentID);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int updateDepartment(int departmentID, String departmentName, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            PreparedStatement pst = con.prepareStatement("update departments set departmentName = ? where departmentID = ?");
            pst.setString(1, departmentName);
            pst.setInt(2, departmentID);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 00001) {
                result = -3;
            
            }
            else
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int addCourse(String courseName, int noOfHours, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement pst = con.prepareStatement("insert into courses(COURSENAME, NOOFHOURS) values (?,?)");
            //pst.setInt(1, courseID);
            pst.setString(1, courseName);
            pst.setInt(2, noOfHours);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 00001) {
                result = -3;
            
            }
            else
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int deleteCourse(int courseID, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement pst = con.prepareStatement("delete from courses where courseid = ?");
            pst.setInt(1, courseID);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int updateCourse(int courseID, String courseName, int noOfHours, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            PreparedStatement pst = con.prepareStatement("update courses set courseName = ? , NoOfHours = ? where courseID = ?");
            pst.setString(1, courseName);
            pst.setInt(2, noOfHours);
            pst.setInt(3, courseID);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 00001) {
                result = -3;
            
            }
            else
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int addRegisterCourse(int studentID, int courseID, int year, int semester, String grade, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement pst = con.prepareStatement("insert into studentregistercourse values (?,?,?,?,?)");
            pst.setInt(1, studentID);
            pst.setInt(2, courseID);
            pst.setInt(3, year);
            pst.setInt(4, semester);
            pst.setNull(5,Types.INTEGER);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 20001) {
                result = -20001;
            
            }else if (ex.getErrorCode() == 20003) {
                result = -20003;
            
            }
            else if(ex.getErrorCode() == 20002){
                result = -20002;
            }
            else if(ex.getErrorCode() == 00001){
                result = -00001;
            }
            else {
                Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public static int deleteRegisterCourse(int studentID,int courseID,int year,int semester , Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement pst = con.prepareStatement("delete from studentRegisterCourse where studentid = ? and courseid = ?"
                    + "and year = ? and semester = ?");
            pst.setInt(1, studentID);
            pst.setInt(2, courseID);
            pst.setInt(3, year);
            pst.setInt(4, semester);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static int updateRegisterCourse(int studentID, int courseID, int year, int semester, String grade, Connection conn){
        int result = -1;
        try {
            //connection
            Connection con = conn;
            
            PreparedStatement pst = con.prepareStatement("update studentregistercourse set grade = ? where studentid = ? and courseid = ? "
                    + "and year = ? and semester = ?");
            if (grade != "null")
                pst.setInt(1, Integer.parseInt(grade));
            else
                pst.setNull(1,Types.INTEGER);
            pst.setInt(2, studentID);
            pst.setInt(3, courseID);
            pst.setInt(4, year);
            pst.setInt(5, semester);
            result = pst.executeUpdate();

            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return result;
    }
}
