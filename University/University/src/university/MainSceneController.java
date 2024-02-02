/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import Database.ConnectionSingleton;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import university.DTO.CourseDTO;
import university.DTO.DepartmentDTO;
import university.DTO.HomeReportDTO;
import university.DTO.RegisterCourseDTO;
import university.DTO.StudentCoursesDTO;
import university.DTO.StudentDTO;
import university.DTO.StudentReportDTO;
import university.Database.DataAccessLayer;

/**
 * FXML Controller class
 *
 * @author OMAR
 */
public class MainSceneController implements Initializable {

    @FXML
    private AnchorPane homeScene;
    @FXML
    private AnchorPane studentScene;
    @FXML
    private TextField studentSearchTxt;
    @FXML
    private TableView<StudentDTO> studentTable;
    @FXML
    private TextField studentIDTxt;
    @FXML
    private TextField studentFirstNameTxt;
    @FXML
    private TextField studentLastNameTxt;
    @FXML
    private TextField studentEmailTxt;
    @FXML
    private TextField studentPhoneNumberTxt;
    @FXML
    private Button studentAddBtn;
    @FXML
    private Button studentUpdateDtn;
    @FXML
    private Button studentDeleteBtn;
    @FXML
    private ComboBox<String> studentGenderCombo;
    @FXML
    private DatePicker studentDOBTxt;
    @FXML
    private Button studentClearBtn;
    @FXML
    private TableView<StudentCoursesDTO> studentCoursesTable;
    @FXML
    private AnchorPane departmentScene;
    @FXML
    private TableView<DepartmentDTO> departmentsTable;
    @FXML
    private TextField departmentIDTxt;
    @FXML
    private TextField departmentNameTxt;
    @FXML
    private Button departmentAddBtn;
    @FXML
    private Button departmentUpdateBtn;
    @FXML
    private Button departmentDeleteBtn;
    @FXML
    private Button departmentClearBtn;
    @FXML
    private Button departmentCourseAddBtn;
    @FXML
    private Button departmentCourseDeleteBtn;
    @FXML
    private Button departmentCourseClearBtn;
    @FXML
    private TableView<CourseDTO> departmentCoursesTable;
    @FXML
    private AnchorPane courseScene;
    @FXML
    private TableView<CourseDTO> coursesTable;
    @FXML
    private TextField courseIDTxt;
    @FXML
    private TextField courseNameTxt;
    @FXML
    private Button courseAddBtn;
    @FXML
    private Button courseUpdateBtn;
    @FXML
    private Button courseDeleteBtn;
    @FXML
    private Button courseCLearBtn;
    @FXML
    private TextField NoOfHoursTxt;
    @FXML
    private Button homeSceneBtn;
    @FXML
    private Button studentSceneBtn;
    @FXML
    private Button departmentSceneBtn;
    @FXML
    private Button courseSceneBtn;

    @FXML
    private TableColumn<StudentDTO, String> studentIDColumn;
    @FXML
    private TableColumn<StudentDTO, String> studentFirstNameColumn;
    @FXML
    private TableColumn<StudentDTO, String> studentLastNameColumn;
    @FXML
    private TableColumn<StudentDTO, String> studentEmailColumn;
    @FXML
    private TableColumn<StudentDTO, String> studentDOBColumn;
    @FXML
    private TableColumn<StudentDTO, String> studentGenderColumn;
    @FXML
    private TableColumn<StudentDTO, String> studentPhoneNumberColumn;
    @FXML
    private TableColumn<StudentDTO, String> studentDepartmentIDColumn;
    @FXML
    private TableColumn<StudentDTO, String> studentDepartmentNameColumn;
    
    private ObservableList<StudentDTO> addStudentsListD;
    private ObservableList<DepartmentDTO> addDepartmentsListD;
    private ObservableList<CourseDTO> addCoursesListD;
    private ObservableList<RegisterCourseDTO> addRegisterCoursesListD;
    private ObservableList<CourseDTO> addHomeCoursesListD;
    private ObservableList<StudentDTO> addStudentCoursesListD;
    
