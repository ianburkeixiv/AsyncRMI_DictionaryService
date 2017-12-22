package ie.gmit.sw.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DictServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L; 
	Dictionary dictionaryMap;
	HashMap<String, String> map;
	
	//======= Constructor =========================================
	protected DictServiceImpl() throws Exception {
		super();
		dictionaryMap = new Dictionary();
		dictionaryMap.loadDictionary();
		map = dictionaryMap.dictHashMap();
		
		
	}//contructor end
	
	
	
	
	// Implementing lookup() from Remote interface
	@Override
	public String lookup(String query) {		
		
		// If hashmap contains the key "word" (users query) then..
		if(map.containsKey(query)){
			return map.get(query);
			
			//System.out.println(query + " : " + dictionary.get(query));
		}else {
			return query + " not found";
		}
		
	}//lookup end
	
} //class end
