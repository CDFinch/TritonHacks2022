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
import java.awt.image.AffineTransformOp;
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
import java.awt.image.ImageObserver;

public class Fish {
	Random rnd = new Random();
	private double x = 300;
	private double y = 200;
	double vx = 3;
	double vy = 3;
	double accx = -.1;
	double accy = -.1;
	private AffineTransform tx;
	private Image img;
	int width;
	int height;
	double multiplier;
	double spdMultiplier; 
	private int type;
	static int numFish = 0;
	static int numType1 = 0;
	static int numType2 = 0;
	static int numType3 = 0;
	static int numKills2; 
	static int numKills3; 
	double scale;
//	boolean right = true; 
//	boolean down = true; s

	public Fish(int x, int y, int type) {
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
		switch (type) {
		case 1:
			this.type = 1;
			this.x = x;
			this.y = y;
			img = getImage("/imgs/lilFishR.png");
			numType1++;
			scale = 0.03;
			width = (int) (1920 * scale);
			height = (int) (1120 * scale);
			spdMultiplier = 1.7; 
			break;
		case 2:
			this.type = 2;
			this.x = x;
			this.y = y;
			img = getImage("/imgs/tropicalFishR.png");
			numType2++;
			scale = 0.1456753;
			width = (int) (746 * scale);
			height = (int) (328 * scale);
			spdMultiplier = 1.2; 
			break;
		case 3:
			this.type = 3;
			this.x = x;
			this.y = y;
			img = getImage("/imgs/sharkR.png");
			numType3++;
			scale = 0.3;
			width = (int) (1024 * scale);
			height = (int) (326 * scale);
			spdMultiplier = .8; 
			break;
		default:
			this.type = 2;
			this.x = x;
			this.y = y;
			img = getImage("/imgs/tropicalFish.png");
			scale = 0.2;
			width = (int) (746 * 0.2);
			height = (int) (328 * 0.2);
			
		}
		multiplier = 1;
		numFish++;

	}
	
	Timer move = new Timer( rnd.nextInt((3000 -1000) + 1) + 1000, new ActionListener() {
		@Override

		public void actionPerformed(ActionEvent arg0) {
			vx = rnd.nextInt((3 + 3) + 1) - 3; // [-20, 20]
			vy = rnd.nextInt((3 + 3) + 1) - 3; // [-20, 20]

			
		}
	});
	
	Timer reproduce = new Timer( 2000, new ActionListener() {
		@Override

		public void actionPerformed(ActionEvent arg0) {
			vx = rnd.nextInt((3 + 3) + 1) - 3; // [-20, 20]
			vy = rnd.nextInt((3 + 3) + 1) - 3; // [-20, 20]

			System.out.println(width);
			System.out.println(height);
		}
	});

	public void move() {
		move.setInitialDelay(0);
		move.start();
		move.setRepeats(true);

	}
	public void incrMultiplier() {
		multiplier += 0.2;
	}
	
	
	
	public void paint(Graphics g) {
		// these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		if(vx > 0) {
			switch (type) {
			case 1:
				img = getImage("/imgs/lilFishR.png");
				break;
			case 2:
				img = getImage("/imgs/tropicalFishR.png");
				break;
			case 3:
				img = getImage("/imgs/sharkR.png");
			break;
			}
		}
		if(vx < 0) {
			switch (type) {
			case 1:
				img = getImage("/imgs/lilFishL.png");
				break;
			case 2:
				img = getImage("/imgs/tropicalFishL.png");
				break;
			case 3:
				img = getImage("/imgs/sharkL.png");
			break;
			}
		}
		x += vx * multiplier * spdMultiplier;
		y += vy * multiplier * spdMultiplier;

//		vx = rnd.nextInt((3 + 3 ) + 1) - 3 ; // [-20, 20]
//		vy = rnd.nextInt((3 + 3 ) + 1) - 3 ; // [-20, 20]

		if (x + width > 1000) {
			x = 1000 - width;
		}
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		if (y > 625 - height) {
			y = 625 - height;
		}

		// call update to update the actually picture location
		update();

		g2.drawImage(img, tx, null);
	}

	/* update the picture variable locssssations */
	private void update() {

		tx.setToTranslation(x, y);
		tx.scale(scale, scale);

	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(scale, scale);
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

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	public int getType() {
		return type;
	}
}
