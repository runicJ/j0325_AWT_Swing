package t3_mouse;

import java.awt.Frame;  // ctrl shift o
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T2_KeyboardEvent extends Frame implements WindowListener, KeyListener {
	
	public T2_KeyboardEvent() {
		super("마우스 이벤트 연습!");
		
		setBounds(300, 250, 300, 300);

		setVisible(true);
		
		addWindowListener(this);
		addKeyListener(this);
	}
	
	public static void main(String[] args) {
		new T2_KeyboardEvent();
	}
	
	// 윈도우 리스너를 위한 메소드 7개(핸들러)
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

	// Keyboard 이벤트 발생에 따른 리스너를 위한 메소드 3개  // 리듬게임
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("키보드 입력중...");
	}
	
	// 키보드를 눌렀을때..
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("키보드를 누르고 있습니다.");  // Type과 비슷하나 보통 이거 하나만 사용
		System.out.println("입력된 키는? " + e.getKeyChar());
	}

	// 키보드를 눌렀다 떼는 순간...
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("키보드를 눌렀다가 놓으셨군요..");
	}
}
