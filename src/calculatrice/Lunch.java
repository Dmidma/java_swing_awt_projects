package calculatrice;

import java.awt.BorderLayout;
import java.awt.Dimension;


import javax.swing.JLabel;

import general.definition.*;

public class Lunch {

	public static void main(String[] args){

		// create the window
		Window window = new Window("Calculator", 350, 400, false);


		// calculator screen
		JLabel screen = new JLabel("0");


		// Making Font Bigger
		screen.setFont(screen.getFont().deriveFont(32.0f));


		screen.setPreferredSize(new Dimension(350, 100));

		
		// TODO: Manipulate negative values 
		

		window.getContentPane().add(screen, BorderLayout.NORTH);
		window.getContentPane().add(new MainPanel(screen), BorderLayout.SOUTH);



		// let the show begin
		window.setVisible(true);
	}
}