    @FXML
    private TextField studentDepartmentTxt;
    @FXML
    private Label gpaLabel;
    @FXML
    private TableColumn<StudentCoursesDTO, String> studentCourseIDColumn;
    @FXML
    private TableColumn<StudentCoursesDTO, String> studentCourseNameColumn;
    @FXML
    private TableColumn<StudentCoursesDTO, String> studentCourseYearColumn;
    @FXML
    private TableColumn<StudentCoursesDTO, String> studentCourseSemesterColumn;
    @FXML
    private TableColumn<StudentCoursesDTO, String> studentCourseGradeColumn;
    @FXML
    private TableColumn<?, ?> studentCourseMarkColumn;
    @FXML
    private TableColumn<?, ?> departmentIDCoulumn;
    @FXML
    private TableColumn<?, ?> departmentNameColumn;
    @FXML
    private TableColumn<?, ?> departmentCourseIDColumn;
    @FXML
    private TableColumn<?, ?> departmentCourseNameColumn;
    @FXML
    private TableColumn<?, ?> departmentCourseNoOfHoursColumn;
    @FXML
    private TextField departmentCourseIDTxt;
    @FXML
    private TableColumn<?, ?> courseIDColumn;
    @FXML
    private TableColumn<?, ?> courseNameColumn;
    @FXML
    private TableColumn<?, ?> courseNoOfHoursColumn;
    @FXML
    private AnchorPane registerCourseScene;
    @FXML
    private TableView<RegisterCourseDTO> registerCourseTable;
    @FXML
    private TableColumn<?, ?> registerCourseStudentIDColumn;
    @FXML
    private TableColumn<?, ?> registerCourseStudentNameColumn;
    @FXML
    private TableColumn<?, ?> registerCourseCourseIDColumn;
    @FXML
    private TableColumn<?, ?> registerCourseCourseNameColumn;
    @FXML
    private TableColumn<?, ?> registerCourseYearColumn;
    @FXML
    private TableColumn<?, ?> registerCourseSemesterColumn;
    @FXML
    private TableColumn<?, ?> registerCourseMarkColumn;
    @FXML
    private TableColumn<?, ?> registerCourseGradeColumn;
    @FXML
    private TextField registerCourseStudentIDTxt;
    @FXML
    private TextField registerCourseCourseIDTxt;
    @FXML
    private TextField registerCourseYearTxt;
    @FXML
    private TextField registerCourseSemesterTxt;
    @FXML
    private TextField registerCourseMarkTxt;
    @FXML
    private Button registerCourseAddBtn;
    @FXML
    private Button registerCourseUpdateBtn;
    @FXML
    private Button registerCourseDeleteBtn;
    @FXML
    private Button registerCourseClearBtn;
    @FXML
    private Button registerCourseSceneBtn;
    @FXML
    private Label totStudentsLabel;
    @FXML
    private Label totDepartmentsLabel;
    @FXML
    private Label totCoursesLabel;
    @FXML
    private TableView<CourseDTO> homeCoursesTable;
    @FXML
    private TableColumn<?, ?> homeCourseIDColumn;
    @FXML
    private TableColumn<?, ?> homeCourseNameColumn;
    @FXML
    private TableColumn<?, ?> homeNoOfHoursColumn;
    @FXML
    private TableColumn<?, ?> homeAvgGPAColumn;
    @FXML
    private TableView<StudentReportDTO> homeStudentsTable;
    @FXML
    private TableColumn<?, ?> homeStudentIDColumn;
    @FXML
    private TableColumn<?, ?> homeFirstNameColumn;
    @FXML
    private TableColumn<?, ?> homeLastNameColumn;
    @FXML
    private TableColumn<?, ?> homeYearColumn;
    @FXML
    private TableColumn<?, ?> homeSemesterColumn;
    @FXML
    private TableColumn<?, ?> homeMarkColumn;
    @FXML
    private TableColumn<?, ?> homeGradeColumn;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> homeBarChart;
    @FXML
    private TableColumn<?, ?> homePassColumn;
    @FXML
    private TableColumn<?, ?> homeFailColumn;
    @FXML
    private Button logoutBtn;
    @FXML
    private TableView<CourseDTO> departmentNotAssignedCoursesTable;
    @FXML
    private TableColumn<?, ?> departmentNotAssignedCourseIDColumn;
    @FXML
    private TableColumn<?, ?> departmentNotAssignedCourseNameColumn;
    @FXML
    private TableColumn<?, ?> departmentNotAssignedCoursesColumn;
    @FXML
    private Label levelLabel;
    @FXML
    private ComboBox<String> studentDepartmentCombo;
    @FXML
    private ComboBox<String> registerCourseCourseNameCombo;
    @FXML
    private Button studentCoursesSceneBtn;
    @FXML
    private AnchorPane studentCoursesScene;
    @FXML
    private Button studentCoursesAddBtn;
    @FXML
    private Button studentCoursesClearBtn;
    @FXML
    private TableColumn<?, ?> studentCoursesStudentIDColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesFirstNameColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesLastNameColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesEmailColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesDOBColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesGenderColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesPhoneNumberColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesDepartmentIDColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesDepartmentNameColumn;
    @FXML
    private TableView<StudentCoursesDTO> studentCoursesCourseTable;
    @FXML
    private TableColumn<?, ?> studentCoursesCourseIDColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesCourseNameColumn;
    @FXML
    private TableColumn<?, ?> studentCoursesNoOfHoursColumn;
    @FXML
    private TextField studentCoursesStudentIDTxt;
    @FXML
    private TextField studentCoursesCourseIDTxt;
    @FXML
    private TextField studentCoursesYearTxt;
    @FXML
    private TextField studentCoursesSemesterTxt;
    @FXML
    private TableView<StudentDTO> studentCoursesRegisterTable;
    /* ********************************************************************************************* */
    /*for home scene and functions of it*/
    //add homedata in tables
    public void addHomeShowListData() {
        HomeReportDTO homeReport = DataAccessLayer.getHomeReportData(ConnectionSingleton.connectDB());
        totStudentsLabel.setText(String.valueOf(homeReport.getTotalStudents()));
        totDepartmentsLabel.setText(String.valueOf(homeReport.getTotalDepartments()));
        totCoursesLabel.setText(String.valueOf(homeReport.getTotalCourses()));
        
        addHomeCoursesListD=homeReport.getCourseReport();
        homeCourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        homeCourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        homeNoOfHoursColumn.setCellValueFactory(new PropertyValueFactory<>("noOfHours"));
        homeAvgGPAColumn.setCellValueFactory(new PropertyValueFactory<>("courseGPA"));
        homePassColumn.setCellValueFactory(new PropertyValueFactory<>("noPassed"));
        homeFailColumn.setCellValueFactory(new PropertyValueFactory<>("noFailed"));
        
        homeCoursesTable.setItems(addHomeCoursesListD);

    }
    //add students in tableview from selected course and the pie , bar charts
    @FXML
    public void addSelectedHomeCourseInText(){
        CourseDTO homeCourse = homeCoursesTable.getSelectionModel().getSelectedItem();

        if (homeCourse != null) {
            ObservableList<StudentReportDTO> studentReportList = homeCourse.getStudentReport();
            homeStudentIDColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));
            homeFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            homeLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            homeYearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
            homeSemesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
            homeMarkColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));
            homeGradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
            homeStudentsTable.setItems(studentReportList);
            
            pieChart.getData().clear();

            // Add a slice for noPassed
            PieChart.Data passedData = new PieChart.Data("Passed", homeCourse.getNoPassed());

            // Add a slice for noFailed
            PieChart.Data failedData = new PieChart.Data("Failed", homeCourse.getNoFailed());

            pieChart.getData().addAll(passedData, failedData);
            
            // Clear existing data in the bar chart
            homeBarChart.getData().clear();

            // Create a new series for the bar chart
            XYChart.Series<String, Number> series = new XYChart.Series<>();

            // Iterate through the studentReportList and add data to the series
            for (StudentReportDTO studentReport : studentReportList) {
                String studentID = String.valueOf(studentReport.getStudentID());
                int grade = studentReport.getMark();

                // Add a data point to the series
                series.getData().add(new XYChart.Data<>(studentID, grade));
            }

            homeBarChart.getXAxis().setAnimated(false); // Disable animation for better performance
            homeBarChart.getXAxis().setTickLabelsVisible(true);
            homeBarChart.getXAxis().setTickMarkVisible(true);
            NumberAxis yAxis = (NumberAxis) homeBarChart.getYAxis();
            yAxis.setAutoRanging(false);
            yAxis.setLowerBound(0);
            yAxis.setUpperBound(100);
            // Add the series to the bar chart
            homeBarChart.setAnimated(false);
            homeBarChart.getData().add(series);
            
        }
    }
    //clear home scene
    public void clearHomeData(){
        homeCoursesTable.getSelectionModel().clearSelection();
        homeStudentsTable.setItems(null);
        pieChart.getData().clear();
        homeBarChart.getData().clear();
    }
    
    /* for student scene add student data in the table view */
    public void addStudentsShowListData() {
        addStudentsListD = DataAccessLayer.getStudentData(ConnectionSingleton.connectDB());

        studentIDColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        studentFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        studentLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        studentDOBColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        studentGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        studentPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        studentDepartmentIDColumn.setCellValueFactory(new PropertyValueFactory<>("departmentID"));
        studentDepartmentNameColumn.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        
        studentTable.setItems(addStudentsListD);
    }

    public void addStudentsDepartmentList() {
        ObservableList ObList = DataAccessLayer.getDepartmentNamesData(ConnectionSingleton.connectDB());
        studentDepartmentCombo.setItems(ObList);
    }
    
    //add gender list in combo
    private String[] genderList = {"M", "F"};

    public void addStudentsGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        studentGenderCombo.setItems(ObList);
    }
    //add selected student in the textfields
    @FXML
    public void addSelectedStudentInText(){
        StudentDTO studentData = studentTable.getSelectionModel().getSelectedItem();
        if (studentData != null){
            studentIDTxt.setText(String.valueOf(studentData.getStudentID()));
            studentFirstNameTxt.setText(studentData.getFirstName());
            studentLastNameTxt.setText(studentData.getLastName());
            studentEmailTxt.setText(studentData.getEmail());
            studentDOBTxt.setValue(studentData.getDOB().toLocalDate());
            studentPhoneNumberTxt.setText(String.valueOf(studentData.getPhoneNumber()));
            studentDepartmentTxt.setText(String.valueOf(studentData.getDepartmentID()));
            studentGenderCombo.setValue(studentData.getGender());
            studentDepartmentCombo.setValue(studentData.getDepartmentName());
            gpaLabel.setText(String.valueOf(studentData.getGPA()));
            levelLabel.setText(String.valueOf(studentData.getLevel()));

            ObservableList<StudentCoursesDTO> studentsCoursesList = studentData.getStudentCourses();
            studentCourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseID"));
            studentCourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
            studentCourseYearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
            studentCourseSemesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
            studentCourseMarkColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));
            studentCourseGradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
            studentCoursesTable.setItems(studentsCoursesList);
        }
        
    }
    //add student data
    @FXML
    public void addStudent(){
        Alert alert;

        if ( studentFirstNameTxt.getText().isEmpty()
                || studentLastNameTxt.getText().isEmpty()
                || studentEmailTxt.getText().isEmpty()
                || studentDOBTxt.getValue() == null
                || studentGenderCombo.getSelectionModel().getSelectedItem() == null
                || studentPhoneNumberTxt.getText().isEmpty()
                || studentDepartmentCombo.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else if (!studentEmailTxt.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email format");
            alert.showAndWait();
        } else if (!studentPhoneNumberTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Phone number should contain only numbers");
            alert.showAndWait();
        } /*else if (!studentDepartmentTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Department ID should contain only numbers");
            alert.showAndWait();
        }*/
        else{
            // Assuming studentDOBTxt is a DatePicker
            LocalDate localDate = studentDOBTxt.getValue();

            // Convert LocalDate to java.sql.Date
            java.sql.Date sqlDate = Date.valueOf(localDate);
            int result = DataAccessLayer.addStudent(
                    studentFirstNameTxt.getText(),
                    studentLastNameTxt.getText(),
                    studentEmailTxt.getText(),
                    sqlDate,  // Use the converted java.sql.Date object
                    studentGenderCombo.getSelectionModel().getSelectedItem(),
                    Long.parseLong(studentPhoneNumberTxt.getText()),
                    studentDepartmentCombo.getSelectionModel().getSelectedItem(),  // Assuming DepartmentID is an Integer
                    ConnectionSingleton.connectDB()
            );
            if (result == -2){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in adding student, Enter correct department id");
                alert.showAndWait();
            }else if (result == -3){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in adding student, Email must be unique");
                alert.showAndWait();
            }
            else if (result == -1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error");
                alert.showAndWait();
                
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();
                addStudentsShowListData();
                clearStudentData();
            }
        }
            
    }
    // update student data
    @FXML
    public void updateStudent(){
        Alert alert;

        if (studentIDTxt.getText().isEmpty()
                || studentFirstNameTxt.getText().isEmpty()
                || studentLastNameTxt.getText().isEmpty()
                || studentEmailTxt.getText().isEmpty()
                || studentDOBTxt.getValue() == null
                || studentGenderCombo.getSelectionModel().getSelectedItem() == null
                || studentPhoneNumberTxt.getText().isEmpty()
                || studentDepartmentCombo.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else if (!studentIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Student ID should contain only numbers");
            alert.showAndWait();
        } else if (!studentEmailTxt.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email format");
            alert.showAndWait();
        } else if (!studentPhoneNumberTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Phone number should contain only numbers");
            alert.showAndWait();
        } /*else if (!studentDepartmentTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Department ID should contain only numbers");
            alert.showAndWait();
        }*/
        else{
            // Assuming studentDOBTxt is a DatePicker
            LocalDate localDate = studentDOBTxt.getValue();

            // Convert LocalDate to java.sql.Date
            java.sql.Date sqlDate = Date.valueOf(localDate);
            int result = DataAccessLayer.updateStudent(
                    Integer.valueOf(studentIDTxt.getText()),
                    studentFirstNameTxt.getText(),
                    studentLastNameTxt.getText(),
                    studentEmailTxt.getText(),
                    sqlDate,  // Use the converted java.sql.Date object
                    studentGenderCombo.getSelectionModel().getSelectedItem(),
                    Long.valueOf(studentPhoneNumberTxt.getText()),
                    studentDepartmentCombo.getSelectionModel().getSelectedItem(),  // Assuming DepartmentID is an Integer
                    ConnectionSingleton.connectDB()
            );
            if (result == -2){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in updating student, Enter correct department id");
                alert.showAndWait();
            }else if (result == -3){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in updating student, Email must be unique");
                alert.showAndWait();
            }
            else if (result == -1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error");
                alert.showAndWait();
                
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();
                addStudentsShowListData();
                clearStudentData();
            }
        }
            
    }
    // delete student data
    @FXML
    public void deleteStudent(){
        Alert alert;

        if (studentIDTxt.getText().isEmpty()
                || studentFirstNameTxt.getText().isEmpty()
                || studentLastNameTxt.getText().isEmpty()
                || studentEmailTxt.getText().isEmpty()
                || studentDOBTxt.getValue() == null
                || studentGenderCombo.getSelectionModel().getSelectedItem() == null
                || studentPhoneNumberTxt.getText().isEmpty()
                || studentDepartmentTxt.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else if (!studentIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Student ID should contain only numbers");
            alert.showAndWait();
        } else if (!studentEmailTxt.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email format");
            alert.showAndWait();
        } else if (!studentPhoneNumberTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Phone number should contain only numbers");
            alert.showAndWait();
        } else if (!studentDepartmentTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Department ID should contain only numbers");
            alert.showAndWait();
        }
        else{
            // Assuming studentDOBTxt is a DatePicker
            LocalDate localDate = studentDOBTxt.getValue();

            // Convert LocalDate to java.sql.Date
            java.sql.Date sqlDate = Date.valueOf(localDate);
            int result = DataAccessLayer.deleteStudent(
                    Integer.parseInt(studentIDTxt.getText()),
                    ConnectionSingleton.connectDB()
            );
            if (result != -1){
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();
                addStudentsShowListData();
                clearStudentData();
            }
            else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in delete");
                alert.showAndWait();
            }
        }
            
    }
    // clear student data
    @FXML
    public void clearStudentData(){
        studentTable.getSelectionModel().clearSelection();
        studentIDTxt.clear();
        studentFirstNameTxt.clear();
        studentLastNameTxt.clear();
        studentEmailTxt.clear();
        studentDOBTxt.setValue(null);
        studentGenderCombo.getSelectionModel().clearSelection();
        studentPhoneNumberTxt.clear();
        studentDepartmentTxt.clear();
        gpaLabel.setText("");
        studentCoursesTable.setItems(null);
        studentDepartmentCombo.getSelectionModel().clearSelection();
        levelLabel.setText("");
    }
    
    /* ***************************************************************************************************** */
    /*from here departments scene and all functions inside it*/
    public void addDepartmentsShowListData() {
        addDepartmentsListD = DataAccessLayer.getDepartmentData(ConnectionSingleton.connectDB());

        departmentIDCoulumn.setCellValueFactory(new PropertyValueFactory<>("departmentID"));
        departmentNameColumn.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        
        departmentsTable.setItems(addDepartmentsListD);
    }
    //add selected department in textfields and the courses of the department
    @FXML
    public void addSelectedDepartmentInText(){
        DepartmentDTO departmentData = departmentsTable.getSelectionModel().getSelectedItem();

        if (departmentData != null) {
            departmentIDTxt.setText(String.valueOf(departmentData.getDepartmentID()));
            departmentNameTxt.setText(departmentData.getDepartmentName());

            ObservableList<CourseDTO> departmentCoursesList = departmentData.getDepartmentCourses();
            departmentCourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseID"));
            departmentCourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
            departmentCourseNoOfHoursColumn.setCellValueFactory(new PropertyValueFactory<>("noOfHours"));
            departmentCoursesTable.setItems(departmentCoursesList);
            
            ObservableList<CourseDTO> departmentNotAssignedCoursesList = departmentData.getDepartmentNotAssignedCourses();
            departmentNotAssignedCourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseID"));
            departmentNotAssignedCourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
            departmentNotAssignedCoursesColumn.setCellValueFactory(new PropertyValueFactory<>("noOfHours"));
            departmentNotAssignedCoursesTable.setItems(departmentNotAssignedCoursesList);
        }
    }
    // add department course in txt
    @FXML
    public void addSelectedDepartmentCourseInText(){
        CourseDTO courseData = departmentCoursesTable.getSelectionModel().getSelectedItem();
        if (courseData != null) {
            departmentCourseIDTxt.setText(String.valueOf(courseData.getCourseID()));
        }
    }
    @FXML
    public void addSelectedDepartmentNotAssignedCourseInText(){
        CourseDTO courseData = departmentNotAssignedCoursesTable.getSelectionModel().getSelectedItem();
        if (courseData != null) {
            departmentCourseIDTxt.setText(String.valueOf(courseData.getCourseID()));
        }
    }
    //clear all department data
    @FXML
    public void clearDepartmentData(){
        departmentsTable.getSelectionModel().clearSelection();
        departmentIDTxt.clear();
        departmentNameTxt.clear();
        departmentCourseIDTxt.clear();
        departmentCoursesTable.setItems(null);
        departmentNotAssignedCoursesTable.setItems(null);
    }
    //clear department course data
    @FXML
    public void clearDepartmentCourseData(){
        departmentCoursesTable.getSelectionModel().clearSelection();
        departmentNotAssignedCoursesTable.getSelectionModel().clearSelection();
        departmentCourseIDTxt.clear();
    }
    //add course in specific department
    @FXML
    public void addDepartmentCourse(){
        Alert alert;
        DepartmentDTO departmentData = departmentsTable.getSelectionModel().getSelectedItem();
        if (departmentCourseIDTxt.getText().isEmpty() || departmentIDTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.addDepartmentCourse(departmentData.getDepartmentID(), Integer.parseInt(departmentCourseIDTxt.getText()), ConnectionSingleton.connectDB());
            if (result == -2){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in adding course, The Course Already In Department");
                alert.showAndWait();
            }
            else if (result == -1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error");
                alert.showAndWait();
                
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Course Successfully Added!");
                alert.showAndWait();
                addDepartmentsShowListData();
                clearDepartmentData();
            }
        }
    }
    //delete course in specific department
    @FXML
    public void deleteDepartmentCourse(){
        Alert alert;
        DepartmentDTO departmentData = departmentsTable.getSelectionModel().getSelectedItem();
        if (departmentCourseIDTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.deleteDepartmentCourse(departmentData.getDepartmentID(), Integer.parseInt(departmentCourseIDTxt.getText()), ConnectionSingleton.connectDB());
            if (result == -2){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in deleting course, Department Doesn't have the course");
                alert.showAndWait();
            }
            else if (result == -1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error");
                alert.showAndWait();
                
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Course Successfully Deleted!");
                alert.showAndWait();
                addDepartmentsShowListData();
                clearDepartmentData();
            }
        }
    }
    //add new department
    @FXML
    public void addDepartment(){
        Alert alert;
        if ( departmentNameTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.addDepartment(departmentNameTxt.getText(), ConnectionSingleton.connectDB());
            if(result==-3){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Department Name Must Be Unique");
                alert.showAndWait();
            }
            else if(result==-1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in adding department");
                alert.showAndWait();
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Department Successfully Added!");
                alert.showAndWait();
                addDepartmentsShowListData();
                clearDepartmentData();
            }
        }
    }
    // delete department
    @FXML
    public void deleteDepartment(){
        Alert alert;
        if (departmentIDTxt.getText().isEmpty() || departmentNameTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else if (!departmentIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Department ID should contain only numbers");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.deleteDepartment(Integer.parseInt(departmentIDTxt.getText()), ConnectionSingleton.connectDB());
            if(result!=-1){
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Department Successfully Deleted!");
                alert.showAndWait();
                addDepartmentsShowListData();
                clearDepartmentData();
            }
            else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in deleting department");
                alert.showAndWait();
            }
        }
    }
    //update department
    @FXML
    public void updateDepartment(){
        Alert alert;
        if (departmentIDTxt.getText().isEmpty() || departmentNameTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else if (!departmentIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Department ID should contain only numbers");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.updateDepartment(Integer.parseInt(departmentIDTxt.getText()),departmentNameTxt.getText() , ConnectionSingleton.connectDB());
            if(result==-3){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Department Name Must Be Unique");
                alert.showAndWait();
            }
            else if(result==-1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in updating department");
                alert.showAndWait();
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Department Successfully Updated!");
                alert.showAndWait();
                addDepartmentsShowListData();
                clearDepartmentData();
            }
        }
    }
    
    /* ******************************************************************************************* */
    /*from here course scene and functions inside it*/
    //add courses in tableview
    public void addCoursesShowListData() {
        addCoursesListD = DataAccessLayer.getCourseData(ConnectionSingleton.connectDB());
        courseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseNoOfHoursColumn.setCellValueFactory(new PropertyValueFactory<>("noOfHours"));
        
        coursesTable.setItems(addCoursesListD);
    }
    //add selected course in textfields
    @FXML
    public void addSelectedCourseInText(){
        CourseDTO courseData = coursesTable.getSelectionModel().getSelectedItem();

        if (courseData != null) {
            courseIDTxt.setText(String.valueOf(courseData.getCourseID()));
            courseNameTxt.setText(courseData.getCourseName());
            NoOfHoursTxt.setText(String.valueOf(courseData.getNoOfHours()));
        }
    }
    //clear selected course
    @FXML
    public void clearCourseData(){
        coursesTable.getSelectionModel().clearSelection();
        courseIDTxt.clear();
        courseNameTxt.clear();
        NoOfHoursTxt.clear();
    }
    //add course
    @FXML
    public void addCourse(){
        Alert alert;
        if (courseNameTxt.getText().isEmpty() || NoOfHoursTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else if (!NoOfHoursTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("No of hours should contain only numbers");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.addCourse(courseNameTxt.getText(), Integer.parseInt(NoOfHoursTxt.getText()), ConnectionSingleton.connectDB());
            if(result==-3){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Course Name Must Be Unqiue");
                alert.showAndWait();
            }else if(result==-1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in adding course");
                alert.showAndWait();
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Course Successfully Added!");
                alert.showAndWait();
                addCoursesShowListData();
                clearCourseData();
            }
        }
    }
    //delete course
    @FXML
    public void deleteCourse(){
        Alert alert;
        if (courseIDTxt.getText().isEmpty() || courseNameTxt.getText().isEmpty() || NoOfHoursTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else if (!courseIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Department ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!NoOfHoursTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("No of hours should contain only numbers");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.deleteCourse(Integer.parseInt(courseIDTxt.getText()), ConnectionSingleton.connectDB());
            if(result!=-1){
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Course Successfully Deleted!");
                alert.showAndWait();
                addCoursesShowListData();
                clearCourseData();
            }
            else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in deleting course");
                alert.showAndWait();
            }
        }
    }
    //update course
    @FXML
    public void updateCourse(){
        Alert alert;
        if (courseIDTxt.getText().isEmpty() || courseNameTxt.getText().isEmpty() || NoOfHoursTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }
        else if (!courseIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Department ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!NoOfHoursTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("No of hours should contain only numbers");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.updateCourse(Integer.parseInt(courseIDTxt.getText()), courseNameTxt.getText(), Integer.parseInt(NoOfHoursTxt.getText()), ConnectionSingleton.connectDB());
            if(result==-3){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Course Name Must Be Unqiue");
                alert.showAndWait();
            }else if(result==-1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in updating course");
                alert.showAndWait();
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Course Successfully Updated!");
                alert.showAndWait();
                addCoursesShowListData();
                clearCourseData();
            }
        }
    }
    
    /* ********************************************************************************************** */
    /* register course scene and all functions of it*/
    //add registercourses data in the table view
    public void addRegisterCourseShowListData() {
        addRegisterCoursesListD = DataAccessLayer.getRegisterCourseData(ConnectionSingleton.connectDB());

        registerCourseStudentIDColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        registerCourseStudentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        registerCourseCourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        registerCourseCourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        registerCourseYearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        registerCourseSemesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));
        registerCourseMarkColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));
        registerCourseGradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        
        registerCourseTable.setItems(addRegisterCoursesListD);
    }
    //add selected registercourse in text fields
    @FXML
    public void addSelectedRegisterCourseInText(){
        RegisterCourseDTO registerCourseData = registerCourseTable.getSelectionModel().getSelectedItem();

        if (registerCourseData != null) {
            registerCourseStudentIDTxt.setText(String.valueOf(registerCourseData.getStudentID()));
            registerCourseCourseIDTxt.setText(String.valueOf(registerCourseData.getCourseID()));
            registerCourseYearTxt.setText(String.valueOf(registerCourseData.getYear()));
            registerCourseSemesterTxt.setText(String.valueOf(registerCourseData.getSemester()));
            registerCourseMarkTxt.setText(String.valueOf(registerCourseData.getMark()));
            registerCourseCourseNameCombo.setValue(registerCourseData.getCourseName());
            
            //ObservableList ObList = DataAccessLayer.getStudentCoursesData(registerCourseData.getStudentID(),ConnectionSingleton.connectDB());
            //registerCourseCourseNameCombo.setItems(ObList);
        }
    }
    
    /*public void addStudentCoursesList() {
        
        registerCourseStudentIDTxt.textProperty().addListener((observable, oldValue, newValue) -> {
        // newValue contains the updated content of the text field
            try {
                int studentID;
                // Parse the newValue to an integer and update the studentID variable
                int newStudentID = Integer.parseInt(newValue);
                studentID = newStudentID;
                
                // Fetch and update the student courses based on the new studentID
                ObservableList ObList = DataAccessLayer.getStudentCoursesData(studentID,ConnectionSingleton.connectDB());
                registerCourseCourseNameCombo.setItems(ObList);
            } catch (NumberFormatException e) {
                // Handle the case where newValue is not a valid integer
                // You may display an error message or take appropriate action
            }
        });
    }*/
    
    //clear registercourse data
    @FXML
    public void clearRegisterCourseData(){
        registerCourseTable.getSelectionModel().clearSelection();
        registerCourseStudentIDTxt.clear();
        registerCourseCourseIDTxt.clear();
        registerCourseYearTxt.clear();
        registerCourseSemesterTxt.clear();
        registerCourseMarkTxt.clear();
        registerCourseCourseNameCombo.getSelectionModel().clearSelection();
        registerCourseCourseNameCombo.getSelectionModel().select(null);
        registerCourseCourseNameCombo.getItems().clear();
    }
    /*
    @FXML
    public void addRegisterCourse(){
        String mark;
        Alert alert;
        if (registerCourseStudentIDTxt.getText().isEmpty() || registerCourseCourseIDTxt.getText().isEmpty() || registerCourseYearTxt.getText().isEmpty() || registerCourseSemesterTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields note:(Mark is optional)");
            alert.showAndWait();
        }
        else if (!registerCourseStudentIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Student ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseCourseIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Course ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseYearTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Year should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseSemesterTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Semester should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseMarkTxt.getText().isEmpty() && !registerCourseMarkTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Mark should contain only numbers");
            alert.showAndWait();
        }
        else{
            if (registerCourseMarkTxt.getText().isEmpty())
                mark = "null";
            else
                mark = registerCourseMarkTxt.getText();
            int result = DataAccessLayer.addRegisterCourse(Integer.parseInt(registerCourseStudentIDTxt.getText()), Integer.parseInt(registerCourseCourseIDTxt.getText()), Integer.parseInt(registerCourseYearTxt.getText()),Integer.parseInt(registerCourseSemesterTxt.getText()),mark, ConnectionSingleton.connectDB());
            if(result == -20003){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Course does not belong to the student's department");
                alert.showAndWait();
            }
            else if(result == -20001){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Student Already passed the course");
                alert.showAndWait();
            }else if(result == -20002){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Student Didn't Complete Course Yet");
                alert.showAndWait();
            }
            else if(result == -00001){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("You Can't Register Course For Student In The Same Year And Semester");
                alert.showAndWait();
            }
            else if(result == -1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in register student course");
                alert.showAndWait();
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Student Register Course Successfully Added!");
                alert.showAndWait();
                addRegisterCourseShowListData();
                clearRegisterCourseData();
            }
        }
    }
    */
    @FXML
    public void deleteRegisterCourse(){
        Alert alert;
        if (registerCourseStudentIDTxt.getText().isEmpty() || registerCourseCourseIDTxt.getText().isEmpty() || registerCourseYearTxt.getText().isEmpty() || registerCourseSemesterTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields note:(Mark is optional)");
            alert.showAndWait();
        }
        else if (!registerCourseStudentIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Student ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseCourseIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Course ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseYearTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Year should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseSemesterTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Semester should contain only numbers");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.deleteRegisterCourse(Integer.parseInt(registerCourseStudentIDTxt.getText()), Integer.parseInt(registerCourseCourseIDTxt.getText()), Integer.parseInt(registerCourseYearTxt.getText()),Integer.parseInt(registerCourseSemesterTxt.getText()), ConnectionSingleton.connectDB());
            if(result!=-1){
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Student Registered Course Successfully Deleted!");
                alert.showAndWait();
                addRegisterCourseShowListData();
                clearRegisterCourseData();
            }
            else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in deleting registered course");
                alert.showAndWait();
            }
        }
    }
    
    @FXML
    public void updateRegisterCourse(){
        String mark;
        Alert alert;
        if (registerCourseStudentIDTxt.getText().isEmpty() || registerCourseCourseIDTxt.getText().isEmpty() || registerCourseYearTxt.getText().isEmpty() || registerCourseSemesterTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields note:(Mark is optional)");
            alert.showAndWait();
        }
        else if (!registerCourseStudentIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Student ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseCourseIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Course ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseYearTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Year should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseSemesterTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Semester should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseMarkTxt.getText().isEmpty() && !registerCourseMarkTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Mark should contain only numbers");
            alert.showAndWait();
        }
        else if (!registerCourseMarkTxt.getText().isEmpty() && registerCourseMarkTxt.getText().matches("\\d+") && (Integer.parseInt(registerCourseMarkTxt.getText()) < 0 || Integer.parseInt(registerCourseMarkTxt.getText()) > 100)) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Mark should be in the range from 0 to 100");
            alert.showAndWait();
        }
        else{
            if (registerCourseMarkTxt.getText().isEmpty())
                mark = "null";
            else
                mark = registerCourseMarkTxt.getText();
            int result = DataAccessLayer.updateRegisterCourse(Integer.parseInt(registerCourseStudentIDTxt.getText()), Integer.parseInt(registerCourseCourseIDTxt.getText()), Integer.parseInt(registerCourseYearTxt.getText()),Integer.parseInt(registerCourseSemesterTxt.getText()),mark, ConnectionSingleton.connectDB());
            if(result != -1){
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Mark Successfully Updated!");
                alert.showAndWait();
                addRegisterCourseShowListData();
                clearRegisterCourseData();
            }
            else{
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in updating mark");
                alert.showAndWait();
            }
        }
    }
    /****************************************************************************/
    /*studentcorusessceme*/
    public void addStudentCoursesShowListData() {
        addStudentCoursesListD = DataAccessLayer.getStudentCoursesData(ConnectionSingleton.connectDB());

        studentCoursesStudentIDColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        studentCoursesFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        studentCoursesLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentCoursesEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        studentCoursesDOBColumn.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        studentCoursesGenderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        studentCoursesPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        studentCoursesDepartmentIDColumn.setCellValueFactory(new PropertyValueFactory<>("departmentID"));
        studentCoursesDepartmentNameColumn.setCellValueFactory(new PropertyValueFactory<>("departmentName"));
        
        studentCoursesRegisterTable.setItems(addStudentCoursesListD);
    }
    int studentID = 0;
    public void addSelectedStudentCoursesInText(){
        StudentDTO studentData = studentCoursesRegisterTable.getSelectionModel().getSelectedItem();
        if (studentData != null){
            studentID = studentData.getStudentID();
            ObservableList<StudentCoursesDTO> studentsCoursesList = studentData.getStudentCourses();
            studentCoursesCourseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseID"));
            studentCoursesCourseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
            studentCoursesNoOfHoursColumn.setCellValueFactory(new PropertyValueFactory<>("noOfHours"));
            studentCoursesCourseTable.setItems(studentsCoursesList);
        }
        
    }
    public void addSelectedStudentCoursesToRegisterInText(){
        StudentCoursesDTO coursesData = studentCoursesCourseTable.getSelectionModel().getSelectedItem();
        if (coursesData != null){

            studentCoursesStudentIDTxt.setText(String.valueOf(studentID));
            studentCoursesCourseIDTxt.setText(String.valueOf(coursesData.getCourseID()));
            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            studentCoursesYearTxt.setText(String.valueOf(currentYear));
            int monthValue = currentDate.getMonthValue();
            if(monthValue >=1 && monthValue<=6)
                studentCoursesSemesterTxt.setText(String.valueOf(1));
            else
                studentCoursesSemesterTxt.setText(String.valueOf(2));
        }
        
    }
    
    public void clearStudentCoursesData(){
        studentCoursesRegisterTable.getSelectionModel().clearSelection();
        studentCoursesCourseTable.setItems(null);
        studentCoursesStudentIDTxt.clear();
        studentCoursesCourseIDTxt.clear();
    }
    
    public void addRegisterCourse(){
        Alert alert;
        if (studentCoursesStudentIDTxt.getText().isEmpty() || studentCoursesCourseIDTxt.getText().isEmpty() || 
                studentCoursesYearTxt.getText().isEmpty() || studentCoursesSemesterTxt.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields note:(Mark is optional)");
            alert.showAndWait();
        }
        else if (!studentCoursesStudentIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Student ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!studentCoursesCourseIDTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Course ID should contain only numbers");
            alert.showAndWait();
        }
        else if (!studentCoursesYearTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Year should contain only numbers");
            alert.showAndWait();
        }
        else if (!studentCoursesSemesterTxt.getText().matches("\\d+")) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Semester should contain only numbers");
            alert.showAndWait();
        }
        else{
            int result = DataAccessLayer.addRegisterCourse(Integer.parseInt(studentCoursesStudentIDTxt.getText()), Integer.parseInt(studentCoursesCourseIDTxt.getText()), Integer.parseInt(studentCoursesYearTxt.getText()),Integer.parseInt(studentCoursesSemesterTxt.getText()),"null", ConnectionSingleton.connectDB());
            if(result == -20003){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Course does not belong to the student's department");
                alert.showAndWait();
            }
            else if(result == -20001){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Student Already passed the course");
                alert.showAndWait();
            }else if(result == -20002){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Student Didn't Complete Course Yet");
                alert.showAndWait();
            }
            else if(result == -00001){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("You Can't Register Course For Student In The Same Year And Semester");
                alert.showAndWait();
            }
            else if(result == -1){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Error in register student course");
                alert.showAndWait();
            }
            else{
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Student Register Course Successfully Added!");
                alert.showAndWait();
                addStudentCoursesShowListData();
                clearStudentCoursesData();
            }
        }
    }
    @FXML
    public void logout() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");

            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                //HIDE YOUR DASHBOARD FORM
                logoutBtn.getScene().getWindow().hide();

                //LINK YOUR LOGIN FORM 
                Parent root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

            } else {
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    /* *************************************************************************************************** */
    //switch scenes
    @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == homeSceneBtn) {
            homeScene.setVisible(true);
            studentScene.setVisible(false);
            departmentScene.setVisible(false);
            courseScene.setVisible(false);
            registerCourseScene.setVisible(false);
            studentCoursesScene.setVisible(false);

            homeSceneBtn.setStyle("-fx-background-color:linear-gradient(to bottom right, #547a9a, #a285b7);");
            studentSceneBtn.setStyle("-fx-background-color:transparent");
            departmentSceneBtn.setStyle("-fx-background-color:transparent");
            courseSceneBtn.setStyle("-fx-background-color:transparent");
            registerCourseSceneBtn.setStyle("-fx-background-color:transparent");
            studentCoursesSceneBtn.setStyle("-fx-background-color:transparent");
            
            addHomeShowListData();
            clearHomeData();

        } else if (event.getSource() == studentSceneBtn) {
            homeScene.setVisible(false);
            studentScene.setVisible(true);
            departmentScene.setVisible(false);
            courseScene.setVisible(false);
            registerCourseScene.setVisible(false);
            studentCoursesScene.setVisible(false);

            studentSceneBtn.setStyle("-fx-background-color:linear-gradient(to bottom right, #547a9a, #a285b7);");
            homeSceneBtn.setStyle("-fx-background-color:transparent");
            departmentSceneBtn.setStyle("-fx-background-color:transparent");
            courseSceneBtn.setStyle("-fx-background-color:transparent");
            registerCourseSceneBtn.setStyle("-fx-background-color:transparent");
            studentCoursesSceneBtn.setStyle("-fx-background-color:transparent");
            
            addStudentsShowListData();
            clearStudentData();
            addStudentsDepartmentList();

        } else if (event.getSource() == departmentSceneBtn) {
            homeScene.setVisible(false);
            studentScene.setVisible(false);
            departmentScene.setVisible(true);
            courseScene.setVisible(false);
            registerCourseScene.setVisible(false);
            studentCoursesScene.setVisible(false);

            departmentSceneBtn.setStyle("-fx-background-color:linear-gradient(to bottom right, #547a9a, #a285b7);");
            studentSceneBtn.setStyle("-fx-background-color:transparent");
            homeSceneBtn.setStyle("-fx-background-color:transparent");
            courseSceneBtn.setStyle("-fx-background-color:transparent");
            registerCourseSceneBtn.setStyle("-fx-background-color:transparent");
            studentCoursesSceneBtn.setStyle("-fx-background-color:transparent");
            
            addDepartmentsShowListData();
            clearDepartmentData();
            clearDepartmentCourseData();


        } else if (event.getSource() == courseSceneBtn) {
            homeScene.setVisible(false);
            studentScene.setVisible(false);
            departmentScene.setVisible(false);
            courseScene.setVisible(true);
            registerCourseScene.setVisible(false);
            studentCoursesScene.setVisible(false);

            courseSceneBtn.setStyle("-fx-background-color:linear-gradient(to bottom right, #547a9a, #a285b7);");
            studentSceneBtn.setStyle("-fx-background-color:transparent");
            departmentSceneBtn.setStyle("-fx-background-color:transparent");
            homeSceneBtn.setStyle("-fx-background-color:transparent");
            registerCourseSceneBtn.setStyle("-fx-background-color:transparent");
            studentCoursesSceneBtn.setStyle("-fx-background-color:transparent");

            addCoursesShowListData();
            clearCourseData();

        } else if (event.getSource() == registerCourseSceneBtn) {
            homeScene.setVisible(false);
            studentScene.setVisible(false);
            departmentScene.setVisible(false);
            courseScene.setVisible(false);
            registerCourseScene.setVisible(true);
            studentCoursesScene.setVisible(false);

            registerCourseSceneBtn.setStyle("-fx-background-color:linear-gradient(to bottom right, #547a9a, #a285b7);");
            studentSceneBtn.setStyle("-fx-background-color:transparent");
            departmentSceneBtn.setStyle("-fx-background-color:transparent");
            homeSceneBtn.setStyle("-fx-background-color:transparent");
            courseSceneBtn.setStyle("-fx-background-color:transparent");
            studentCoursesSceneBtn.setStyle("-fx-background-color:transparent");
            
            addRegisterCourseShowListData();
            clearRegisterCourseData();

        }
        else if (event.getSource() == studentCoursesSceneBtn) {
            homeScene.setVisible(false);
            studentScene.setVisible(false);
            departmentScene.setVisible(false);
            courseScene.setVisible(false);
            registerCourseScene.setVisible(false);
            studentCoursesScene.setVisible(true);

            studentCoursesSceneBtn.setStyle("-fx-background-color:linear-gradient(to bottom right, #547a9a, #a285b7);");
            registerCourseSceneBtn.setStyle("-fx-background-color:transparent");
            studentSceneBtn.setStyle("-fx-background-color:transparent");
            departmentSceneBtn.setStyle("-fx-background-color:transparent");
            homeSceneBtn.setStyle("-fx-background-color:transparent");
            courseSceneBtn.setStyle("-fx-background-color:transparent");
            
            addStudentCoursesShowListData();
            clearStudentCoursesData();
            
            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            studentCoursesYearTxt.setText(String.valueOf(currentYear));
            int monthValue = currentDate.getMonthValue();
            if(monthValue >=1 && monthValue<=6)
                studentCoursesSemesterTxt.setText(String.valueOf(1));
            else
                studentCoursesSemesterTxt.setText(String.valueOf(2));

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addHomeShowListData();
        addStudentsShowListData();
        addStudentsGenderList();
        addStudentsDepartmentList();
        addDepartmentsShowListData();
        addCoursesShowListData();
        addRegisterCourseShowListData();
        addStudentCoursesShowListData();
    }    
    
}
