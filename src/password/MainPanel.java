package password;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import general.definition.Menu;
import general.definition.Window;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainPanel extends JPanel {


	private static final long serialVersionUID = 2L;

	
	// Main Frame
	private Window window;
	
	// handlers for events
	private ManageEvent event;


	public MainPanel(Window window) {
		this.window = window;
		this.event = new ManageEvent();
		
		
		setIntroImage();
		setNewSafePane();
		
		setMenuBar();
		
		window.getContentPane().add(this, BorderLayout.CENTER);
		window.setVisible(true);
	}
	

	private void setIntroImage() {

		
	
		JLabel label = new JLabel("");

		label.setPreferredSize(new Dimension(500, 700));
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("img/bank_image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(500, 700,
				Image.SCALE_SMOOTH);



		ImageIcon image = new ImageIcon(dimg);
		
		
		label.setIcon(image);

		this.add(label, BorderLayout.CENTER);

	}
	
	
	private void setMenuBar() {
		
		// create a JMenuBar
		Menu menu = new Menu();
		
		// Main menus
		String[] menus = {"Open", "Generate Pass.", "How To"};
		menu.addMenuElems(menus);
		
		
		// Items for the "Open" menu
		String[] openItems = {"New Safe", "Open Safe", "Close Safe"};
		menu.addItemsToMenu(openItems, "Open");
		
		
		// Items for the "Generate Pass."
		String[] generItems = {"Generate a Password"};
		menu.addItemsToMenu(generItems, "Generate Pass.");
		
		
		//Items for the "How To"
		String[] howItems = {"Start a Tutorial"};
		menu.addItemsToMenu(howItems, "How To");
		
		// Add Listeners
		menu.addMenuListenerToMenu(event);
		menu.addActionListenerToItems(event);
		
		// That's all Folks !!!
		this.window.setJMenuBar(menu);
	}


	
	private void setNewSafePane() {

		// remove previous components
		this.removeAll();
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Indicator
		JLabel indic = new JLabel("Create a New Safe");
		
		this.add(indic);
		
		
		
		// create labels with the given texts
		String[] texts = {"UserName", "Password"};
		JLabel[] labels = new JLabel[2];
		JPanel[] userPanel = new JPanel[2];
		JTextField[] fields = new JTextField[2];
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(texts[i]);
			fields[i] = new JTextField();
			
			
			userPanel[i] = new JPanel();
			userPanel[i].setLayout(new BoxLayout(userPanel[i], BoxLayout.LINE_AXIS));
			
			userPanel[i].setPreferredSize(new Dimension(500, 10));
			
		
			
			fields[i].setPreferredSize(new Dimension(300, 100));
			
			userPanel[i].add(labels[i]);
			userPanel[i].add(fields[i]);
			
			
			
			fields[i].setSize(100, 50);
			
			
			this.add(userPanel[i]);
			
			
			
		}
		
		
		
	}

	
}	