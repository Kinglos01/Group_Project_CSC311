module org.example.group_project_csc311 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.example.group_project_csc311 to javafx.fxml;
    exports org.example.group_project_csc311;
}