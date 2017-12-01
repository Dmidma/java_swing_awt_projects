package image.viewer;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import general.definition.Menu;




public class MenuActionMonitor implements MenuListener, ActionListener {

	private JFrame window;
	private JScrollPane panel;

	private Menu menu = null;

	// current selected file
	private File file = null;
	
	
	// the current image
	private ImageIcon image = null;

	public MenuActionMonitor(JFrame window, JScrollPane panel, Menu menu) {

		this.menu = menu;
		this.window = window;
		this.panel = panel;
		
		configMenu();
	}



	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub


	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuSelected(MenuEvent e) {
		Object current = e.getSource();
		
		if (current.equals(menu.getMenuElem("Exit"))) {
			// close the window
			window.dispose();
		}
		else if (current.equals(menu.getMenuElem("About"))) {
			// create a JDialog to print the about section
			JDialog aboutDialog = new JDialog(window, "About", true);

			JLabel aboutLabel = new JLabel("This little program can open images and apply some effects on them.",
					SwingConstants.CENTER);
			aboutLabel.setFont(aboutLabel.getFont().deriveFont(20.0f));
			aboutDialog.getContentPane().add(aboutLabel, BorderLayout.CENTER);
			aboutDialog.setSize(new Dimension(700, 100));
			aboutDialog.setLocationRelativeTo(null);
			menu.getMenuElem("About").setFocusable(false);
			menu.getMenuElem("About").setSelected(false);
			aboutDialog.setVisible(true);
		}
	}


	// TODO: make the file or/and image all private variables
	// so we can save, and change effect as we want to 

	private void open() {
		JFileChooser fileChooser = new JFileChooser("C:\\Users\\d-ous\\Pictures");


		// if the cancel option was selected
		if (fileChooser.showOpenDialog(window) == JFileChooser.CANCEL_OPTION)
			return;

		this.file = fileChooser.getSelectedFile();

		String extension = file.getName();
		if (extension.endsWith("jpg") || extension.endsWith("png")) {
			JLabel lab = new JLabel("", SwingConstants.CENTER);
			image = new ImageIcon(file.getAbsolutePath());

			// TODO: re-factor this section into another method 
			//BufferedImage invIm = invertImage(file.getAbsolutePath());
			//image = new ImageIcon(invIm);

			lab.setIcon(image);
			panel.getViewport().add(lab, BorderLayout.CENTER);

		}
	}

	private void save() {

		// exit if no file is opened
		if (file == null)
			return;

		JFileChooser fileChooser = new JFileChooser("C:\\Users\\d-ous\\Pictures");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		// exit if cancel option was selected
		if (fileChooser.showSaveDialog(window) == JFileChooser.CANCEL_OPTION)
			return;


		try {
			RenderedImage saveImage = (RenderedImage) image.getImage();
			ImageIO.write(saveImage, "png", new File(fileChooser.getSelectedFile().getAbsolutePath() + ".png"));
		} catch (IOException e) {

		}
		/*
		file.setText(fileChooser.getSelectedFile().getName());
		file.set
        dir.setText(fileChooser.getCurrentDirectory().toString());
		 */
	}

	/**
	 * This private method will invert the colors of a current image is opened. 
	 * @param file the file of the opened image.
	 * @return the image with inverted colors.
	 */
	private BufferedImage invertImage(File file) {


		// no opened file
		if (file == null)
			return null;


		// get the buffered image
		BufferedImage inputFile = null;

		// catch exception
		try {
			inputFile = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		// iterate over the pixels of the image
		for (int x = 0; x < inputFile.getWidth(); x++) {
			for (int y = 0; y < inputFile.getHeight(); y++) {
				int rgba = inputFile.getRGB(x, y);
				Color col = new Color(rgba, true);
				col = new Color(255 - col.getRed(),
						255 - col.getGreen(),
						255 - col.getBlue());
				inputFile.setRGB(x, y, col.getRGB());
			}
		}

		// return the bufferedImage
		return inputFile;
	}

	private void configMenu() {
		// creating and adding the Menu to the window
		String[] titles = {"Open", "Effect", "About", "Exit"};
		menu.addMenuElems(titles);
		window.setJMenuBar(menu);

		// Items for the Open Menu
		String[] openItems = {"New Image", "Save"};
		// Add items to the Open Menu
		menu.addItemsToMenu(openItems, "Open");

		// Items for the Effect Menu
		String[] effectItems = {"Negative", "Blur"};
		// Add items to the Effect Menu
		menu.addItemsToMenu(effectItems, "Effect");
		
		// add listeners to all menu
		menu.addActionListenerToItems(this);
		menu.addMenuListenerToMenu(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		// what's the command
		String cmd = e.getActionCommand();
		if ("New Image".equals(cmd)) {
			open();
		}
		else if ("Save".equals(cmd)) {
			// TODO: save the image
			save();
		}
		else if ("Negative".equals(cmd)) {

			try {
				JLabel lab = new JLabel("", SwingConstants.CENTER);
				BufferedImage im = invertImage(file);
				if (im == null)
					return;
				image = new ImageIcon(im);
				lab.setIcon(image);
				panel.getViewport().add(lab, BorderLayout.CENTER);
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		}
		else if ("Blur".equals(cmd)) {
			// TODO: apply the blur effect on the image if it does exist
		}

	}

}
