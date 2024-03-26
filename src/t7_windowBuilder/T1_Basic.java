package t7_windowBuilder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class T1_Basic extends JFrame {
	private JTextField txtName, txtKor, txtEng, txtMat;
	private JButton btnInput, btnReset, btnExit;

	public T1_Basic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);  // 기본이 getContentPane // this가 아님
		
		JLabel lblTitle = new JLabel("그린중학교 성적표");
		lblTitle.setFont(new Font("경기천년제목V Bold", Font.BOLD, 28));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(80, 50, 580, 71);
		getContentPane().add(lblTitle);
		
		JLabel lblName = new JLabel("성 명");
		lblName.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(64, 150, 154, 45);
		getContentPane().add(lblName);
		
		JLabel lblKor = new JLabel("국어점수");
		lblKor.setHorizontalAlignment(SwingConstants.CENTER);
		lblKor.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblKor.setBounds(64, 222, 154, 45);
		getContentPane().add(lblKor);
		
		JLabel lblEng = new JLabel("영어점수");
		lblEng.setHorizontalAlignment(SwingConstants.CENTER);
		lblEng.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblEng.setBounds(64, 304, 154, 45);
		getContentPane().add(lblEng);
		
		JLabel lblKor_1_1 = new JLabel("수학점수");
		lblKor_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblKor_1_1.setFont(new Font("경기천년제목 Light", Font.PLAIN, 20));
		lblKor_1_1.setBounds(64, 383, 154, 45);
		getContentPane().add(lblKor_1_1);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.LEFT);
		txtName.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtName.setBounds(264, 150, 228, 45);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtKor = new JTextField();
		txtKor.setHorizontalAlignment(SwingConstants.LEFT);
		txtKor.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtKor.setColumns(10);
		txtKor.setBounds(264, 222, 228, 45);
		getContentPane().add(txtKor);
		
		txtEng = new JTextField();
		txtEng.setHorizontalAlignment(SwingConstants.LEFT);
		txtEng.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtEng.setColumns(10);
		txtEng.setBounds(264, 304, 228, 45);
		getContentPane().add(txtEng);
		
		txtMat = new JTextField();
		txtMat.setHorizontalAlignment(SwingConstants.LEFT);
		txtMat.setFont(new Font("경기천년바탕 Regular", Font.PLAIN, 20));
		txtMat.setColumns(10);
		txtMat.setBounds(264, 383, 228, 45);
		getContentPane().add(txtMat);
		
		btnInput = new JButton("입 력");
		btnInput.setFont(new Font("경기천년제목 Light", Font.PLAIN, 18));
		btnInput.setBounds(94, 464, 140, 35);
		getContentPane().add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("경기천년제목 Light", Font.PLAIN, 18));
		btnReset.setBounds(277, 464, 140, 35);
		getContentPane().add(btnReset);
		
		btnExit = new JButton("종 료");
		btnExit.setFont(new Font("경기천년제목 Light", Font.PLAIN, 18));
		btnExit.setBounds(460, 464, 140, 35);
		getContentPane().add(btnExit);
		
		// 위쪽은 디자인
		setVisible(true);  // 현재는 전부 익명 이너 클래스 사용중  // 생성자 안에서 작성중
		// 아래쪽은 메소드
		
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		// 다시입력
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
				txtName.requestFocus();
			}
		});
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ans = JOptionPane.showConfirmDialog(null, "작업을 졸료하시겠습니까?", "", JOptionPane.YES_NO_OPTION);
				if(ans == 0) System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new T1_Basic();
	}
}
