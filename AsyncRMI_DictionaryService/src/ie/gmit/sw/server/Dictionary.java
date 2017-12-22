package ie.gmit.sw.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Dictionary {
	
	// Create a LinkedHashMap that takes in key, value of type string from dictionary txt file.
	HashMap<String, String> dictionary = new HashMap<String, String>();
	
	public void loadDictionary() throws Exception, RemoteException {
		
		// Using BufferedReader to read through each line of the file.
		BufferedReader br = new BufferedReader(new FileReader("dictionary2.txt"));
		
		// line variable represents each line in dictionary file
		String line = null;
		
		// loop through the dictionary file
		// while line equals line in file and not equal to null then...
		while ((line = br.readLine()) != null) {

			// Splitting each line in file by a comma and storing in array of type string
			String[] words = line.split(",");
			
			/*
			// Ignore empty lines
			if (inputLine.equals("")){
				continue;
			}*/
			
			// Put the first set of values, in lower case, into Key  of the hashmap
			// Put 2nd set of values into value of the hashmap
			dictionary.put(words[0].toLowerCase(), words[1]);
			
		} //end while
		
		br.close();
	
	} // end loadDictionary()
	
	public HashMap<String, String> dictHashMap() {
		return this.dictionary;
	}

}
