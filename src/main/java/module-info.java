module com.example.homepractice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.homepractice to javafx.fxml;
    exports com.example.homepractice;
}