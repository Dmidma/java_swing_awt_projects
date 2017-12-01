package general.definition;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	

	/**
	 * This construct create a default window.
	 * It will have "A Window" as a title, 500x500 as size, and it can be resized.
	 * @param title the title of the window.
	 */
	public Window(String title) {

		lookAndFeel();
			
		this.setTitle(title);
		this.setSize(500, 500);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	/**
	 * This construct create a window with parameters.
	 * @param title will be the title of the created window.
	 * @param width will be the width of the created window.
	 * @param height will be the height of the created window.
	 * @param notResizable will be true if the created window can get resized.
	 */
	public Window(String title, int width, int height, boolean notResizable) {
		
		lookAndFeel();
		
		this.setTitle(title);
		this.setSize(width, height);
		this.setResizable(notResizable);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/**
	 * Given a path of the image, this function will get the image and set it as Icon for
	 * the current window.
	 * @param path hopefully a valid path to the image.
	 */
	public void setPersonalIcon(String path) {


		try {
			// opening the image
			File aFile = new File(path);
			// getting the image
			ImageIcon image = new ImageIcon(aFile.getAbsolutePath());

			this.setIconImage(image.getImage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public final static void lookAndFeel() {
		// Look & Feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
            System.err.println("Couldn't use system look and feel.");
        }
	}



}
