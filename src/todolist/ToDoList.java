package todolist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

public class ToDoList extends JPanel{
	
	private JTextField todo = new JTextField();
	private JButton add = new JButton("ADD");
	private JList<String> liste;
	private JScrollPane scroll;
	
	public ToDoList(){
		
		liste = new JList<String>();
		
		this.setLayout(new BorderLayout());
		
		JPanel nord = new JPanel();
		
		nord.setLayout(new FlowLayout());
		nord.add(todo);
		nord.add(add);
		nord.setBackground(new Color(0,0,0));
		
		todo.setPreferredSize(new Dimension(100, 20));
		
		this.add(nord, BorderLayout.NORTH);
		
		
		
		scroll = new JScrollPane();
		//centre.add(scroll, BorderLayout.CENTER);
	
		this.add(scroll, BorderLayout.CENTER);

		scroll.getViewport().add(new JLabel("hello"), BorderLayout.CENTER);
		
		
		
		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals("ADD")){
					JLabel field = new JLabel(todo.getText());
					liste.add(field);
					scroll.getViewport().add(field, BorderLayout.CENTER);
				}
				
			}
		});
	}
	
}
