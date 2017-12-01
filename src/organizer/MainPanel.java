package organizer;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;


import general.definition.Window;

public class MainPanel extends JPanel {

	// TODO: implements Listener

	private static final long serialVersionUID = 2L;

	// text field for the path
	private JTextField pathField = null;

	// two buttons for the next and the previous directory
	private JButton next = null, prev = null;


	// pane for the tree
	private JScrollPane treePane = null;
	// pane for the current directory
	private JScrollPane direcPane = null;

	private JLabel information = null;

	
	
	public MainPanel(Window window) {

		configInterface(window);
	}

	/**
	 * This private method will configure the UI and nothing more.
	 * @param window the JFrame that will hold the interface.
	 */
	private void configInterface(Window window) {


		// set the layout for the main panel
		this.setLayout(new BorderLayout());


		// Setting the head part of the window
		JPanel headPane = new JPanel();
		headPane.setLayout(new BoxLayout(headPane ,BoxLayout.X_AXIS));

		// Create the buttons and the text field and add them to the head part
		prev = new JButton("<-");
		next = new JButton("->");
		pathField = new JTextField("C:");
		headPane.add(pathField, BoxLayout.X_AXIS);
		headPane.add(next, BoxLayout.X_AXIS);
		headPane.add(prev, BoxLayout.X_AXIS);
		this.add(headPane, BorderLayout.NORTH);

		// Setting the folder ad tree UI
		treePane = new JScrollPane();
		direcPane = new JScrollPane();
		JSplitPane separator = new JSplitPane();

		separator.add(treePane, JSplitPane.LEFT);
		separator.add(direcPane, JSplitPane.RIGHT);

		treePane.setLayout(new ScrollPaneLayout());

		information = new JLabel("Information");

		this.add(information, BorderLayout.SOUTH);


		this.add(separator, BorderLayout.CENTER);
		

		// let the show starts
		window.getContentPane().add(this);
	}
	
	
	/**
	 * Getter for the pathField.
	 * @return the JTextField that contains the path of the current directory.
	 */
	public JTextField getPathField() {
		return this.pathField;
	}
	
	/**
	 * Getter for the next button.
	 * @return the JButton that will be used to access the next directory.
	 */
	public JButton getNext() {
		return this.next;
	}
	
	/**
	 * Getter for the previous button.
	 * @return the JButton that will be used to access the previous directory.
	 */
	public JButton getPrev() {
		return this.prev;
	}
	
	/**
	 * Getter for the treePane.
	 * @return the JScrollPane that will manipulate the JTree.
	 */
	public JScrollPane getTreePane() {
		return this.treePane;
	}
	
	
	/**
	 * Getter for the direcPane.
	 * @return the JScrollPane that will manipulate the JList.
	 */
	public JScrollPane getDirecPane() {
		return this.direcPane;
	}
	
	
	/**
	 * Getter for the information.
	 * @return the JLabel that will hold additional informations about the current directory.
	 */
	public JLabel getInformation() {
		return this.information;
	}
}
