package com.sumair.gradetracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GradeTrackerController {

    @FXML private TextField subjectField;
    @FXML private TextField marksField;
    @FXML private TextField outOfField;
    @FXML private TextField creditField;

    @FXML private TableView<SubjectRow> gradeTable;
    @FXML private TableColumn<SubjectRow, String> subjectCol;
    @FXML private TableColumn<SubjectRow, Double> marksCol;
    @FXML private TableColumn<SubjectRow, Double> outOfCol;
    @FXML private TableColumn<SubjectRow, String> gradeCol;
    @FXML private TableColumn<SubjectRow, Double> gpCol;
    @FXML private TableColumn<SubjectRow, Double> creditCol;

    @FXML private Label gpaLabel;

    private ObservableList<SubjectRow> rows = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        subjectCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getSubjectName()));
        marksCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getMarks()).asObject());
        outOfCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getOutOf()).asObject());
        gradeCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getGrade()));
        gpCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getGp()).asObject());
        creditCol.setCellValueFactory(data ->
                new javafx.beans.property.SimpleDoubleProperty(data.getValue().getCreditHours()).asObject());

        gradeTable.setItems(rows);
    }
    private String calculateGrade(double marks, double outOf) {
        double percentage = (marks / outOf) * 100;

        if (percentage >= 93) return "A";
        else if (percentage >= 87) return "A-";
        else if (percentage >= 82) return "B+";
        else if (percentage >= 77) return "B";
        else if (percentage >= 72) return "B-";
        else if (percentage >= 68) return "C+";
        else if (percentage >= 64) return "C";
        else if (percentage >= 60) return "C-";
        else return "F";
    }
    private double calculateGP(String grade) {
        switch (grade) {
            case "A": return 4.00;
            case "A-": return 3.67;
            case "B+": return 3.33;
            case "B": return 3.00;
            case "B-": return 2.67;
            case "C+": return 2.33;
            case "C": return 2.00;
            case "C-": return 1.67;
            case "F": return 0.00;
            default: return 0.00;
        }
    }
    @FXML
    private void addRow() {
        String subject = subjectField.getText();
        try {
            double marks = Double.parseDouble(marksField.getText());
            double outOf = Double.parseDouble(outOfField.getText());
            double credits = Double.parseDouble(creditField.getText());

            String grade = calculateGrade(marks, outOf);
            double gp = calculateGP(grade);

            SubjectRow row = new SubjectRow(subject, marks, outOf, grade, gp, credits);

            rows.add(row);
            subjectField.clear();
            marksField.clear();
            outOfField.clear();
            creditField.clear();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setContentText("Please enter valid numbers for Marks, Out Of and Credit Hours.");
            alert.showAndWait();
        }
    }
    @FXML
    private void calculateGPA() {
        double totalPoints = 0;
        double totalCredits = 0;

        for (SubjectRow row : rows) {
            totalPoints += row.getGp() * row.getCreditHours();
            totalCredits+= row.getCreditHours();
        }

        double gpa = totalPoints/totalCredits;
                gpaLabel.setText(String.format("GPA: %.2f", gpa));
    }
    @FXML
    private void clearTable(){
        rows.clear();
        gpaLabel.setText("GPA: --");
    }
    @FXML
    private void removeRow() {
        if (!rows.isEmpty()) {
            rows.remove(rows.size() - 1);
        }
    }

}