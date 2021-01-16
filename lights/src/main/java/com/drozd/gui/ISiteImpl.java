package com.drozd.gui;

import com.drozd.communication.ISite;
import com.drozd.support.Mixer;

import java.rmi.RemoteException;

public class ISiteImpl implements ISite {

    @Override
    public void startSite() throws RemoteException {

    }

    @Override
    public void stopSite() throws RemoteException {

    }

    @Override
    public void setMixer(Mixer m) throws RemoteException {

    }

    @Override
    public String getName() throws RemoteException {
        return null;
    }
}
