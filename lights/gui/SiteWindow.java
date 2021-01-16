package gui;

import communication.IControlCenter;
import communication.IManager;
import communication.ISite;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lab07.Manager;
import support.Mixer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class SiteWindow extends Application implements ISite{
    String name;
    Mixer mixer;
    Scene scene;

    public SiteWindow(String name){
        this.name = name;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Site");
        HBox box = new HBox();
        Label name = new Label("Nazwa: ");
        TextField nameField = new TextField();
        Button accept = new Button("Akceptuj");
        accept.setOnAction(e->{
            acceptOnAction(nameField);
        });
        box.getChildren().addAll(name,nameField,accept);
        BorderPane root = new BorderPane(box);
        scene = new Scene(root,800,600);
        stage.setScene(scene);
        stage.show();
    }
    private void acceptOnAction(TextField field){
        name = field.getText();
        try {
            Registry reg = LocateRegistry.getRegistry("localhost",3000);
            IControlCenter ic = (IControlCenter) reg.lookup("ControlCenter");
            SiteWindow site = new SiteWindow(name);
            ISite isite = (ISite) UnicastRemoteObject.exportObject(site, 0);
            ic.add(isite);
        } catch (RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void startSite() throws RemoteException {

    }

    @Override
    public void stopSite() throws RemoteException {

    }

    @Override
    public void setMixer(Mixer m) throws RemoteException {
        this.mixer=m;
    }

    @Override
    public String getName() throws RemoteException {
        return null;
    }


}
