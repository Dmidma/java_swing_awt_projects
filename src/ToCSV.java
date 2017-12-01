import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Iterator;

/**
 * This class was just for parsing the prof.output file to prof.csv
 * @author d-ous
 *
 */
public class ToCSV {
	
	public static void main(String[] args) {
		
		LinkedList<String> aList = new LinkedList<String>();
		
		
		// open the file
		File currentFile = new File("C:\\Users\\d-ous\\Dropbox\\univ\\prof.output");

		// check if it is a valid path/file
		if (currentFile == null || !currentFile.exists()) {
			System.out.println("Invalid path/file");
			return;
		}
		
		File file = new File("C:\\Users\\d-ous\\Dropbox\\univ\\prof.csv");
		
		try {
			// set the file input stream
			FileReader fReader = new FileReader(currentFile);
			BufferedReader bufferedReader = new BufferedReader(fReader);
			
			
			FileWriter fWrite = new FileWriter(file);
			
			BufferedWriter bufferedWriter = new BufferedWriter(fWrite);
			
			String currentLine = bufferedReader.readLine();
			
			while (currentLine != null) {
				aList.add(currentLine);
				currentLine = bufferedReader.readLine();
			}
			
			for (Iterator<String> i = aList.iterator(); i.hasNext();) {
				String current = i.next();
				
				StringTokenizer token = new StringTokenizer(current, " ");
				
				int aNumber = token.countTokens();
				
				
				do {
					if (aNumber-- == 1) {
					
						bufferedWriter.append(", ");
					}
					String subString = token.nextToken();
					String hi = Character.toUpperCase(
							subString.charAt(0)) + 
							subString.substring(1).toLowerCase();
					bufferedWriter.append(hi + " ");
				} while (token.hasMoreTokens());
				bufferedWriter.append("\n");
				
			}
			
			// always close what you have opened
			bufferedWriter.close();
			
			System.out.println("done");
		} catch (Exception e) {

		}

	}
}
