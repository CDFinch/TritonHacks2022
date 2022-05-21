import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import javax.swing.Timer;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JPanel;

public class Fish {
	Random rnd = new Random();
	double x = 300; 
	double y = 200 ; 
	double vx = 3; 
	double vy = 3; 
	double accx = -.1; 
	double accy = -.1; 
	private AffineTransform tx;
	private Image img; 	
	int width = 149; 
	int height = 66; 
//	boolean right = true; 
//	boolean down = true; 
	
	public Fish(int x, int y) {
		
			img = getImage("/imgs/tropicalFish.png" ); //load the image for Treessssssss
			tx = AffineTransform.getTranslateInstance(x, y ); 
			init(x, y); 				//initialize the location of the image
			
			//use your variabless
	}
	
	
	
	
	
	
	
	Timer move = new Timer(1000, new ActionListener() {
        @Override

        public void actionPerformed(ActionEvent arg0) {
        	vx = rnd.nextInt((3 + 3 ) + 1) - 3 ; // [-20, 20]
    		vy = rnd.nextInt((3 + 3 ) + 1) - 3 ; // [-20, 20]

        }
    });
	
	
	public void move() { 
		move.setInitialDelay(0);
		move.start(); 
		move.setRepeats(true); 
	
	} 
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		x += vx; 
		y += vy; 
		
		
//		vx = rnd.nextInt((3 + 3 ) + 1) - 3 ; // [-20, 20]
//		vy = rnd.nextInt((3 + 3 ) + 1) - 3 ; // [-20, 20]
		
		if(x + width > 1000) { 
			x = 1000-width  ; 
		}
		if( x < 0 ) { 
			x = 0   ; 
		}
		if( y < 0 ) { 
			y = 0   ; 
		}
		if( y + height > 625 ) { 
			y = 625 - height  ;
		}
		
		
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
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		
//		
//		
//	}

}

