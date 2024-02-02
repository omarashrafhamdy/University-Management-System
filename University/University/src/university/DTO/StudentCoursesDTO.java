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
public class StudentCoursesDTO {
    int courseID;
    String courseName;
    int noOfHours;
    int year;
    int semester;
    int mark;
    String grade;

    public StudentCoursesDTO(int courseID, String courseName, int year, int semester, int mark, String grade) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.year = year;
        this.semester = semester;
        this.mark = mark;
        this.grade = grade;
    }

    public StudentCoursesDTO(int courseID, String courseName,int noOfHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.noOfHours = noOfHours;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    public int getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(int noOfHours) {
        this.noOfHours = noOfHours;
    }
    
}
