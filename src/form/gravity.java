package form;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aframe.aframe;

public class gravity extends aframe {

	Thread th = new Thread(this);
	int h = 1, jp = 0, x = 50, inc[][] = new int[5][2], botton = 1000, doublejump = 0;

	int red = new Color(255, 0, 0).getRGB();

	double g = 1, m = 1;
	BufferedImage bi;
	static int p1, p2, p3, p4;

	public gravity() {

		// TODO Auto-generated constructor stub
		fs("바운스볼");
		np.add(jp1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				for (int i = 0; i < inc.length; i++) {
					g.setColor(new Color(220 - i * 50, 220 - i * 50, 220 - i * 50));
					g.fillOval(inc[i][0], inc[i][1], 30, 30);
				}
				g.setColor(Color.yellow);
				g.fillOval(x, h, 30, 30);

				// 장애물
				g.setColor(Color.red);
				g.fillRect(0, 480, 800, 20);
				g.fillRect(400, 200, 50, 300);
				g.fillRect(300, 350, 100, 30);
				//
				Graphics2D g2 = bi.createGraphics();
//				this.paintAll(g2);
			}
		});

		jp1.setBackground(Color.white);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == 37) {
					for (int i = 0; i < 3; i++) {
						try {
							if (bi.getRGB(p1, p4 + 15) == red) {
								return;
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
						x--;
						repaint();
						revalidate();
					}
					if (e.getKeyCode() == 32) {
						x = x - 30;
					}
				}
				if (e.getKeyCode() == 39) {
					for (int i = 0; i < 3; i++) {
						try {
							if (bi.getRGB(p3+20, p4 + 15) == red) {
								return;
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
						x++;
						repaint();
						revalidate();
					}
				}
				if (e.getKeyCode() == 32) {
					System.out.println(g);
					
					if (g <= 0) {
						g = 11;
						jp = 1;
						doublejump = 1;
					}else if (doublejump == 1) {
						g = 5;
						jp = 1;
						doublejump = 0;
					}

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				BitSet b = new BitSet();
				b.set(e.getKeyCode());

			}
		});

		size(jp1, 800, 500);

		sh();
		bi = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bi.createGraphics();
		this.paintAll(g2);

		th.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (true) {

//			System.out.println(jp + "/" + g + "/" + h);
			for (int i = 1; i < inc.length; i++) {
				for (int j = 0; j < 2; j++) {
					inc[i - 1][j] = inc[i][j];
				}
			}
			inc[4][0] = x;
			inc[4][1] = h;
			if (jp == 0) {
				g = g + 0.098;
				h = (int) (h + g);
			} else {
				g = g - 0.098;
				h = (int) (h - g);
			}
			try {
				th.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// p1 = left
			// p2 = up
			// p3 = right
			// p4 = down

			p1 = x;
			p2 = h;
			p3 = x + 30;
			p4 = h + 30;

			if (p4 + 33 >= 0) {
				try {
					if (bi.getRGB(p3+5, p4 + 35) == red || bi.getRGB(p1 + 5, p4 + 35) == red) {
						jp = 1;
						doublejump = 1;
						g = g - m * 0.98;
						if (g <= 1) {
							g = 0;
						}
//						System.out.println("a");
					} else if (g <= 0) {
						jp = 0;
					}
					if (bi.getRGB(p1 + 5, p2+30) == red || bi.getRGB(p3, p2+30) == red) {
						System.out.println("a");
						jp = 0;
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
//			if (h > botton) {
//				jp = 1;
//				g = g - m * 0.98;
//				if (g <= 2) {
//					g = 0;
//				}
//			} else if (g <= 0) {
//				jp = 0;
//			}
//			botton = 100000;
			
			repaint();
			revalidate();
		}
	}

	public static void main(String[] args) {
//		new gravity();
		new bounceball();
	}
}
