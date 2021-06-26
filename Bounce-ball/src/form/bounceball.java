package form;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import aframe.aframe;
import base.map;

public class bounceball extends aframe {

	int h = 300, jp = 0, x = 50, inc[][] = new int[5][2];
	double g = 1, m = 1;

	JPanel bounce;
	Thread th = new Thread(this);
	boolean run = true, eatstar = false;

	private static int stage = 1;
	private static long smilli = 0, emilli = 0;
	private static int wall[][] = new int[35][20];
	private static int star[][] = new int[35][20];

	public static void main(String[] args) {
		new bounceball();
	}

	public bounceball() {
		// TODO Auto-generated constructor stub
		fs("�ٿ��");

		// �� ����
		map.stage.add(map.stage6);
		map.stage.add(map.stage5);
		map.stage.add(map.stage4);
		map.stage.add(map.stage3);
		map.stage.add(map.stage2);
		map.stage.add(map.stage1);

		// �� ����
		base.star.star.add(base.star.stage6);
		base.star.star.add(base.star.stage5);
		base.star.star.add(base.star.stage4);
		base.star.star.add(base.star.stage3);
		base.star.star.add(base.star.stage2);
		base.star.star.add(base.star.stage1);

		// �ҷ�����
		wall = map.stage.pop();
		wall = map.stage.pop();
		wall = map.stage.pop();
		wall = map.stage.pop();
		wall = map.stage.pop();
		wall = map.stage.pop();

		star = base.star.star.pop();
		star = base.star.star.pop();
		star = base.star.star.pop();
		star = base.star.star.pop();
		star = base.star.star.pop();
		star = base.star.star.pop();

		// ��0
		cp.add(ap = new JPanel(new BorderLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				// ��
				for (int i = 0; i < wall.length; i++) {
					for (int j = 0; j < wall[i].length; j++) {
						if (wall[i][j] == 1) {
							g.setColor(Color.red);
							g.fillRect(i * 30, j * 30, 30, 30);
						}
					}
				}

				// ��
				for (int i = 0; i < wall.length; i++) {
					for (int j = 0; j < wall[i].length; j++) {
						if (star[i][j] == 1) {
							ImageIcon ic = new ImageIcon("img/star.png");
							Image im = ic.getImage();
							g.drawImage(im, i * 30, j * 30, 30, 30, this);
						}
					}
				}

			}
		});

		ap.setBackground(Color.white);
		size(cp, 1050, 600);
		size(ap, 1050, 600);

		ap.add(bounce = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
//				for (int i = 0; i < inc.length; i++) {
//					g.setColor(new Color(220 - i * 50, 220 - i * 50, 220 - i * 50));
//					g.fillOval(inc[i][0], inc[i][1], 30, 30);
//				}
				g.setColor(Color.yellow);
				g.fillOval(x, h, 30, 30);
				g.setColor(Color.black);
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(2));
				g2.drawOval(x, h, 30, 30);
//				if (eatstar) {
//					for (int i = 0; i < 5; i++) {
//						g2.fillOval(x+i*10, h+i*10, 20, 20);
//					}
//					eatstar = false;
//				}
			}
		});

		bounce.setOpaque(false);
		size(bounce, 1050, 600);

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
					if (e.getKeyCode() == 37) {
						for (int i = 0; i < 4; i++) {
							if (wall[(x - 1) / 30][h / 30] == 1 || wall[(x - 1) / 30][(h + 30) / 30] == 1) {// ����
								return;
							}
							x--;
							getstar(x, h);
							repaint();
							revalidate();
						}
					}
					if (e.getKeyCode() == 39) {
						for (int i = 0; i < 4; i++) {
							if (wall[(x + 31) / 30][h / 30] == 1 || wall[(x + 31) / 30][(h + 30) / 30] == 1) {// ������
								return;
							}
							x++;
							getstar(x, h);
							repaint();
							revalidate();
						}
					}
				} catch (Exception e2) {
					// TODO: handle exception
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
		smilli = System.currentTimeMillis();
		sh();
	}

	public void getstar(int x, int h) {
		try {
			if (x < 0 || h < 0 || (h + 30) < 0 || (h + 30) / 30 > 19 || (x + 30) / 30 > 34) {

			} else {
				if (star[x / 30][h / 30] == 1) {
					star[x / 30][h / 30] = 0;
					eatstar = true;
					return;
				}
				if (star[x / 30][(h + 30) / 30] == 1) {
					star[x / 30][(h + 30) / 30] = 0;
					eatstar = true;
					return;
				}
				if (star[(x + 30) / 30][h / 30] == 1) {
					star[(x + 30) / 30][h / 30] = 0;
					eatstar = true;
					return;
				}
				if (star[(x + 30) / 30][(h + 30) / 30] == 1) {
					star[(x + 30) / 30][(h + 30) / 30] = 0;
					eatstar = true;
					return;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (run) {
			try {
//				System.out.println(jp + "/" + g + "/" + h);
//				for (int i = 1; i < inc.length; i++) {
//					for (int j = 0; j < 2; j++) {
//						inc[i - 1][j] = inc[i][j];
//					}
//				}
				inc[4][0] = x;
				inc[4][1] = h;
				if (jp == 0) {
					g = g + 0.098;
					h = (int) (h + g);
				} else {
					g = g - 0.098;
					h = (int) (h - g);
				}

				if (x < 0 || h < 0 || (h + 30) < 0 || (h + 30) / 30 > 19 || (x + 30) / 30 > 34) {

				} else {
					getstar(x, h);
				}
				th.sleep(10);

				int x2 = x + 29;

				if (x <= 0 || h < -30 || (h + 30) / 30 > 19 || (x + 29) / 30 > 34) {
					// �� ��
//					System.err.println(h + "/" + x);
					if (h >= 600) {
						// ����
						gameEnd();
					}
				} else {
//					System.out.println(h + "/" + x);
					if (wall[(x + 1) / 30][(h + 30) / 30] == 1 || wall[x2 / 30][(h + 30) / 30] == 1) {// �ٴ�
						jp = 1;
						g = 5;

					} else if (g <= 0) {
						jp = 0;
					}

					if (wall[(x + 1) / 30][h / 30] == 1 || wall[x2 / 30][h / 30] == 1) {// õ��
						jp = 0;
					}
				}

				int cnt = 0;
				for (int i = 0; i < wall.length; i++) {
					for (int j = 0; j < wall[i].length; j++) {
						if (star[i][j] == 1) {
							cnt++;
						}
					}
				}

				if (cnt == 0) {// �������� Ŭ����
					if (map.stage.size() == 0) {
						// �ٱ�
						stage++;
						gameEnd();
					} else {
						h = 300;
						x = 50;
						wall = map.stage.pop();
						star = base.star.star.pop();
						stage++;
					}
				}

				repaint();
				revalidate();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

	public void gameEnd() {
		emilli = System.currentTimeMillis();
		String s = JOptionPane.showInputDialog(this,
				"�������� : " + stage + " \n �ɸ��ð� : " + ss.format(emilli - smilli) + " \n�̸��� �Է��� �ּ���. :");
		dispose();
		run = false;
	}

}
