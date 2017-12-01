package organizer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import general.definition.Menu;
import general.definition.Window;

public class MenuMonitor implements MenuListener, ActionListener {
	
	// used when the organization process will begin
	private JTextField pathField = null;
	
	private Menu menu = null;
	
	
	private Window window = null;
	
	public MenuMonitor(Window window, JTextField pathField) {
		
		// get the path field so when the user starts the configuration It will work
		// on the current directory
		
		// retrieve used components
		this.pathField = pathField;
		this.window = window;
		
		
		// create menu
		this.menu = new Menu();
		// configure Menu 
		configMenu();
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		Object current = arg0.getSource();
		
		if (current.equals(menu.getMenuElem("Exit"))) {
			// close the window
			window.dispose();
		}
		else if (current.equals(menu.getMenuElem("About"))) {
			// create a JDialog to print the about section
			JDialog aboutDialog = new JDialog(window, "About", true);

			JLabel aboutLabel = new JLabel("Available soon in the Internation Market of goodies.",
					SwingConstants.CENTER);
			aboutLabel.setFont(aboutLabel.getFont().deriveFont(20.0f));
			aboutDialog.getContentPane().add(aboutLabel, BorderLayout.CENTER);
			aboutDialog.setSize(new Dimension(700, 100));
			aboutDialog.setLocationRelativeTo(window);
			menu.getMenuElem("About").setFocusable(false);
			menu.getMenuElem("About").setSelected(false);
			aboutDialog.setVisible(true);
		}
		
	}
	
	
	/**
	 * This private method will create menus and menu items and set its listener.
	 */
	private void configMenu() {
		
		// creating and adding the Menu to the window
		String[] titles = {"Start", "Config", "About", "Exit"};
		menu.addMenuElems(titles);
		window.setJMenuBar(menu);

		// Items for the Open Menu
		String[] openItems = {"How", "Organize It"};
		// Add items to the Open Menu
		menu.addItemsToMenu(openItems, "Start");

		// Items for the Effect Menu
		String[] effectItems = {"Default", "Modified"};
		// Add items to the Effect Menu
		menu.addItemsToMenu(effectItems, "Config");
		
		
		// set the listeners
		menu.addActionListenerToItems(this);
		menu.addMenuListenerToMenu(this);
	}
	
	
}
