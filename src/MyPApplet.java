
import processing.core.*;

public class MyPApplet extends PApplet {

	
	private static final long serialVersionUID = 1L;
	
	
	private String URL = "http://photos1.blogger.com/blogger/5177/621/1600/duke_000.gif";
	private PImage backgroundImg;
    
	
	// Configure canvas
    // Executed once
	public void setup() {
	    size(200, 200);
	    backgroundImg = loadImage(URL, "gif");
	}
	
    // Display content
    // Loops often
	public void draw() {
		
		// the width is 0 so the resize method will auto-calculate the width/height ratio
		// height is a PApplet variable that holds the height of the canvas
		backgroundImg.resize(0, height);
		
		image(backgroundImg, 0, 0);
		
		
		int[] color = sunColorSec(second());
		fill(color[0], color[1], color[2]);
		ellipse(width / 4, height / 5, width / 5, height / 5);
	}
	
	private int[] sunColorSec(float seconds) {
		
		int[] rgb = new int[3];
		
		float diffFrom30 = Math.abs(30 - seconds);
		
		float ratio = diffFrom30 / 30;
		
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;
		
		
		return rgb;
		
	}

}
