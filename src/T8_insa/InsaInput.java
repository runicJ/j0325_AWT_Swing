package T8_insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class InsaInput extends JFrame {
	JComboBox cbYY, cbMM, cbDD;
	JButton btnInput, btnReset, btnClose;
	JRadioButton rdGenderMale, rdGenderFemale;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;  // 이건 사용할때 new해줌
	int res = 0;  // 여기까지 기본값
	
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public InsaInput() {
		super("회원가입창");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 8, 760, 90);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회 원 가 입 폼");
		lblTitle.setFont(new Font("함초롬바탕", Font.BOLD, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 736, 68);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 103, 760, 360);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성  명");
		lblName.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(67, 36, 140, 44);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나  이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		lblAge.setBounds(67, 116, 140, 44);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성  별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		lblGender.setBounds(67, 196, 140, 44);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입사일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		lblIpsail.setBounds(67, 276, 140, 44);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		txtName.setBounds(271, 36, 282, 44);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		rdGenderMale = new JRadioButton("남  자");
		btnGroupGender.add(rdGenderMale);
		rdGenderMale.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		rdGenderMale.setBounds(271, 196, 103, 44);
		pn2.add(rdGenderMale);
		
		txtAge = new JTextField();
		txtAge.setHorizontalAlignment(SwingConstants.CENTER);
		txtAge.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(271, 116, 282, 44);
		pn2.add(txtAge);
		
		rdGenderFemale = new JRadioButton("여  자");
		btnGroupGender.add(rdGenderFemale);
		rdGenderFemale.setSelected(true);
		rdGenderFemale.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		rdGenderFemale.setBounds(450, 196, 103, 44);
		pn2.add(rdGenderFemale);
		
		// 년도/월/일 초기값 생성하기
		String[] yy = new String[25];
		String[] mm = new String[12];
		String[] dd = new String[31];  // 윤년체크(월의 마지막 일자 주는걸로)
		
		int imsi = 0;
		for(int i=0; i<yy.length; i++) {
			imsi = 2024 - i;
			yy[i] = imsi + "";
		}

		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		cbYY.setBounds(271, 285, 69, 35);
		pn2.add(cbYY);

		cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		cbMM.setBounds(377, 285, 69, 35);
		pn2.add(cbMM);
		
		cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		cbDD.setBounds(484, 285, 69, 35);
		pn2.add(cbDD);
		
		JLabel lblYear = new JLabel("년");
		lblYear.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		lblYear.setBounds(344, 285, 35, 35);
		pn2.add(lblYear);
		
		JLabel lblMonth = new JLabel("월");
		lblMonth.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		lblMonth.setBounds(450, 286, 35, 35);
		pn2.add(lblMonth);
		
		JLabel lblDay = new JLabel("일");
		lblDay.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		lblDay.setBounds(558, 285, 35, 35);
		pn2.add(lblDay);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 469, 760, 84);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnInput.setBounds(65, 10, 166, 64);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시입력");
		btnReset.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnReset.setBounds(296, 10, 166, 64);
		pn3.add(btnReset);
		
		btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnClose.setBounds(527, 10, 166, 64);
		pn3.add(btnClose);
		
		// 오늘날짜 가져와서 가입화면에 뿌려주기...
		InsaService service = new InsaService();
		vo = service.getDefaultDate();  // YY,MM,DD 여러개 가져오기위해 객체에 담으려고함 vo에 설정
		cbYY.setSelectedItem(vo.getCbYY());
		cbMM.setSelectedItem(vo.getCbMM());
		cbDD.setSelectedItem(vo.getCbDD());
		
		// ---------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null);  // 윈도우 창을 가운데 정렬
		setResizable(false);  // 크기 조절 못 하도록 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 윈도우 종료버튼 활성화
		setVisible(true);
		// ---------------------------아래쪽은 메소드--------------------------------
		
		// 회원가입 버튼을 키보드 엔터키를 쳤을때 수행처리(추가)
		btnInput.addKeyListener(new KeyAdapter() {  // 익명 이너클래스
			@Override
			public void keyPressed(KeyEvent e) {
				setInsaInput();  // 메소드 만듦
			}
		});
		
		// 회원가입 버튼을 마우스로 클릭했을때 수행처리
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInsaInput();
			}
		});
		
		// 디시입력 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtName.requestFocus();
			}
		});
		
		// 종료 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				dispose();
				new InsaMain();
			}
		});
	}

	// 회원가입 처리를 위한 메소드
	protected void setInsaInput() {  // ctrl + L line번호 기억하고 이동  // alt
		String name = txtName.getText().trim();
		String age = txtAge.getText().trim();
		String gender = "";
		String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
		
		// 유효성 검사(정규식)
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "성명을 입력하세요");
			txtName.requestFocus();
		}
		else if(!Pattern.matches("^[0-9]+$", age)) {
			JOptionPane.showMessageDialog(null, "나이를 숫자로 입력하세요");
			txtAge.requestFocus();
		}
		else {
			if(rdGenderMale.isSelected()) gender = "남자";
			else gender = "여자";
			
			// 모든 체크가 끝나면 DB에 새로운 회원을 가입처리한다.
			// 회원명 중복처리
		  vo = dao.getNameSearch(name);  // res로 하면 개별검색에서 vo를 또 만들어야 됨. 애초에 vo로 만듬  // 여기서 사용하려면 전역변수로 빼줘야함
		  if(vo.getName() != null) {  // vo == null x
		  	JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다. 다시 성명을 입력해주세요.");
		  	txtName.requestFocus();
		  }
		  else {
		  	// 정상적으로 자료가 입력되었다면 vo에 값을 담아서 값을 DB에 저장한다. 
		  	vo.setName(name);
		  	vo.setAge(Integer.parseInt(age));
		  	vo.setGender(gender);
		  	vo.setIpsail(ipsail);
		  	
		  	res = dao.setInsaInput(vo);  // vo를 넘김 res로 위에 변수 설정
		  	
		  	if(res != 0) {
		  		JOptionPane.showMessageDialog(null, "회원에 가입되셨습니다.");
		  		dispose();  // 닫은 다음에
		  		new InsaMain();  // insamain 호출
		  	}
		  	else {
		  		JOptionPane.showMessageDialog(null, "회원가입 실패~~ 다시 가입해 주세요.");
		  		txtName.requestFocus();
		  	}
		  }
		}
	}
	
//	public static void main(String[] args) {  // 여기서 안열리고 main에서 회원가입 등록 폼으로 감(연습할떄는 살려놓고, 정리할떄는 주석처리)
//		new InsaInput();
//	}
}
