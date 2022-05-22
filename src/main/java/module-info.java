module com.vai.uxremotecontrol {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.kwhat.jnativehook;

    opens com.vai.uxremotecontrol to javafx.fxml;
    exports com.vai.uxremotecontrol;
}