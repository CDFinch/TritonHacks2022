import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Random;
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
import java.awt.Graphics2D;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Random rnd = new Random();//a
	Background background = new Background(0, 0);
	int currentFish = 1; 
	String current = "Goldfish";
	String one = "";
	String two = ""; 
	String three = ""; 
	Fish goldfish = new Fish(1020, 330,1); 
	Fish tropicalFish = new Fish(1105, 330,4); 
	Fish shark = new Fish(1190, 335,5); 
	//Fish tropicalFish = new Fish(1020)s
	
	

	ArrayList<Fish> fishes = new ArrayList<Fish>();

	Timer reproduce1 = new Timer( 500, new ActionListener() {
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			
			fishes.add(new Fish(rnd.nextInt((1000) + 1), rnd.nextInt((625) + 1), 1));
		}
	});
	
	Timer reproduce2 = new Timer( 5000, new ActionListener() {
		@Override
		
		public void actionPerformed(ActionEvent arg0) {
			fishes.add(new Fish(rnd.nextInt((1000) + 1), rnd.nextInt((625) + 1), 2));
		}
	});

	public void reproduce() {
		reproduce1.start();
		reproduce1.setRepeats(true);
		reproduce2.start();
		reproduce2.setRepeats(true);


	}
	
	
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		background.paint(g);
		goldfish.paint(g);
		tropicalFish.paint(g);
		shark.paint(g);

		for (int i = 0; i < fishes.size(); i++) {
			fishes.get(i).paint(g);
			fishes.get(i).move();
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Fish", Font.BOLD, 15));

		g.drawString(one, 1020, 500);
		//g.drawString(two, 1020, 550);
		//g.drawString(three, 1020, 600);
		
//		for(int first = 0; first< fishes.size()-1;first++) {
//			Fish temp1 = fishes.get(first);
//			for(int second = 1; second < fishes.size()-2;second++) {
//				Fish temp2 = fishes.get(second);
//				if(temp1.getX() < temp2.getX()+temp2.width  
//						&& temp1.getX()+temp1.width > temp2.getX()
//						&& temp1.getY() < temp2.getY()+temp2.height
//						&& temp1.getY()+ temp1.height> temp2.getY()){
//					System.out.println("hit");
//					fishes.add(new Fish(rnd.nextInt((1000) + 1), rnd.nextInt((625) + 1), 1));
//				}
//			}
//		}
		
		for(int first = 0; first< fishes.size();first++) {
			Fish temp1 = fishes.get(first);
			for(int second = first + 1 ; second < fishes.size();second++) {
				Fish temp2 = fishes.get(second);
				if(temp1.getX() + temp1.width >= temp2.getX() 
						&& (temp1.getX() <= temp2.getX()+temp2.width)
						&& temp1.getY() + temp1.height >= temp2.getY()
						&& temp1.getY() <= temp2.getY()+temp2.height) {
					if((temp1.getType() == 1 && temp2.getType() == 2) || 
							(temp1.getType() == 2 && temp2.getType() == 3) ) {
						fishes.remove(first);
						if(temp1.getType() == 1 ) { 
							Fish.numType1--; 
							
							if(temp2.getType() == 2 ) { 
								one = "A Tropical Fish Has Eaten A Goldfish!";
								three = two;
								two = one; 
								Fish.numKills2++; 
								 
							}
							
							
						}
						if(temp1.getType() == 2 ) { 
							Fish.numType2--; 
							if(temp2.getType() == 3 ) { 
								one = "A Shark Has Eaten A Tropical Fish!";
								Fish.numKills3++; 
								two = one; 
								three = two; 
								
							}
						}
					
						//Fish.kills++; 
						
						
					}
					if((temp1.getType() == 2 && temp2.getType() == 1) 
							|| (temp1.getType() == 3 && temp2.getType() == 2)) {
						fishes.remove(second);
						//Fish.kills++; 
						if(temp2.getType() == 1 ) { 
							Fish.numType1--; 
							if(temp1.getType() == 2 ) { 
								one = "A Tropical Fish Has Eaten A Goldfish!";
								two = one; 
								three = two; 
								Fish.numKills2++; 
							}
							
							
						}
						if(temp2.getType() == 2 ) { 
							Fish.numType2--; 
							if(temp1.getType() == 3 ) { 
								one = "A Shark Has Eaten A Tropical Fish!";
								two = one; 
								three = two; 
								Fish.numKills3++; 
							}
						}
					}
					
					
				//fishy funk 
//					if(temp1.getType() == temp2.getType() && temp1.getType() != 3 ) { 
//						fishes.add(new Fish(rnd.nextInt((1000) + 1), rnd.nextInt((625) + 1), temp1.getType()));
//					}
					
					
				}
			}
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Fish", Font.ITALIC, 20));
		
		g.drawString("ECOSYSTEM STATISTICS: " , 1010, 30);
		
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Fish", Font.ITALIC|Font.BOLD, 15));
		
		
		
		g.drawString("Goldfish Population: " + Fish.numType1, 1010, 50);

		g.drawString("Tropical Fish Population: " + + Fish.numType2, 1010, 80);
		g.drawString("Tropical Fish Kills: " + Fish.numKills2, 1010, 100);

		g.drawString("Shark Population: " + + Fish.numType3, 1010, 130);
		g.drawString("Shark Kills: " + Fish.numKills3 , 1010, 150);
		g2.setStroke(new BasicStroke(5));

        g.drawRect(1010, 320, 80, 50);
       // g.drawString("Goldfish", 1020, 350);

        g.drawRect(1100, 320, 80, 50);
        //g.drawString("Tropical ", 1110, 345);
        //g.drawString("Fish ", 1120, 360);

        g.drawRect(1190, 320, 80, 50);
        //g.drawString("Shark", 1200, 350);
        
        g.drawRect(1010, 380, 260, 50);
        g.drawString("Spawn", 1110, 410);
	}

	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}

	public Frame() {
		Fish.numType1--;
		reproduce();
		for(int i =0; i < 20; i++) {
			fishes.add(new Fish(rnd.nextInt((1000) + 1), rnd.nextInt((625) + 1), 1));
		}
		for(int i =0; i < 5; i++) {
			fishes.add(new Fish(rnd.nextInt((1000) + 1), rnd.nextInt((625) + 1), 2));
		}
		fishes.add(new Fish(rnd.nextInt((1000) + 1), rnd.nextInt((625) + 1), 3));
		
		
		
		JFrame f = new JFrame("Temp");
		f.setSize(new Dimension(1300, 650));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1, 2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int mx = (int) arg0.getX();
		int my = (int) arg0.getY();
		System.out.println(mx + " " + my);

		if (mx >= 1010 && mx < 1100 && my >= 320 && my <= 380) {
            current = "Goldfish";
            currentFish = 1; 

        }

        if (mx >= 1100 && mx < 1190 && my >= 320 && my <= 380) {
            current = "Tropical Fish";
            currentFish = 2;
        }

        if (mx >= 1190 && mx < 1280 && my >= 320 && my <= 380) {
            current = "Shark";
            currentFish = 3; 
        }
        if (mx >= 1010 && mx < 1270 && my >= 412 && my <= 460) {
            fishes.add(new Fish(rnd.nextInt((1000) + 1),rnd.nextInt((625) + 1),currentFish));
            switch(currentFish) { 
            case 1: one = "You Have Spawned A Goldfish!"; 
            two = one; 
			three = two; 
            break; 
            case 2: one = "You Have Spawned A Tropical Fish!"; 
            two = one; 
			three = two; 
            break; 
            case 3: one = "You Have Spawned A Shark!"; 
            two = one; 
			three = two; 
            break; 
            }
        }


	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}
	// bathe them in iron

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
