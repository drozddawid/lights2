package communication;

import java.rmi.Remote;
import java.rmi.RemoteException;

import support.Mixer;

public interface ISite extends Remote{
  // starts illumination
  public void startSite() throws RemoteException;
  // stops illumination	
  public void stopSite() throws RemoteException;
  // sets the mixer
  public void setMixer(Mixer m) throws RemoteException;
  // delivers site name 
  public String getName() throws RemoteException; 
}
