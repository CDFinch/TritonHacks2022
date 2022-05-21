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
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener{
	
	Background background = new Background(0,0);
		
		public void paint(Graphics g) {
			super.paintComponent(g);
			background.paint(g);
		}
	


		public static void main(String[] arg) {
			Frame f = new Frame();
			
		}
		
		
		public Frame() {
			
			JFrame f = new JFrame("Temp");
			f.setSize(new Dimension(1000,625));
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


