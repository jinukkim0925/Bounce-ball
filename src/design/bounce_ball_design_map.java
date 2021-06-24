package design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class bounce_ball_design_map extends JFrame	implements Runnable{

	JPanel jp1,ap,np,sp,wp,cp,ep;
	public int wall[][] = new int[35][20],feed[][] = new int[28][28], draw = 1;
	public bounce_ball_design_map() {
		// TODO Auto-generated constructor stub
		setTitle("바운스볼");
		setDefaultCloseOperation(2);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		add(cp = new JPanel(new BorderLayout()),BorderLayout.CENTER);
		add(np = new JPanel(new BorderLayout()),BorderLayout.NORTH);
		add(sp = new JPanel(new BorderLayout()),BorderLayout.SOUTH);
		add(ep = new JPanel(new BorderLayout()),BorderLayout.EAST);
		add(wp = new JPanel(new BorderLayout()),BorderLayout.WEST);
		
		size(cp,1050,600);
		cp.setBackground(Color.black);
		
		cp.add(ap = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				for (int i = 0; i < wall.length; i++) {
					for (int j = 0; j < wall[i].length; j++) {
						g.setColor(Color.blue);
						g.drawRect(i*30, j*30, 30, 30);
						if (wall[i][j] == 1) {
							g.fillRect(i*30, j*30, 30, 30);	
						}
					}
				}
			}
		});
		ap.setBackground(Color.black);
		ap.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if (draw == 1) {
					wall[e.getX()/30][e.getY()/30] = 1;
				}else {
					wall[e.getX()/30][e.getY()/30] = 0;
				}
				repaint();
			}
		});
		ap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				draw = e.getButton();
				String s="";
				if (e.getButton() == 2) {
					for (int i = 0; i < wall.length; i++) {
						s ="";
						for (int j = 0; j < wall[i].length; j++) {
							if (j == wall.length-1) {
								s = s+wall[i][j];	
							}else {
								s = s+wall[i][j] +",";
							}
							
						}
						System.out.println("{" + s +"},");
					}
				}
			}
		});
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new bounce_ball_design_map();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void size(JComponent c, int x, int y) {
		c.setPreferredSize(new Dimension(x,y));
	}

}
