package general.definition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

	

import org.json.simple.JSONArray;

public class HandleFile {
	
	
	
	/**
	 * This method will try to open a file and write the message to it.
	 * It will not conserve the previous content of the file.
	 * If the file does not exist, the method will try to create it.
	 * @param path of the opened file.
	 * @param message the message that will be written to the file.
	 */
	public static void write(String path, String message) {
		
		// open the file
		File file = new File(path);
		
		
		// if the file does not exist try to create one
		if (!file.exists())
			file = createFile(path);
		
		
		// write to the file
		try {
			// open stream
			FileWriter fWrite = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fWrite);
			
			// write new lines if any was found
			for (String i : message.split("(\n)+")) {
				bufferedWriter.write(i);
				bufferedWriter.newLine();
			}
			
			// close anything was opened
			bufferedWriter.close();
			fWrite.close();

		} catch (Exception e) {

		}
		
		
	}
	
	/**
	 * This method will try to create a file if the given path does not
	 * correspond to an existing file.
	 * @param path the path of the created file.
	 * @return the reference of the create file.
	 */
	@SuppressWarnings("unused")
	private static File createFile(String path) {
		
		// open the file
		File currentFile = new File(path);
		
		
		// check if it is a valid file
		if (currentFile == null) {
			System.out.println("Could not create the file");
			throw new NullPointerException();
		}

		// hopefully things went perfect
		return currentFile;

	}
	
	
	/**
	 * This method will read the content of the file and return it.
	 * It will return a null if the path of the file does not exist
	 * @param path the path of the opened file.
	 * @return the content of the file
	 */
	public static String read(String path) {
		
		// open the file
		File file = new File(path);
		
		
		// if the file does not exist return null
		if (!file.exists())
			return null;
		
		
		
		String content = "";
		
		// write to the file
		try {
			// open stream
			FileReader fReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fReader);
			
			
			// read all the content of the file
			String current = bufferedReader.readLine();
			while (current != null) {
				content = content.concat(current + "\n");
				current = bufferedReader.readLine();
			}
			
			// close anything was opened
			bufferedReader.close();
			fReader.close();

		} catch (Exception e) {

		}
		
		return content;
	}
	
	
	/**
	 * This method will append the message to the opened file.
	 * @param path the path of the opened file.
	 * @param message the message that the method will append.
	 * @see
	 * write();
	 */
	public static void append(String path, String message) {	
		write(path, read(path).concat("\n" + message));
	}
	
	
	
	/*
	 * Reading a JSON file:
	 * I think we will have two cases:
	 * 	i. Wrapped in JSONObject
	 *  ii. Wrapped in JSONArray
	 *  
	 *  In case of 
	 *    i:
	 *      It will map the file -> Map<String, Object>
	 *    ii:
	 *      It will map the file and the keys will be Key1, Key2, ..., KeyN
	 *      
	 * NICE !!!!!!
	 *  
	 * Function that take a JSONArray that contains JSONObject and returns 
	 * Map<String, ArrayList<Object>>.
	 * The function will handles the wrong patterns:
	 *     -Unequal number of keys
	 *     -Different type of values
	 *     -etc
	 * 
	 * A JSONObject is already a Map<String, Object> !!!
	 * A JSONArray is already an ArrayList<Object> !!!
	 * 
	 * 
	 */
	

	
	
		
	public static ArrayList<Object> JSONArrayToArray(JSONArray array) {
		
		
		// initialize the list
		ArrayList<Object> list = new ArrayList<Object>();
		
		
		// whether the JSONArray null or empty, it will return an empty list
		if (array == null || array.size() == 0) {
			return list;
		}
		
		
		// reaching this points mean the array is valid
		for (Object i : array) {
			list.add(i);
		}	
		
		// That's all Folks!
		return list;
	}
	
	
	/**
	 * This method will parse a CSV file into a map.
	 * The CSV must have the first row as the keys of the map, and the rest 
	 * of the file as data for the keys.
	 * If the number of values is not equal to the number of keys, this method will 
	 * return null and indicate the number of lines where the problem occurred.
	 * @param path the path of the CSV file
	 * @return the mapped CSV file.
	 * @see CSVKeyData();
	 */
	public static HashMap<String, ArrayList<String>> CSVHeadData(String path) {
		
		// get the rows of the file
		String[] rows = read(path).split("(\n)+");
	
		
		// Initialize the map
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		// Initialize keys
		ArrayList<String> keys = new ArrayList<String>();
		// get the keys from the first row
		for (String i : rows[0].split(",")) {
			// get rid of first and last spaces
			String current = i.trim();
			// add the current string to the list
			keys.add(current);
			// add the key to the map and initialize the corresponding list
			map.put(current, new ArrayList<String>());
		}
		
		
		// iterate over the rest of the rows 
		for (int i = 1; i < rows.length; i++) {
			int j = 0;
			String[] currentRowWords = rows[i].split(",");
			
			// check if the number of values is equal to the number of keys
			if (currentRowWords.length != keys.size()) {
				System.out.println("Invalid row n: " + (i + 1) + 
						".\nNumber of values does not match number of keys");
				return null;
			}
			
			// get the words from the row and add them to the list of appropriate key
			for (String k : currentRowWords) {
				String current = k.trim();
				map.get(keys.get(j)).add(current);
				j++;
			}
		}
		
		// That's all Folks!
		return map;
	}
	
	
	/**
	 * This method will parse a CSV file into a map.
	 * The CSV must have the first word in a row as the key and the rest 
	 * values of the row as a data for that key.
	 * If the the same key exists more than once in the file, the last appearance of that key
	 * and its data will be stored in the map.
	 * @param path the path of the CSV file
	 * @return the mapped CSV file.
	 * @see CSVHeadData();
	 */
	public static HashMap<String, ArrayList<String>> CSVKeyData(String path) {

		// Initialize the map
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		// get the rows of the file
		String[] rows = read(path).split("(\n)+");
		
		
		// iterate over the rows
		for (int i = 0; i < rows.length; i++) {
			// get the words of the current line
			String[] currentRowWords = rows[i].split(",");
			
			// get the current key
			String currentKey = currentRowWords[0].trim();
			
			// set the key and initialize the list
			map.put(currentKey, new ArrayList<String>());
			
			// add the values to the current key
			for (int j = 1; j < currentRowWords.length; j++) {
				String currentValue = currentRowWords[j].trim();
				map.get(currentKey).add(currentValue);
			}
			
		}
		
		// That's all Folks!
		return map;
	}
	
	
	
	// TODO: Should I implement this method instead of the CSV methods
	
	/**
	 * A more general method of CSVKeyData.	
	 * @param path
	 * @param regx
	 * @return
	 */
	public static HashMap<String, HashSet<String>> SepKeyData(String path, String regx) {
		
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("What");
		
		return null;
	}
}
