package image.viewer;



import general.definition.*;


public class Launch {

	public static void main(String[] args){
		
		
		Window.lookAndFeel();
		
		// create the window
		Window window = new Window("ImageViewer", 500, 500, true);
		
		// set personal Icon
		window.setPersonalIcon("C:\\Users\\d-ous\\OneDrive\\Pictures\\proto2.png");

		MainPanel mainPanel = new MainPanel();

		
		// configure menu and listeners
		new MenuActionMonitor(window, mainPanel.getMainPanel(), new Menu());
		
		
		window.getContentPane().add(mainPanel);
		
		// let the show begin
		window.setVisible(true);
	}



}
