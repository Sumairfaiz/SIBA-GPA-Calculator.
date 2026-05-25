module com.sumair.gradetracker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.sumair.gradetracker to javafx.fxml;
    exports com.sumair.gradetracker;
}