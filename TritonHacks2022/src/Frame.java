import java.awt.event.ActionListener;
	import java.awt.event.KeyListener;
	import java.awt.event.MouseListener;
	import java.awt.image.BufferedImage;
import java.awt.BasicStroke;
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
	import java.awt.Graphics2D;
	
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener{
	
	Background background = new Background(0,0);
	Fish test = new Fish(0,0);
	String current = "Fish1"; 
	ArrayList<Fish> fishes = new ArrayList<Fish>(); 
	
	
	
	
	public void spawn() { 
		fishes.add(new Fish(0,0));
	}
	
	
		public void paint(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			background.paint(g);
			
			
			test.paint(g);
			test.move();
			
			g2.setStroke(new BasicStroke(5));
			g.setColor(Color.BLACK);
			g.setFont(new Font("Fish", Font.BOLD, 20));
			
			g.drawString("Current Fish: " + current, 1050, 30 ); 
			
			
			g.drawRect(1010, 50, 80, 50);
			g.drawString("Fish1", 1020, 80);
			
			g.drawRect(1100, 50, 80, 50);
			g.drawString("Fish2", 1110, 80);
			
			g.drawRect(1190, 50, 80, 50);
			g.drawString("Fish3", 1200, 80);
			
			g.drawRect(1115, 120, 100, 50);
			g.drawString("Spawn", 1130, 150);
		}
	
		

		public static void main(String[] arg) {
			Frame f = new Frame();
			
		}
		
		
		public Frame() {
			
			JFrame f = new JFrame("Temp");
			f.setSize(new Dimension(1520,700));
			f.setBackground(Color.blue);
			f.add(this);
			f.setResizable(false);
			f.setLayout(new GridLayout(1,2));
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
			 
			 if(mx >= 1010 && mx < 1100 && my >= 80 && my <= 140 ) { 
				 current = "Fish1";
			 }
			 
			 if(mx >= 1100 && mx < 1190 && my >= 80 && my <= 140 ) { 
				 current = "Fish2";
			 }
			 
			 if(mx >= 1190 && mx < 1280 && my >= 80 && my <= 140 ) { 
				 current = "Fish3";
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
		//bathe them in iron
		

		@Override
		public void keyReleased(KeyEvent arg0) {
		
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
			
		}



	}


