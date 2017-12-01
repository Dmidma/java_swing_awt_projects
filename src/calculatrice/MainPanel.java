package calculatrice;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	
	private static final long serialVersionUID = 2L;

	// the informations that will be written on the buttons of the calculator
	private char [] buttonsText = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', '=', 'C', '+', '-', '*', '/'};
	
	
	private List<JButton> calcButtons;
	
	public MainPanel(JLabel screen) {
		
		
		// create the buttons and store them in the list
		makeButtons(buttonsText);
		
		setButtons(0, 12, 4, 3, 5, 5, 70, 60, screen);
		
		setButtons(12, 17, 5, 1, 0, 2, 70, 50, screen);
		
	}
	
	/**
	 * This private function will create a JPanel add the set of buttons.
	 * @param sideButtons
	 * @param rows
	 * @param cols
	 * @param hgap
	 * @param vgap
	 * @param bWidth
	 * @param bHeight
	 */
	private void setButtons(int beg, int end, int rows, int cols, int hgap, int vgap, int bWidth, int bHeight, JLabel screen) {
		
		JPanel aPanel = new JPanel();
		
		GridLayout aGrid = createGrid(rows, cols, hgap, vgap);
		
		aPanel.setLayout(aGrid);
		
		// Button dimension
		Dimension theD = new Dimension(bWidth, bHeight);
		
		// add the buttons to the layout
		for (int i = beg; i < end; i++) {
			getButton(i).setPreferredSize(theD);
			getButton(i).addActionListener(new ActionMonitor(screen));
			aPanel.add(getButton(i));
		}
		
		// add aPanel to the main JPanel
		this.add(aPanel);
		
	}
	
	/**
	 * This private method will create buttons and store them in a list.
	 * @param buttonsText will be the labels written on the buttons.
	 */
	private void makeButtons(char[] buttonsText) {
		
		// create the list
		this.calcButtons = new LinkedList<JButton>();
		
		for (int i = 0; i < buttonsText.length; i++) {
			this.calcButtons.add(new JButton(Character.toString(buttonsText[i])));
		}
		
	}
	
	/**
	 * This private function create GridLayout and set the passed arguments than returned.
	 * @param rows number of rows in the GridLayout.
	 * @param cols number of columns in the GridLayout.
	 * @param hgap the horizontal gap between the grid.
	 * @param vgap the vertical gap between the grid.
	 * @return a GridLayout after adapting its arguments.
	 */
	private GridLayout createGrid(int rows, int cols, int hgap, int vgap) {
		
		// Creating the grid layout
		GridLayout aGrid = new GridLayout(rows, cols);
		
		// setting the h-gap and v-gap
		aGrid.setHgap(hgap);
		aGrid.setVgap(vgap);
		
		return aGrid;
	}
	
	/**
	 * This method will return one of the buttons stored in the list.
	 * @param index is the index of the button in the array.
	 * @return the indexed JButton.
	 */
	public JButton getButton(int index) {
		
		try {
			return this.calcButtons.get(index);
		}
		catch (IndexOutOfBoundsException excep) {
			System.out.println("Buttons.getButton.exception");
			return null;
		}
	}
}
