package t4_Panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class T2_GridPanel1 extends Frame implements WindowListener, ActionListener {
	Panel pn1, pn2, pn3, pn4; // 레이블이나 text 묶는 판을 깔아주는 것
	Label lbl1, lbl2, lbl3;
	Button btnExit;
	
	public T2_GridPanel1() {
		super("그리드 패널 연습");
		setLayout(new GridLayout(1,3));
		setBounds(400, 350, 400, 350);
		
		// 첫번째 패널
		pn1 = new Panel();  // 작업의 순서는 관계없음
		pn1.setBackground(Color.BLUE);  // 배경
		pn1.setForeground(Color.WHITE);  // 글자색
		lbl1 = new Label("첫번째 패널입니다.");
		pn1.add(lbl1);  // 레이블을 패널에 올리고
		this.add(pn1);  // 패널을 프레임 위에 올림
		
		// 두번째 패널
		pn2 = new Panel();
		pn2.setBackground(Color.YELLOW);
		lbl2 = new Label("두번째 패널입니다.");
		pn2.add(lbl2);  // add얹어라 패널에
		add(pn2);		
		
		// 세번째 패널
		pn3 = new Panel();
		pn3.setBackground(Color.RED);
		pn3.setLayout(new GridLayout(2,1));  // 그리드 안 왼쪽정렬이 기본
		lbl3 = new Label("세번째 패널입니다.");
		btnExit = new Button("종료");
		pn3.add(lbl3);
		pn3.add(btnExit);  // 기본이 flow 왼쪽->오른쪽 위->아래
		add(pn3);
		
		setVisible(true);
		
		addWindowListener(this);
		btnExit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new T2_GridPanel1();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { System.exit(0); }
	
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
