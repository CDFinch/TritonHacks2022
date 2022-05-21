import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Fish {

	int x = 0; 
	int y = 0 ; 
	private AffineTransform tx;
	private Image img; 	
	
	public Fish(int x, int y) {
		
			img = getImage("/imgs/tropicalFish.png" ); //load the image for Treessssssss
			tx = AffineTransform.getTranslateInstance(x, y ); 
			init(x, y); 				//initialize the location of the image
			
			//use your variabless
	}
	
	
	
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actually picture location
		update();
		
		
		
		
		g2.drawImage(img, tx, null);
	}
	/* update the picture variable locssssations */
	private void update() {

		tx.setToTranslation(x, y);
		tx.scale(0.2, 0.2);
		 
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.2, 0.2);
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}

}

