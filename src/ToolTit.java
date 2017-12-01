import java.awt.Toolkit;

import javax.tools.Tool;

public class ToolTit {
	
	public static Toolkit tool = Toolkit.getDefaultToolkit();
	
	public static void main(String [] args) {
		
		while (true) {
			ToolTit.tool.beep();
		}
		
	}
}
