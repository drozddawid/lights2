package com.drozd.gui;

import com.drozd.lab07.Designer;
import javafx.application.Application;
import javafx.stage.Stage;

public class DesignerWindow extends Application {
    Designer designer;

    @Override
    public void start(Stage stage) {
        designer = new Designer();
    }
}
