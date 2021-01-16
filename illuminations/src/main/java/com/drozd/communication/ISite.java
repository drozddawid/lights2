package com.drozd.communication;

import com.drozd.support.Mixer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISite extends Remote {
    // starts illumination
    public void startSite() throws RemoteException;

    // stops illumination
    public void stopSite() throws RemoteException;

    // sets the mixer
    public void setMixer(Mixer m) throws RemoteException;

    // delivers site name
    public String getName() throws RemoteException;
}
