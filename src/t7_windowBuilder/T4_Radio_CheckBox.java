package t7_windowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class T4_Radio_CheckBox extends JFrame {
	private JPanel pn1;
	private JRadioButton rdMale, rdFemale;
	private JCheckBox ckHobby1, ckHobby2, ckHobby3, ckHobby4;
	private JButton btnGender, btnHobby, btnExit;
	private JLabel lblHobby, lblMessage; 
	private final ButtonGroup btnGroupGender = new ButtonGroup();

	public T4_Radio_CheckBox() {
		super("라디오/체크박스 연습");
		setSize(600, 400);

		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBackground(new Color(240, 248, 255));
		pn1.setBounds(0, 0, 584, 59);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("라디오버튼/체크박스 연습");
		lblNewLabel.setBackground(new Color(250, 240, 230));
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 584, 59);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(new Color(255, 250, 250));
		pn2.setBounds(0, 59, 584, 243);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblGender = new JLabel("성 별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblGender.setBounds(12, 47, 112, 37);
		pn2.add(lblGender);
		
		rdMale = new JRadioButton("남자");
		btnGroupGender.add(rdMale);
		rdMale.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		rdMale.setBounds(158, 51, 95, 28);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		btnGroupGender.add(rdFemale);
		rdFemale.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		rdFemale.setBounds(264, 51, 95, 28);
		pn2.add(rdFemale);
		
		lblHobby = new JLabel("취 미");
		lblHobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblHobby.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblHobby.setBounds(12, 103, 112, 37);
		pn2.add(lblHobby);
		
		lblMessage = new JLabel("메시지 출력");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		lblMessage.setBounds(44, 163, 487, 51);
		pn2.add(lblMessage);
		
		ckHobby1 = new JCheckBox("등산");
		ckHobby1.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		ckHobby1.setBounds(158, 110, 83, 23);
		pn2.add(ckHobby1);
		
		ckHobby2 = new JCheckBox("낚시");
		ckHobby2.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		ckHobby2.setBounds(264, 110, 83, 23);
		pn2.add(ckHobby2);
		
		ckHobby3 = new JCheckBox("수영");
		ckHobby3.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		ckHobby3.setBounds(370, 110, 83, 23);
		pn2.add(ckHobby3);
		
		ckHobby4 = new JCheckBox("바둑");
		ckHobby4.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		ckHobby4.setBounds(476, 110, 83, 23);
		pn2.add(ckHobby4);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 302, 584, 59);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnGender = new JButton("성별 출력");
		btnGender.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		btnGender.setBounds(29, 10, 155, 40);
		pn3.add(btnGender);
		
		btnExit = new JButton("종 료");
		btnExit.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		btnExit.setBounds(397, 10, 155, 40);
		pn3.add(btnExit);
		
		btnHobby = new JButton("취미 출력");
		btnHobby.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		btnHobby.setBounds(213, 10, 155, 40);
		pn3.add(btnHobby);
		
		// ---------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null);  // 윈도우 창을 가운데 정렬
		setResizable(false);  // 크기 조절 못 하도록 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 윈도우 종료버튼 활성화
		setVisible(true);
		// ---------------------------아래쪽은 메소드----------------------------------
		
		// 성별출력버튼
		btnGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "선택하신 성별은 : ";
				//if(rdMale.isSelected()) gender = "남자";  // is 하면 묻는 것  // male이 선택됐는가
				if(rdMale.isSelected()) gender += rdMale.getText();
				else gender += rdFemale.getText();
				
				lblMessage.setText(gender);
			}
		});
		
		// 취미출력버튼
		btnHobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hobby = "";
				if(ckHobby1.isSelected()) hobby += ckHobby1.getText() + "/"; 
				if(ckHobby2.isSelected()) hobby += ckHobby2.getText() + "/"; 
				if(ckHobby3.isSelected()) hobby += ckHobby3.getText() + "/"; 
				if(ckHobby4.isSelected()) hobby += ckHobby4.getText() + "/";
				
				hobby = hobby.substring(0,hobby.length()-1);
				
				lblMessage.setText("선택하신 취미는 ? " + hobby);
				JOptionPane.showMessageDialog(null, "선택된 취미는 " + hobby);
			}
		});

		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new T4_Radio_CheckBox();
	}
}