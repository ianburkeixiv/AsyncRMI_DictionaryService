package ie.gmit.sw.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/*
 * This class contains the main method to run the remote Server
 * 
 */

public class Server {
	
	public static void main(String[] args) throws Exception {

		// Create an instance of a DictServiceImpl as it implements the  remote interface
		DictionaryService ds = new DictServiceImpl();
		
		//Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry with the human-readable name "fileService"
		Naming.rebind("DictionaryService", ds);
		 
		System.out.println("Server ready...");
		
		
	}

}
