package com.drozd.lab07;


import com.drozd.communication.IControlCenter;
import com.drozd.communication.IManager;
import com.drozd.communication.ISite;
import com.drozd.support.Mixer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class ControlCenter implements IControlCenter {
    private List<ISite> sites;
    private List<IManager> managers;
    private List<Mixer> mixers;

    private ControlCenter() {
        sites = new ArrayList<>();
        managers = new ArrayList<>();
        mixers = new ArrayList<>();
    }

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(3000);
            reg.rebind("ControlCenter", UnicastRemoteObject.exportObject(new ControlCenter(), 0));
            System.out.println("ControlCenter is ready");
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Boolean add(ISite is) throws RemoteException {
        this.sites.add(is);
        for (IManager m : managers) {
            m.notify(is, true);
        }
        return true;
    }

    @Override
    public Boolean remove(ISite is) throws RemoteException {
        this.sites.remove(is);
        for (IManager m : managers) {
            m.notify(is, false);
        }
        return true;
    }

    @Override
    public Boolean add(Mixer m) throws RemoteException {
        this.mixers.add(m);
        for (IManager manager : managers) {
            manager.notify(m, true);
        }
        return true;
    }

    @Override
    public Boolean remove(Mixer m) throws RemoteException {
        this.mixers.remove(m);
        for (IManager manager : managers) {
            manager.notify(m, false);
        }
        return true;
    }

    @Override
    public void subscribe(IManager im) throws RemoteException {
        managers.add(im);
    }

    @Override
    public List<ISite> getAllSites() throws RemoteException {
        return sites;
    }

    @Override
    public List<Mixer> getAllMixers() throws RemoteException {
        return mixers;
    }

}
