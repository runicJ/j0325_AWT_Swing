package t5_Adaptor;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Test1 extends Frame {  // implements 안하고 필요한것만 뽑아씀(adaptor는 추상메소드가 2개 이상인 인터페이스인 경우(action은 메소드 1개뿐 adaptor가 없음)  // implements 하면 전부 오버라이드 해야함 
	Button btnExit;
	
	public Test1() {
		super("어뎁터를 활용한 종료");  // Frame 상속 받아야 사용 가능.
		setBounds(300, 350, 300, 280);
		
		btnExit = new Button("Exit");
		add(btnExit);  // this.add()
		
		setVisible(true);
		
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
		new Test1();
	}
}
// 숙지해야함