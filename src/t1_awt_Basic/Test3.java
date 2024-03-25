package t1_awt_Basic;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 종료버튼처리...(인터페이스를 이용~)
@SuppressWarnings("serial")
public class Test3 extends Frame implements WindowListener {  // 상속, 인터페이스(추상메소드) 동시 가능
	
	// 객체를 생성시에 UI설계(유저 화면) 처리를 한다.
	public Test3() {
		super("AWT 프레임");
		//setTitle("AWT 프레임");  // 상속을 받으면 frame. 메소드를 부르지 않고 상속받았으니까 부모거니까 사용가능
		setSize(300, 250);
		
		setVisible(true);
		
		addWindowListener(this);  // 나를 감시하다가 동작 실행
	}
	
	public static void main(String[] args) {
		new Test3();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {  // 닫는 동작
		System.exit(0);  // 실행종료(윈도우창 닫기) // jvm 닫는 것  // 감지하는 리스너가 있어야함
	}

	@Override
	public void windowClosed(WindowEvent e) {}  // 닫은 다움

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}
	
	@Override
	public void windowDeactivated(WindowEvent e) {}
}
