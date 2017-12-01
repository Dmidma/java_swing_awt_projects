import general.definition.HandleFile;

public class Question2 {
 
	
	
	public static void main(String[] args) {
		
		
		
		String message = "Hello world. \nThis is Dmidma.\nLove me.";
		String path = "C:/Users/d-ous/Desktop/tr.txt";
		
		
		HandleFile.write(path, message);
		
		System.out.println("done");
		
		System.out.println(HandleFile.read(path));
	}
	
	
}