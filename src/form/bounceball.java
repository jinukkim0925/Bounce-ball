package form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;

import javax.swing.JPanel;

import aframe.aframe;
import base.map;

public class bounceball extends aframe{

	int h = 300, jp = 0, x = 50, inc[][] = new int[5][2];
	double g = 1, m = 1;
	
	JPanel bounce;
	Thread th = new Thread(this);
	boolean run = true;
	
	
	public bounceball() {
		// TODO Auto-generated constructor stub
		fs("바운스볼");
		
		cp.add(ap = new JPanel(new BorderLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				for (int i = 0; i < map.stage1.length; i++) {
					for (int j = 0; j < map.stage1[i].length; j++) {
						if (map.stage1[i][j] == 1) {
							g.setColor(Color.red);
							g.fillRect(i*30, j*30, 30, 30);
						}
					}
				}
			}
		});
		
		ap.setBackground(Color.white);
		size(cp,1050,600);
		size(ap,1050,600);
	
		ap.add(bounce = new JPanel() {
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
			}
		});
		
		bounce.setOpaque(false);
		size(bounce,1050,600);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == 37) {
					for (int i = 0; i < 3; i++) {
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
						x++;
						repaint();
						revalidate();
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
		
		th.start();
		sh();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (run) {
			try {
//				System.out.println(jp + "/" + g + "/" + h);
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
				
				th.sleep(10);
				
				int x2 = x + 30;
				if (map.stage1[x/30][(h+30)/30] == 1 || map.stage1[x2/30][(h+30)/30] == 1) {
					jp = 1;
					g = 5;
				} else if (g <= 0) {
					jp = 0;
				}
				
				
				repaint();
				revalidate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
	
}
