
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileSystemView;

import general.definition.JListFileRenderer;
import general.definition.Window;

public class RenderIt {


	private DefaultListModel listModel = new DefaultListModel();
	private JScrollPane jscroll;
	private JList list;



	public static void main(String[] args) {

		Window window = new Window("Render");

		Window.lookAndFeel();
		
	    RenderIt re = new RenderIt();
	    re.confi(window);
	    
	    window.setVisible(true);
	}


	private void confi(Window window) {
		list = new JList();

		list.setModel(listModel);
		
		list.setCellRenderer(new JListFileRenderer());
		
		File fi = new File("C:\\Users\\d-ous\\Downloads");
		File[] listf = fi.listFiles();
		for (int i = 0; i < listf.length; i++) {
			listModel.addElement(listf[i]);
		}
		
		jscroll = new JScrollPane(list);
		
		JPanel panel = new JPanel();
		panel.add(jscroll);
		
		window.getContentPane().add(panel, BorderLayout.CENTER);
	}


}
