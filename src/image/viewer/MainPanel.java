package image.viewer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 2L;

	private JScrollPane mainPanel;

	public MainPanel() {
		initialConfig();
	}

	
	/**
	 * This method will return the mainPanel.
	 * @return the main panel (JScrollPane).
	 */
	public JScrollPane getMainPanel() {
		return mainPanel;
	}

	
	/**
	 * This private method will create JScrollPane, set a BorderLayout and an indicator for no images.
	 */
	private void initialConfig() {
		// create the JScrollPane
		this.mainPanel = new JScrollPane();
		// setting the BorderLayout
		this.setLayout(new BorderLayout());
		
		// create an indicator for no image
		JLabel noImage = new JLabel("No Images for now", SwingConstants.CENTER);
		noImage.setFont(noImage.getFont().deriveFont(20.0f));
		
		// adding every thing to the main panel
		mainPanel.getViewport().add(noImage, BorderLayout.CENTER);
		this.add(mainPanel, BorderLayout.CENTER);

	}

}
