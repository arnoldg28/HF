import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer{
		HashMap serviceList;
		
		public ServiceServerImpl() throws RemoteException{
			setUpServices();
		}
		
		private void setUpServices(){
			serviceList = new HashMap();
			serviceList.put("Dice Rolling Service",new DiceService());
			serviceList.put("Day of the week Service",new DayOfTheWeekService());
			serviceList.put("Visual Music Service",new MiniMusicService());			
		}
		
		public Object[] getServiceList(){
			return serviceList.keySet().toArray();
		}
		
		//Commented out throws declaration since the interface implemented by this class already declare that exception
		public Service getService(Object serviceKey){ //throws RemoteException{
			Service theService =  (Service)serviceList.get(servicekey);
			return theService;
		}
		
		public static void main(String[] args){
			try{
				Naming.rebind("ServiceServer",new ServiceServerImpl());
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
}