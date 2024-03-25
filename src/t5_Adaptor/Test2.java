package t5_Adaptor;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Test2 extends Frame {  // implements 안하고 필요한것만 뽑아씀(adaptor는 추상메소드가 2개 이상인 인터페이스인 경우(action은 메소드 1개뿐 adaptor가 없음)  // implements 하면 전부 오버라이드 해야함 
	Button btnPlayStop, btnExit;
	
	public Test2() {
		super("어뎁터를 연습...");  // Frame 상속 받아야 사용 가능.
		setLayout(new FlowLayout());  // 이거 사용하면 중복이 안됨. 덮어 씌워지지 않음
		setBounds(300, 350, 300, 280);
		
		btnPlayStop = new Button("Play");
		btnExit = new Button("Exit");
		add(btnPlayStop);
		add(btnExit);
		
		setVisible(true);
		
		btnPlayStop.addActionListener(new ActionListener() {  // 토글 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				Button btnLable = (Button) e.getSource();  // 이벤트는 e로 받음  // 이 버튼에 정보를 가져옴(getSource)  // object를 강제 다운캐스팅
				if(btnLable.getLabel().equals("Play")) { // 버튼에 쓰여있는 글자 불러옴 getLabel()  // 레이블의 글자 불러옴 getText()
					btnLable.setLabel("Stop");
					System.out.println("출발~~~");
				}
				else if(btnLable.getLabel().equals("Stop")) {
					btnLable.setLabel("Play");
					System.out.println("정지~~~");
				}
			}
		});
		
		// 어뎁터를 이용한 윈도우 종료(어뎁터를 사용하려면 익명 이너 클래스 써야함) (implements 사용x)
		addWindowListener(new WindowAdapter() {  // this 대신 new class 만듬 // 클래스에 실행블록 넣어야함 // 클래스인데 이름이 없어서 익명 안에 있어서 익명 이너 클래스 // 모바일앱에서 많이 사용
			@Override
			public void windowClosing(WindowEvent e) {  // 여러개인 경우 사용자가 사용할 것을 쓰라는 말
				System.exit(0);
			}
		});
		
		// 버튼 클릭시 익명클래스를 이용한 종료...
		btnExit.addActionListener(new ActionListener() {  // Action엔 메소드가 1개뿐
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test2();
	}
}
// 숙지해야함