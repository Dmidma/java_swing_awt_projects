package exams;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.Event;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

public class SimpleMeny extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public SimpleMeny() {
		
		this.configMainMenu();
		this.setVisible(true);
	    
	}
	

	
	
	private void configMainMenu() {
		
		//String[] mainMenu = {"A text-only menu item", "Both text and icon"};
		String[] mainMenu = {"A Menu", "Another Menu"};
		
		for (int i = 0; i < mainMenu.length; i++) {
			this.add(new JMenu(mainMenu[i]));
		}
		
		this.getMenu(1).setMnemonic('n');
		
		JMenu aMenu = this.getMenu(0);
		aMenu.setMnemonic('A');
		
		configItems(aMenu);
		configRadio(aMenu);
		configCheck(aMenu);
		configSubMenu(aMenu);
	}
	
	private void configItems(JMenu menu) {
		
		String[] items = {"A text-only menu item", "Both text and icon"};
		
		for (int i = 0; i < items.length; i++) {
			menu.add(new JMenuItem(items[i]));
		}
		
		
		menu.addSeparator();
	}
	
	private void configRadio(JMenu menu) {
		
		ButtonGroup bg = new ButtonGroup();
		
		String[] buttons = {"A radio button menu item", "Another one"};
		
		for (int i = 0; i < buttons.length; i++) {
			JRadioButtonMenuItem jrb = new JRadioButtonMenuItem(buttons[i]);
			
			bg.add(jrb);
			menu.add(jrb);
		}
		
		
		

		
		menu.addSeparator();
		
	}
	
	private void configCheck(JMenu menu) {
		
		String[] buttons = {"A check box menu item", "Another one"};
		
		for (int i = 0; i < buttons.length; i++) {
			JCheckBoxMenuItem jcb = new JCheckBoxMenuItem(buttons[i]);
			menu.add(jcb);
		}
		
		
		menu.addSeparator();
	}
	
	
	private void configSubMenu(JMenu menu) {
		
		JMenu aMenu = new JMenu("A submenu");
		
		aMenu.setMnemonic('s');
		
		aMenu.add(new JMenuItem("An item in the submenu"));
		aMenu.add(new JMenuItem("Another item"));
		
		aMenu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, Event.ALT_MASK));
		
		menu.add(aMenu);
		
		
		
	}
}
