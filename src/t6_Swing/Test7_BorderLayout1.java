package t6_Swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Test7_BorderLayout1 extends JFrame {
	JPanel pn1;
	JButton btn1, btn2, btn3, btn4, btn5;
	
	public Test7_BorderLayout1() {
		super("BoardLayout 연습");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setResizable(false);;
		
		pn1 = new JPanel();
		pn1.setLayout(null);  // panel 배치를 내 임의대로 지정하겠다.
		
		btn1 = new JButton("북쪽");
		btn2 = new JButton("남쪽");
		btn3 = new JButton("서쪽");
		btn4 = new JButton("동쪽");
		btn5 = new JButton("중앙(종료)");
		
		setLayout(new BorderLayout());  // 나머지는 boardlayout에 올림
		
		btn5.setBounds(10, 80, 150, 30);
		pn1.add(btn5);  // 위에 null로 해서 사용자 지정 패널 setbounds로 크기 지정
		
		add(btn1, BorderLayout.NORTH);
		add(btn2, BorderLayout.SOUTH);
		add(btn3, BorderLayout.WEST);
		add(btn4, BorderLayout.EAST);
		//add(btn5, BorderLayout.CENTER);
		add(pn1, BorderLayout.CENTER);
		
		setVisible(true);  // 기준 위 디자인

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test7_BorderLayout1();
	}
}
