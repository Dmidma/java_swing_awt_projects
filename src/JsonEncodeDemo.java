

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import general.definition.HandleFile;

public class JsonEncodeDemo {

	public static void main(String[] args) {
		/*
		JSONObject obj = new JSONObject();

		obj.put("name", "foo");
		obj.put("num", new Integer(100));
		obj.put("balance", new Double(1000.21));
		obj.put("is_vip", new Boolean(true));


		StringWriter out = new StringWriter();
		obj.writeJSONString(out);

		String jsonText = out.toString();
		System.out.print(jsonText);


		//System.out.print(obj);

		 */
		try  {
		JSONParser parser = new JSONParser();
		//String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";

		//String s = "[\"audio\", \".mp3\", \".mp4\", \".wav\"]";
		
		JSONArray arr = new JSONArray();
		
        
		/*
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		
		String[] names = {"Dmidma", "Math", "Samir"};
		int[] ages = {21, 23, 25};
		String[] realNames = {"Oussema", "Ahmed", "Samir"};
		
		for (int i = 0; i < names.length; i++) {
			JSONObject currentObj = new JSONObject();
			
			currentObj.put("Pseudo", names[i]);
			currentObj.put("Age", ages[i]);
			currentObj.put("Real_Name", realNames[i]);
			
			
			arr.add(currentObj);
		}
		*/
		
		String path = "C:/Users/d-ous/test.JSON";
		String var = HandleFile.read(path);
		
		// System.out.println(HandleFile.JSONRead(path) + "***************************");
		
		
		JSONParser parserrr = new JSONParser();
		JSONObject obj = (JSONObject)parserrr.parse(var);
		
		
		//.out.println(((JSONObject)((JSONArray)parserrr.parse(var)).get(3)).get("Real_Name"));
		
		System.out.println(obj);
		
		
		Object obji = obj.get("Persons");
		
		if (obji instanceof JSONArray) {
			System.out.println(((JSONArray)obji).size());
		}
		else {
			// stop the process
		}
		
		System.out.println(obj.get("Persons"));
        //HandleFile.write("C:/Users/d-ous/test.JSON", arr.toString());
		
        System.out.println("Done");
	
			//System.out.println("The 2nd element of array");
			//System.out.println(array.get(1));
			//System.out.println();
			
			/*
			JSONObject obj2 = (JSONObject)array.get(1);
			System.out.println("Field \"1\"");
			System.out.println(obj2.get("1"));    
			*/
			/*
			s = "{}";
			obj = parser.parse(s);
			System.out.println(obj);

			s = "[5,]";
			obj = parser.parse(s);
			System.out.println(obj);

			s = "[5,,2]";
			obj = parser.parse(s);
			System.out.println(obj);
			*/
		} catch(Exception pe){

		}
	}

}
