package where.am.I;

import java.awt.BorderLayout;

import general.definition.Window;

public class Lunch {

	public static void main(String[] args){

		// create the window
		Window window = new Window("WhereAmI", 500, 500, true);

		// set personal Icon
		window.setPersonalIcon("C:\\Users\\d-ous\\OneDrive\\Pictures\\proto2.png");
		
		
		window.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
		
		
		
		// let the show begin
		window.setVisible(true);
	}
}
