/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.DTO;

import java.sql.Date;
import javafx.collections.ObservableList;

/**
 *
 * @author OMAR
 */
public class StudentDTO {
    int studentID;
    String firstName;
    String lastName;
    String email;
    Date DOB;
    String gender;
    long phoneNumber;
    int departmentID;
    String departmentName;
    double GPA;
    ObservableList<StudentCoursesDTO> studentCourses;
    int level;
    public StudentDTO(int studentID, String firstName, String lastName, String email, Date DOB, String gender, long phoneNumber, int departmentID, String departmentName,double GPA,ObservableList<StudentCoursesDTO> studentCourses, int level) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DOB = DOB;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.GPA = GPA;
        this.studentCourses = studentCourses;
        this.level = level;
    }

    public StudentDTO(int studentID, String firstName, String lastName, String email, Date DOB, String gender, long phoneNumber, int departmentID, String departmentName, ObservableList<StudentCoursesDTO> studentCourses) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DOB = DOB;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.studentCourses = studentCourses;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public ObservableList<StudentCoursesDTO> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(ObservableList<StudentCoursesDTO> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
}
