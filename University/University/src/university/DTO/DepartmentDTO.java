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
public class DepartmentDTO {

    int departmentID;
    String departmentName;
    ObservableList<CourseDTO> departmentCourses;
    ObservableList<CourseDTO> departmentNotAssignedCourses;

    public DepartmentDTO(int departmentID, String departmentName, ObservableList<CourseDTO> departmentCourses , ObservableList<CourseDTO> departmentNotAssignedCourses) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentCourses = departmentCourses;
        this.departmentNotAssignedCourses = departmentNotAssignedCourses;
    }

    public DepartmentDTO(String departmentName) {
        this.departmentName = departmentName;
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

    public ObservableList<CourseDTO> getDepartmentCourses() {
        return departmentCourses;
    }

    public void setDepartmentCourses(ObservableList<CourseDTO> departmentCourses) {
        this.departmentCourses = departmentCourses;
    }

    public ObservableList<CourseDTO> getDepartmentNotAssignedCourses() {
        return departmentNotAssignedCourses;
    }

    public void setDepartmentNotAssignedCourses(ObservableList<CourseDTO> departmentNotAssignedCourses) {
        this.departmentNotAssignedCourses = departmentNotAssignedCourses;
    }
    
    
}
