/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.DTO;

import javafx.collections.ObservableList;

/**
 *
 * @author OMAR
 */
public class CourseDTO {
    int courseID;
    String courseName;
    double courseGPA;
    int noOfHours;
    int noPassed;
    int noFailed;
    ObservableList<StudentReportDTO> studentReport;

    public CourseDTO(int courseID, String courseName, int noOfHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.noOfHours = noOfHours;
    }

    public CourseDTO(int courseID, String courseName, double courseGPA, int noOfHours, int noPassed, int noFailed, ObservableList<StudentReportDTO> studentReport) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseGPA = courseGPA;
        this.noOfHours = noOfHours;
        this.noPassed = noPassed;
        this.noFailed = noFailed;
        this.studentReport = studentReport;
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

    public int getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(int noOfHours) {
        this.noOfHours = noOfHours;
    }

    public ObservableList<StudentReportDTO> getStudentReport() {
        return studentReport;
    }

    public void setStudentReport(ObservableList<StudentReportDTO> studentReport) {
        this.studentReport = studentReport;
    }

    public int getNoPassed() {
        return noPassed;
    }

    public void setNoPassed(int noPassed) {
        this.noPassed = noPassed;
    }

    public int getNoFailed() {
        return noFailed;
    }

    public void setNoFailed(int noFailed) {
        this.noFailed = noFailed;
    }

    public double getCourseGPA() {
        return courseGPA;
    }

    public void setCourseGPA(double courseGPA) {
        this.courseGPA = courseGPA;
    }
    
}
