package t6_Swing;

import javax.swing.JFrame;

// 화면 중앙에 윈도우 정렬..../ 윈도우 크기 고정...
@SuppressWarnings("serial")
public class Test5_windowsAlign extends JFrame {

	public Test5_windowsAlign() {
		super("스윙연습5");
		
		//setBounds(300, 250, 300, 250);
		
		setSize(300, 250);  // (폭(width), 높이(height))
		setLocationRelativeTo(null);  // 윈도우 화면 중앙에 배치  // 많이 사용
		setResizable(false);  // 바뀌지 않게 크기 고정
		
		setVisible(true);
		
		// 윈도우 창 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 자동 닫기 // JFame에서 제공해주는 메소드 DefaultClose에 JFrame의 열거형 상수 => 매개값
	}
	
	public static void main(String[] args) {
		new Test5_windowsAlign();
	}
}
