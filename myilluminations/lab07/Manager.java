package lab07;

import communication.IControlCenter;
import communication.IManager;
import communication.ISite;
import support.Mixer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Manager implements IManager {
    private List<ISite> sites;
    private List<Mixer> mixers;

    public Manager() {
        this.sites = new ArrayList<>();
        this.mixers = new ArrayList<>();
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 3000);
            IControlCenter ic = (IControlCenter) reg.lookup("ControlCenter");
            Manager m = new Manager();
            IManager im = (IManager) UnicastRemoteObject.exportObject(m, 0);
            System.out.println("Manager is ready");
            ic.subscribe(im);
        } catch (RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void notify(ISite is, Boolean s) throws RemoteException {
        if (s) {
            sites.add(is);
            System.out.println("Site" + is.getName() + " added.");
        } else {
            sites.remove(is);
            System.out.println("Site" + is.getName() + " removed.");
        }
        // TODO: refresh manager scene after adding/removing Site
    }

    // informs about adding (s=true) or removal (s=false)
    @Override
    public void notify(Mixer mi, Boolean s) throws RemoteException {
        if (s) {
            mixers.add(mi);
        } else mixers.remove(mi);
        // TODO: refresh manager scene after adding/removing mixer
    }


}
