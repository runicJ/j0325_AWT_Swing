package t3_mouse;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T3_ButtonEvent2 extends Frame implements WindowListener, ActionListener {
	Button btnPlay, btnStop, btnExit, btnMessage;
	Label lblMessage;
	
	public T3_ButtonEvent2() {
		super("버튼 이벤트 연습!");
		setLayout(new FlowLayout());
		setBounds(350, 300, 300, 250);
		
		// 버튼객체 생성 및 배치
		btnPlay = new Button("Start");
		btnStop = new Button("Stop");
		btnExit = new Button("Exit");
		btnMessage = new Button("Message");
		add(btnPlay);
		add(btnStop);
		add(btnExit);
		add(btnMessage);

		// 레이블 생성 및 배치
		lblMessage = new Label();  // 크기지정 안하면 기본 메시지만 띄울 수 있게 생성됨
		lblMessage.setSize(150, 20);
		add(lblMessage);
		lblMessage.setBackground(Color.MAGENTA);  // 색 열거형
		
		setVisible(true);
		
		addWindowListener(this);
		btnPlay.addActionListener(this);  // 3개의 버튼 모두 감시
		btnStop.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new T3_ButtonEvent2();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {  // 버튼 수행 모두 여기서 작성
		Button btnText = (Button) e.getSource();  // 버튼 = object객체임 다운캐스팅 // 모두 버튼에 관한 것 // e는 이벤트
		
		if(btnText.getLabel().equals("Start")) {
			//System.out.println("시작버튼을 누르셨군요.");
			lblMessage.setText("시작버튼 클릭!!");  // 전역변수니까 여기서도 사용 가능
			btnMessage.setLabel("시작버튼 클릭!!");  // 버튼에 출력
		}
		else if(btnText.getLabel().equals("Stop")) {
			//System.out.println("정지버튼을 누르셨군요.");
			lblMessage.setText("정지버튼 클릭!!");
			btnMessage.setLabel("정지버튼 클릭!!");
		}
		else {
			//System.out.println("종료버튼을 누르셨군요.");
			System.exit(0);
		}		
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
// 현재는 콘솔에 띄움 window 메시지창에 띄워야함