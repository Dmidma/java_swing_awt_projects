package exams;

import java.awt.Dimension;
import javax.swing.JFrame;

public class LunchIt {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Exams");
		
		window.setSize(new Dimension(700, 700));
		
		
		window.setJMenuBar(new SimpleMeny());
		
		
		
		window.setVisible(true);
		
	}

}
