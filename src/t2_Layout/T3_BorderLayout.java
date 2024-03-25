package t2_Layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T3_BorderLayout extends Frame implements WindowListener, ActionListener {
	Button btn1, btn2, btn3, btn4, btn5;
	
	public T3_BorderLayout() {
		super("BorderLayout 연습!");  // super로 settitle 사용
		setBounds(300, 250, 300, 300);
		setLayout(new BorderLayout());  // flowlayout는 왼쪽->오른쪽 위->아래
		
		btn1 = new Button("북쪽");
		btn2 = new Button("남쪽");
		btn3 = new Button("서쪽");  //왼
		btn4 = new Button("동쪽");
		btn5 = new Button("중앙(종료)");
		add(btn1, BorderLayout.NORTH); // add를 넣으면서 위치를 지정해 줘야함 // 안그러면 중앙만 나옴  // 열거형 상수로 지정(class이름.xx)
		add(btn2, BorderLayout.SOUTH);
		add(btn3, BorderLayout.WEST);
//		add(btn4, BorderLayout.EAST);
//		add(btn5, BorderLayout.CENTER);
		add(btn4, "East");  // 첫글자 대문자 나머지 소문자만 가능(EAST, east 불가 오류)
		add(btn5, "Center");
		
		setVisible(true);
		
		addWindowListener(this);
		btn5.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T3_BorderLayout();  // 생성자 먼저 올리기
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
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
