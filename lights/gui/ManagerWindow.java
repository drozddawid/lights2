package gui;

import communication.IManager;
import javafx.application.Application;
import javafx.stage.Stage;
import lab07.Manager;

public class ManagerWindow extends Application {
    IManager manager;
    @Override
    public void start(Stage stage) {
        manager = new Manager();
    }
}
