module com.gymnasthub.gymnasticsgainz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;



    opens com.gymnasthub.gymnasticsgainz to javafx.fxml;
    exports com.gymnasthub.gymnasticsgainz;
}