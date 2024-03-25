package t6_Swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

// 스윙의 종료를 어뎁터로 이용.
@SuppressWarnings("serial")
public class Test3_Adaptor extends JFrame {

	public Test3_Adaptor() {
		super("스윙연습3");
		
		setBounds(300, 250, 300, 250);
		
		setVisible(true);
		
		//addWindowListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test3_Adaptor();
	}
}
