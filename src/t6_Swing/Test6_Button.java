package t6_Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test6_Button extends JFrame {
	JButton btnExit;
	
	public Test6_Button() {
		super("컴포넌트 연습");
		setSize(300, 300);
		setLocationRelativeTo(null);  // 중앙 배치
		setResizable(false);  // 크기 고정
		
		btnExit = new JButton("종료");
		add(btnExit);  // swing은 한글 변환 안해도 됨  // 여기까지 디자인
		
		setVisible(true);  // 여기부터 명령어(기준을 두고 나누자 위 UI / 아래 메소드)

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 닫기
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test6_Button();
	}
}
