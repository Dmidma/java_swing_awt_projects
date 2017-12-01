package organizer;


import general.definition.Window;

public class Lunch {

	public static void main(String[] args){
		
		// look and feel
		Window.lookAndFeel();
		
		// create the window
		Window window = new Window("Organizer", 500, 500, true);

		// set personal Icon
		window.setPersonalIcon("C:\\Users\\d-ous\\OneDrive\\Pictures\\proto2.png");

		
		new Handler(window);
		
		// let the show begin
		window.setVisible(true);
	}
}
