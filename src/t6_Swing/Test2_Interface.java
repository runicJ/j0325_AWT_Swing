package t6_Swing;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

// 스윙의 종료를 인터페이스로 이용.
@SuppressWarnings("serial")
public class Test2_Interface extends JFrame implements WindowListener {

	public Test2_Interface() {
		super("스윙연습2");
		
		setBounds(300, 250, 300, 250);
		
		setVisible(true);
		
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new Test2_Interface();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) { System.exit(0); }

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
