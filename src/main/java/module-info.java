module org.example.visu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.visu to javafx.fxml;
    exports org.example.visu;
}