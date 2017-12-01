package todolist;

import java.awt.BorderLayout;

import general.definition.Window;

public class Lunch {

	public static void main(String[] args) {
        
		Window window = new Window("To Do");
		window.lookAndFeel();
		
		
		window.getContentPane().add(new ToDoList());
		
		window.setVisible(true);

	}

}
