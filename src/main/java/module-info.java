module org.example.visu {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.visu to javafx.fxml;
    exports org.example.visu;
}