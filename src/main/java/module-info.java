module com.example.pacmanapo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.pacmanapo to javafx.fxml;
    exports com.example.pacmanapo;
}