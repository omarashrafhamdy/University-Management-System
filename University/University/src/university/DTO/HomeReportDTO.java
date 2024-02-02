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
public class HomeReportDTO {
    int totalStudents;
    int totalDepartments;
    int totalCourses;
    ObservableList<CourseDTO> CourseReport;

    public HomeReportDTO(int totalStudents, int totalDepartments, int totalCourses, ObservableList<CourseDTO> CourseReport) {
        this.totalStudents = totalStudents;
        this.totalDepartments = totalDepartments;
        this.totalCourses = totalCourses;
        this.CourseReport = CourseReport;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalDepartments() {
        return totalDepartments;
    }

    public void setTotalDepartments(int totalDepartments) {
        this.totalDepartments = totalDepartments;
    }

    public int getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(int totalCourses) {
        this.totalCourses = totalCourses;
    }

    public ObservableList<CourseDTO> getCourseReport() {
        return CourseReport;
    }

    public void setCourseReport(ObservableList<CourseDTO> CourseReport) {
        this.CourseReport = CourseReport;
    }
    
}
