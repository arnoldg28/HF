import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote{
	public String sayHello(){
		return "Server Says, 'Hey!'";
	}
	
	//this is requried since it parent class contructor might also throw an exception
	public MyRemoteImpl() throws RemoteException{}
	
	public static final void main(String[] args){
		try{
			MyRemote service = new MyRemoteImpl();
			Naming.rebind("RemoteHello",service);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}