package lab07;

import communication.IControlCenter;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Designer {
    Registry registry;
    IControlCenter controlCenter;

    public Designer() {
        try {
            this.registry = LocateRegistry.getRegistry("localhost", 3000);
            this.controlCenter = (IControlCenter) registry.lookup("ControlCenter");

        } catch (RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
