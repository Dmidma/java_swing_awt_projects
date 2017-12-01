package general.definition;

import java.awt.Color;
import java.awt.Component;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.filechooser.FileSystemView;

public class JListFileRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;
	
	
	private FileSystemView fileSystemView;
	private JLabel label;
	
	private Color textSelectionColor = Color.BLACK;
	private Color backgroundSelectionColor = Color.CYAN;
	private Color textNonSelectionColor = Color.BLACK;
	private Color backgroundNonSelectionColor = Color.WHITE;

	public JListFileRenderer() {
		// create the label
		label = new JLabel();
		// paint every pixel of the label
		label.setOpaque(true);
		// get the default file system view
		fileSystemView = FileSystemView.getFileSystemView();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Component getListCellRendererComponent(
			JList list,
			Object value,
			int index,
			boolean selected,
			boolean expanded) {

		File file = (File)value;
		
		// set the default icon of the file
		label.setIcon(fileSystemView.getSystemIcon(file));
		label.setText(fileSystemView.getSystemDisplayName(file));
		
		// make the font bigger
		label.setFont(label.getFont().deriveFont(15.5f));
		
		// when hovered, displays the full path of the file
		try {
			label.setToolTipText(file.getPath());
		} catch (NullPointerException nullEx) {
			
		}
		// change the back/fore - ground of the label when selected
		if (selected) {
			label.setBackground(backgroundSelectionColor);
			label.setForeground(textSelectionColor);
		} else {
			label.setBackground(backgroundNonSelectionColor);
			label.setForeground(textNonSelectionColor);
		}

		return label;
	}
	
	
	/**
	 * Getters to change the colors of the text and background
	 * when the label is selected.
	 */
	
	public void setTextSelectionColor(Color newColor) {
		this.textSelectionColor = newColor;
	}
	
	public void setBackgroundSelectionColor(Color newColor) {
		this.backgroundSelectionColor = newColor;
	}
	
	public void setTextNonSelectionColor(Color newColor) {
		this.textNonSelectionColor = newColor;
	}
	
	public void setBackgroundNonSelectionColor(Color newColor) {
		this.backgroundNonSelectionColor = newColor;
	}

}
