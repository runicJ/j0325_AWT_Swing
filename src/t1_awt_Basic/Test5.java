package t1_awt_Basic;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 종료버튼처리...(인터페이스를 이용~)
@SuppressWarnings("serial")
public class Test5 extends Frame implements WindowListener, ActionListener {  // 상속, 다중 인터페이스(추상메소드) 동시 가능
	
	// 객체를 생성시에 UI설계(유저 화면) 처리를 한다.
	public Test5() {
		super("AWT 프레임");
		//setTitle("AWT 프레임");  // 상속을 받으면 frame. 메소드를 부르지 않고 상속받았으니까 부모거니까 사용가능
		setBounds(300, 200, 350, 250);  // 프레임의 위치/크기(x축, y축, 폭, 높이) : 픽셀단위
		
		// 레이블 컴포넌트
		Label lbl1 = new Label("레이블 테스트입니다.");  // 전부 객체  // 윈도우 창에 올림
		//this.add(lbl1); // this는 현재 창 // -Dfile.encoding=MS949 run configu argument (인자/vm여기 넣기)
		add(lbl1);  // 메소드명 앞의 this는 생략가능
		
		Button btnExit = new Button("종료");  // 컴포넌트 생성하고 꼭 컴포넌트를 프레임에 올려야함
		add(btnExit);  // this.add(btnExit)  // 패널 위에 올리면 덮어쓰지 않음
		
		setVisible(true);
		
		// 리스너(윈도우 감지부분 처리 - 윈도우 리스너)
		addWindowListener(this);  // 나를 감시하다가 동작 실행
		btnExit.addActionListener(this);  // 인터페이스 가져온 것 // btnExit버튼을 감시한다 .add 버튼은 actionlistener
	}
	
	public static void main(String[] args) {
		new Test5();
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

	@Override
	public void actionPerformed(ActionEvent e) {  // 버튼에 관계된 것 => actionlistener 메소드
		System.exit(0);
	}
}
