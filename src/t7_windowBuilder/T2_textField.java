package t7_windowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class T2_textField extends JFrame {
	private JTextField txtMid, txtName, txtAge;
	private JButton btnSubmit,btnReset,btnExit;
	private JTextField txtPwd;
	
	private String regAge = "^[0-9]+$";

	public T2_textField() {
		super("회원가입");
		setSize(600, 480);
		getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(12, 10, 560, 53);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 가 입");
		lblNewLabel.setFont(new Font("문체부 돋음체", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 536, 33);
		panel1.add(lblNewLabel);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(12, 73, 560, 279);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblMid = new JLabel("아이디");
		lblMid.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);
		lblMid.setBounds(29, 20, 104, 44);
		panel2.add(lblMid);
		
		txtMid = new JTextField();
		txtMid.setBounds(158, 20, 292, 44);
		panel2.add(txtMid);
		txtMid.setColumns(10);
		
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setBounds(29, 84, 104, 44);
		panel2.add(lblPwd);
		
		JLabel lblName = new JLabel("성명");
		lblName.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(29, 148, 104, 44);
		panel2.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(158, 147, 292, 44);
		panel2.add(txtName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblAge.setBounds(29, 212, 104, 44);
		panel2.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(158, 211, 292, 44);
		panel2.add(txtAge);
		
		txtPwd = new JTextField();
		txtPwd.setBounds(158, 84, 292, 43);
		panel2.add(txtPwd);
		txtPwd.setColumns(10);

		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
//		lblImage.setIcon(new ImageIcon("D:\\javaclass\\java\\works\\j0325_AWT_Swing_WindowBuilder\\myImages\\00501001_20180928.jpg"));
//		lblImage.setIcon(new ImageIcon(Test2.class.getResource("/myImages/1.jpg")));
		lblImage.setIcon(new ImageIcon("./myImages/1.jpg"));
		lblImage.setBounds(0, 0, 560, 279);
		panel2.add(lblImage);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(12, 362, 560, 69);
		getContentPane().add(panel3);
		panel3.setLayout(null);
		
		btnSubmit = new JButton("회원가입");
		btnSubmit.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		btnSubmit.setBounds(41, 10, 132, 48);
		panel3.add(btnSubmit);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		btnReset.setBounds(214, 10, 132, 48);
		panel3.add(btnReset);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		btnExit.setBounds(387, 10, 132, 48);
		panel3.add(btnExit);
		
		// ---------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null);  // 윈도우 창을 가운데 정렬
		setResizable(false);  // 크기 조절 못 하도록 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 윈도우 종료버튼 활성화
		setVisible(true);
		// ---------------------------아래쪽은 메소드----------------------------------
		
		// 회원가입 버튼
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMid.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					txtMid.requestFocus();
				}
				else if(txtPwd.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
					txtMid.requestFocus();
				}
				else if(txtName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();
				}
//				else if(txtAge.getText().trim().equals("")) {
//					JOptionPane.showMessageDialog(null, "나이를 입력하세요");
//					txtAge.requestFocus();
//				}
				else if(!Pattern.matches(regAge, txtAge.getText().trim())) {
					JOptionPane.showMessageDialog(null, "나이는 숫자만 입력하세요");
					txtAge.requestFocus();
				}
				else {					
					JOptionPane.showMessageDialog(null, "회원가입 완료");
				}
			}
		});
		
		// 다시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMid.setText("");
				txtPwd.setText("");
				txtName.setText("");
				txtAge.setText("");
				txtMid.requestFocus();
			}
		});
		
		// 종료 버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new T2_textField();	
	}
}
