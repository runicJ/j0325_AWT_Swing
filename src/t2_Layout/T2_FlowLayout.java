package t2_Layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T2_FlowLayout extends Frame implements WindowListener, ActionListener {  // 인터페이를 이용해 사용방법
	Button btn1, btn2, btn3, btn4, btn5;  // 미리 작업(선언)
	Label lbl1, lbl2, lbl3, lbl4, lbl5;
	
	// 생성자를 통해서 UI 설계처리한다.
	public T2_FlowLayout() {
		super("FlowLayout 연습!");  // 프레임 상속 받아야함
		setLayout(new FlowLayout()); // layout 설정  // flowlayout만듬(항상 가운데 정렬, 창을 줄여도 사라지지 않음)
		setBounds(300, 250, 300, 300);
		
		btn1 = new Button("버튼1");  // 선언하고 여기서 다시 선언하면 이 메소드 안에서만 사용가능 Button btn1
		btn2 = new Button();  // 독립적으로 움직임 => 객체지향이라서 가능
		btn2.setLabel("버튼2");  // 버튼2라는 것이 btn2에 지정됨.
		btn3 = new Button("버튼3");
		btn4 = new Button("버튼4");
		btn5 = new Button("버튼5");
		
		this.add(btn1);  // this 생략가능
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		// 레이블 설계
		lbl1 = new Label("제목1");
		lbl2 = new Label("제목2");
		lbl3 = new Label("제목3");
		lbl4 = new Label("제목4");
		lbl5 = new Label("제목5");  // 만들고 프레임에 뿌려야함
		add(lbl1);
		add(lbl2);
		add(lbl3);
		add(lbl4);
		add(lbl5);
		
		setVisible(true);  // 보여달라
		
		addWindowListener(this);
		btn3.addActionListener(this);  // 현재 것에 대해서 닫아주세요  // 리스너(이벤트 감지) 그에 따른 코드 작성
	}
	
	public static void main(String[] args) {  // 생성자 올리고 메인(메인에서 생성자를 부름=자기자신 부름)을 따로 올림
		new T2_FlowLayout();
	}
	
	// 버튼에 의해서
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	//window에 의해서 처리 되는 핸들러
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
