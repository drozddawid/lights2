package com.drozd.gui;

import com.drozd.communication.IManager;
import com.drozd.lab07.Manager;
import javafx.application.Application;
import javafx.stage.Stage;

public class ManagerWindow extends Application {
    IManager manager;

    @Override
    public void start(Stage stage) {
        manager = new Manager();
    }
}
