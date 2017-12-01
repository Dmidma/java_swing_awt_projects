import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Applit extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x = -30;
	public int y = -30;
	
	private void drawStar (Graphics g, int x, int y) {
		int[] tabx= {x, x+5, x+15, x+5, x+15, x, x-15, x-5, x-15, x -5};
		 int[] taby= {y, y-10, y - 10, y - 20, y - 30, y- 25, y - 30, y - 20, y - 10, y -10};
		
		 g.fillPolygon(tabx, taby, 10);
	}
	
	public void paint(Graphics g) {
		
		super.resize(new Dimension(500, 500));
		
	}
	public Applit(){
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				x = arg0.getX();
				y = arg0.getY();
				
				drawStar(getGraphics(), x, y);
				
			}
		});
	}

}
