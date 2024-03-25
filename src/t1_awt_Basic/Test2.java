package t1_awt_Basic;

import java.awt.Frame;

// Frame 객체를 상속받아서 작업처리
@SuppressWarnings("serial")  // 작업 끝난후에
public class Test2 extends Frame {
	
	// 객체를 생성시에 UI설계(유저 화면) 처리를 한다.
	public Test2() {  // 기본생성자
		super("AWT 프레임");  // super 생략된 것
		//setTitle("AWT 프레임");  // 상속을 받으면 frame. 메소드를 부르지 않고 상속받았으니까 부모거니까 사용가능
		setSize(300, 250);
		
		setVisible(true);		
	}
	
	public static void main(String[] args) {  // 메인 메소드가 상속받는 경우 => 앱의 경우 다수
		//Frame frame = new Frame();  // 상속받은면 만들지 않음
		new Test2();  // jvm은 main을 부르고 여기서 Test2를 부름
	}
}
