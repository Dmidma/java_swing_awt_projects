	package where.am.I;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 3L;
	
	
	
	public MainPanel() {
		this.setLayout(new BorderLayout());
		
		JTextField filed = new JTextField();
		
		filed.setText("C:\\Users\\d-ous\\Documents");
		JButton prec = new JButton("<-");
		
		JSplitPane northPane = new JSplitPane();
		
		northPane.add(prec, JSplitPane.LEFT);
		northPane.add(filed, JSplitPane.RIGHT);
		
		this.add(northPane, BorderLayout.NORTH);
	
		
		
		//JScrollPane cenPane = new JScrollPane();
		
		//JLabel label = new JLabel("Red was here", SwingConstants.CENTER);
		
		//JList<JLabel> list = new JList<JLabel>();
		
		//cenPane.add(list);
		
		JTextArea textArea = new JTextArea("");
		
		this.add(textArea, BorderLayout.CENTER);
		
		JScrollPane lefPane = new JScrollPane();
		
		lefPane.setPreferredSize(new Dimension(150, 100));
		
		File file = new File("C:\\Users\\d-ous\\Documents");

		if (file.isDirectory()) {
			//label.setText(Long.toString(file.getTotalSpace()));
			File[] listf = file.listFiles();
			for (int i = 0; i < listf.length; i++) {
				textArea.setText(textArea.getText().concat(listf[i].getName()).concat("\n"));
			}
		
		}
		
		
		this.add(lefPane, BorderLayout.WEST);
		
	}
}
