module com.ccs4202.project.ruralheroesproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.ccs4202.project.ruralheroesproject to javafx.fxml;
    exports com.ccs4202.project.ruralheroesproject;
}