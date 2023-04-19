module com.example.clinc_mangement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.clinc_mangement to javafx.fxml;
    exports com.example.clinc_mangement;
}