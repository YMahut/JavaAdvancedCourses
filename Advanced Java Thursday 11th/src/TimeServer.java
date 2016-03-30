import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;


public class TimeServer extends UnicastRemoteObject implements TimeService {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public TimeServer() throws RemoteException {}

	    public Date getTime() {  return Calendar.getInstance().getTime(); }

	    public static void main(String [] args) {
	        try {
	            TimeServer server = new TimeServer();
	            Naming.rebind("TimeServer", server);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
