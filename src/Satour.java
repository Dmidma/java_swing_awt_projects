

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.swing.JSlider;


public class Satour {



	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		System.out.println("Sniffing:");
		int timeout=1000;
		for (int i=1; i<255; i++) {
			String host="192.168.1" + "." + i;
			if (InetAddress.getByName(host).isReachable(timeout)){
				System.out.println(host + " is reachable");
			}

		}
	
		
		/*
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("1-5", 6);
		
		
		if (map.containsKey("1-5") || map.containsKey("5-1")) {
			
			System.out.println(map.get("1-5"));
			System.out.println(map.get("5-1"));
		}
	*/
		/*
		float[] inputValueRange = {0, 3, 3, 8, 8, 11, 23};


		float difference = 7.3f;


		// if the difference is lower than the input value range
		if (difference < inputValueRange[0]) {
			System.out.println(-1);
		}


		int goTo = 1;
		for (int i = 1; i < inputValueRange.length; i+=2) {
			if (difference > inputValueRange[i]) {
				goTo++;
			}
			else if (difference < inputValueRange[i]) {
				System.out.println(goTo);
			}
		}
		 */


		/*
		int nbrF1 = 60;
		int nbrF2 = 53;


		float pr1 = 200.58f;
		float pr2 = 250;

		float fp1 = pr1 / nbrF1;
		float fp2 = pr2 / nbrF2;

		System.out.println("Phone1 :" + fp1);
		System.out.println("Phone2 :" + fp2);

		float result = fp1 - fp2;

		System.out.println("the difference : " + new DecimalFormat("##.##").format(result));



		System.out.println(mapRangeIntoRange(0, 2, 0, 5, 1.3f));

		int[] valueRange = {0, 2, 0, 5, 2, 5, 5, 20, 5, 10, 20, 50, 10, 20, 50, 100};


		for (int i = 0; i < valueRange.length - 2; i+=4) {
			System.out.println(valueRange[i + 2]);
		}
		 */



		/*

		String content = HandleFile.read("C:/Users/d-ous/test1.JSON");


		try {

			JSONParser pars = new JSONParser();

			JSONArray array = (JSONArray)pars.parse(content);


			for (Object i : array) {
				System.out.println(i);
			}


		} catch(Exception e) {

		}

		 */
		//HashMap<String, LinkedList<String>> map = HandleFile.CSVHeadData("C:/Users/d-ous/prof.csv");
		/*
		for (Iterator<String> i = map.keySet().iterator(); i.hasNext(); ) {
			for (Iterator<String> j = map.get(i.next()).iterator(); j.hasNext(); ) {
				System.out.println(j.next());
			}

		}
		 */
		/*
		if (map != null) {


			for (String i : map.get("LastName")) {
				System.out.println(i);
			}

			for (String i : map.get("FirstName")) {
				System.out.println(i);
			}
		}
		 */



		/*
		String key = "8754termahateove";

		String init = "loveme8754Dmidma";


		String encryptedText = Encryption.encrypt(key, init, "Hello, this is Dmidma.");

		System.out.println("1. " + encryptedText);

		String encodedEncryptedText = Encryption.encodeBase64(encryptedText);

		System.out.println("2. " + encodedEncryptedText);

		String decodedEncryptedText = Encryption.decodeBase64(encodedEncryptedText);

		System.out.println("3. " + decodedEncryptedText);

		String originalText = Encryption.decrypt(key, init, decodedEncryptedText);

		System.out.println("4." + originalText);
		 */
	}



	public static float mapRangeIntoRange(int input_start, int input_end, int output_start, int output_end, float input) {


		// test if the input is in range of the input values
		if (input > input_end) {
			throw new IllegalArgumentException("Input values must be in the range of input values");
		}

		// Transforme the [input_start, input_end] -> [0, r]
		int r = input_end - input_start;

		// mapped input
		float mInput = input - input_start;

		// calculate slope
		float slope = ((float)output_end - output_start) / (input_end - input_start); 

		// calculate output
		float output = output_start + slope * mInput;

		// That's all folks
		return output;

	}
}
