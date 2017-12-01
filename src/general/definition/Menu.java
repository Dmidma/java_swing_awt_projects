package general.definition;


import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;

public class Menu extends JMenuBar {


	private static final long serialVersionUID = 2L;


	// TODO: add a function that iterate over the menuElems and an other over itemElems
	// and add the wanted listeners; instead of each element alone

	// the elements of the menu
	private List<JMenu> menuElems;

	// the items of the menu
	private List<JMenuItem> itemElems;


	public Menu() {
		menuElems = new LinkedList<JMenu>();
		itemElems = new LinkedList<JMenuItem>();
	}


	/**
	 * Given an array of titles, this method will create JMenu elements and add them to
	 * the current JMenuBar.
	 * @param titles an array of wanted JMenu elements.
	 */
	public void addMenuElems(String[] titles) {

		// iterate over the titles and add the JMenu elements
		for (int i = 0; i < titles.length; i++) {
			addMenuElem(titles[i]);
		}
	}

	/**
	 * This method will create a JMenu give it the specified title and add it to the JMenuBar.
	 * It will also add it to the list
	 * @param title the title of the added JMenu.
	 */
	private void addMenuElem(String title) {
		JMenu addedElem = new JMenu(title);
		this.add(addedElem);
		menuElems.add(addedElem);
	}


	/**
	 * This method will return all JMenus of the current JMenuBar.
	 * @return a list of JMenu elements.
	 */
	public List<JMenu> getMenuElems() {
		return menuElems;
	}

	/**
	 * This method will return all JMenuItems of the current JMenuBar.
	 * @return a list of JMenuItem elements.
	 */
	public List<JMenuItem> getItemElems() {
		return itemElems;
	}


	/**
	 * This method will return the JMenu with the specified title.
	 * This function can catch Exception and return null.
	 * @param title the title of the wanted JMenu.
	 * @return the wanted JMenu element.
	 */
	public JMenu getMenuElem(String title) {

		try {
			for (Iterator<JMenu> i = menuElems.iterator(); i.hasNext();) {
				JMenu current = i.next();
				if (title.equals(current.getText())) 
					return current;
			}


		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


		return null;
	}

	/**
	 * This method will add an item to an existing menu.
	 * 
	 * @param item the added item.
	 * @param menuTile
	 */
	private void addItemToMenu(JMenuItem item, String menuTile) {
		if (item == null) {
			return;
		}

		// adding the item to the wanted menu
		try {
			getMenuElem(menuTile).add(item);
			// adding item to the list
			itemElems.add(item);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addItemsToMenu(String[] items, String menuTile) {

		// do not do anything if items are empty
		if (items == null || items.length == 0) {
			return;
		}
		
		// Iterate over the string array and add them to the wanted menu, and to the list of items
		for (Iterator<JMenuItem> i = Menu.createMenuItems(items).iterator(); i.hasNext();) {
			JMenuItem current = i.next();
			addItemToMenu(current, menuTile);
		}
	}
	
	/**
	 * This method will return the JMenuItem with the specified title.
	 * This function can catch Exception and return null.
	 * @param itemTitle the title of the wanted JMenuItem
	 * @return the wanted JMenuItem element.
	 */
	public JMenuItem getItemElem(String itemTitle) {

		try {
			for (Iterator<JMenuItem> i = itemElems.iterator(); i.hasNext();) {
				JMenuItem current = i.next();
				if (itemTitle.equals(current.getText())) 
					return current;
			}


		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


		return null;
	}
	
	/**
	 * This method will add action listener to all available items
	 * @param action
	 */
	public void addActionListenerToItems(ActionListener action) {
		for (Iterator<JMenuItem> i = this.itemElems.iterator(); i.hasNext();) {
			i.next().addActionListener(action);
		}
	}
	
	
	public void addMenuListenerToMenu(MenuListener action) {
		for (Iterator<JMenu> i = this.menuElems.iterator(); i.hasNext();) {
			i.next().addMenuListener(action);
		}
	}
	
	
	
	
	/**
	 * This method will iterate over the given item titles and create JMenuItems add them to a list
	 * and return them.
	 * @param itemsTitles the titles of the created JMenuItems.
	 * @return a list containing all created JMenuItems.
	 */
	public final static List<JMenuItem> createMenuItems(String[] itemsTitles) {
		
		// initializing the list of items
		LinkedList<JMenuItem> listItems = new LinkedList<JMenuItem>();
		
		// iterate over the item titles
		for (int i = 0; i < itemsTitles.length; i++) {
			JMenuItem current = new JMenuItem(itemsTitles[i]);
			listItems.add(current);
		}
		
		// return the created list
		return listItems;
	}
	
	
	
}
