package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import lab07.Designer;

public class DesignerWindow extends Application {
    Designer designer;
    @Override
    public void start(Stage stage) {
        designer = new Designer();
    }
}
