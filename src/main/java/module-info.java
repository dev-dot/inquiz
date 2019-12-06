module inquiz {
    requires java.xml.bind;
    opens de.hdm_stuttgart.mi.classes to java.xml.bind;

    requires javafx.controls;
    requires javafx.graphics;
    requires org.apache.logging.log4j.core;
    requires org.apache.logging.log4j;
    requires javafx.fxml;

    opens de.hdm_stuttgart.mi.Gui.ViewHandler to javafx.graphics, javafx.fxml;
    exports de.hdm_stuttgart.mi.Gui.ViewHandler;
}