/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.DTO;

/**
 *
 * @author OMAR
 */
public class StudentReportDTO {
    int studentID;
    String firstName;
    String lastName;
    int year;
    int semester;
    int mark;
    String grade;

    public StudentReportDTO(int studentID, String firstName, String lastName, int year, int semester, int mark, String grade) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.semester = semester;
        this.mark = mark;
        this.grade = grade;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
}
