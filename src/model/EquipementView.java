package model;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import general.definition.Window;

public class EquipementView {
	
	private JFrame window = null;
	private JTable aTable = null;
	
	public EquipementView() {
		
		configUI();
	
	}
	
	
	private void configUI() {
		window = new JFrame("test");
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setSize(1000, 1000);
		
		
		aTable = new JTable();
		
		//Vector<Vector<String>> data = new Vector<Vector<String>>();
		//Vector<String> columns = new Vector<String>();
		
		//aTable.setModel(new DefaultTableModel(data, columns));
		
		//aTable.setModel(new EquipementModel());
		
		JScrollPane scrollPane = new JScrollPane();
	
		
		scrollPane.getViewport().add(aTable);
		
		window.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		window.setVisible(true);
	}
	

}
