package aframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class aframe extends JFrame implements ActionListener, MouseListener, KeyListener, WindowListener, Runnable{

	public JPanel jp1,jp2,jp3,p,pp,ppp,p1,p2,p3,p4,cp,np,wp,sp,ep,ap;
	public JLabel jl;
	public SimpleDateFormat ss = new SimpleDateFormat("mm:ss:SS");
	
	public void fs(String s) {
		setDefaultCloseOperation(2);
		setTitle(s);
		add(cp = new JPanel(new BorderLayout()),BorderLayout.CENTER);
		add(np = new JPanel(new BorderLayout()),BorderLayout.NORTH);
		add(sp = new JPanel(new BorderLayout()),BorderLayout.SOUTH);
		add(wp = new JPanel(new BorderLayout()),BorderLayout.WEST);
		add(ep = new JPanel(new BorderLayout()),BorderLayout.EAST);
	}
	
	public void sh() {
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void size(JComponent c , int x ,int y) {
		c.setPreferredSize(new Dimension(x,y));
	}
	
	public void imsg(String s) {
		JOptionPane.showMessageDialog(null, s,"Á¤º¸",JOptionPane.INFORMATION_MESSAGE);
	}
	public void wmsg(String s) {
		JOptionPane.showMessageDialog(null, s,"°æ°í",JOptionPane.ERROR_MESSAGE);
	}
	
	public int rei(String s ) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			// TODO: handle exception
			return 0 ;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}