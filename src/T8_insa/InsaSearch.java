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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class InsaSearch extends JFrame {
	JComboBox cbYY, cbMM, cbDD;
	JButton btnUpdate, btnDelete, btnClose;
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;  // 이건 사용할때 new해줌
	int res = 0;  // 여기까지 기본값
	
	private JTextField txtName;
	private JTextField txtAge;
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public InsaSearch(InsaVO vo) {    // main에서 검색한 vo를 여기로 보내옴
		super("회원가입창");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 8, 760, 90);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblTitle = new JLabel("회원 개별조회(수정/삭제처리)");
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
		txtName.setEditable(false);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		txtName.setBounds(271, 36, 282, 44);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		JRadioButton rdGenderMale = new JRadioButton("남  자");
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
		
		JRadioButton rdGenderFemale = new JRadioButton("여  자");
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
		
		btnUpdate = new JButton("수정하기");
		btnUpdate.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnUpdate.setBounds(65, 10, 166, 64);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭제하기");
		btnDelete.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnDelete.setBounds(296, 10, 166, 64);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnClose.setBounds(527, 10, 166, 64);
		pn3.add(btnClose);
		
		// vo에 담겨서 넘어온 회원의 정보를 검색창에 뿌려주도록 한다.
		txtName.setText(vo.getName());
		txtAge.setText(vo.getAge() + "");
		
		if(vo.getGender().equals("남자")) rdGenderMale.setSelected(true);
		if(vo.getGender().equals("여자")) rdGenderFemale.setSelected(true);
		
		// DB의 날짜형식을 콤보상자의 날짜형식과 일치시켜서 비교하기 위한 작업
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");  // 2024-03-25 => 2024-3-25로 변경하기 위한 준비
		LocalDate date = LocalDate.parse(vo.getIpsail().substring(0, 10),dtf);  // 날짜형식인데 문자로 바꿔라  // dtf 형식으로 바뀜
		String strDate = date.format(dtf);  // 문자 타입으로 바꿈		
		String[] ymds = strDate.split("-");
		cbYY.setSelectedItem(ymds[0]);
		cbMM.setSelectedItem(ymds[1]);
		cbDD.setSelectedItem(ymds[2]);
		
		// ---------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null);  // 윈도우 창을 가운데 정렬
		setResizable(false);  // 크기 조절 못 하도록 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 윈도우 종료버튼 활성화
		setVisible(true);
		// ---------------------------아래쪽은 메소드--------------------------------
		
		// 회원정보 수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String age = txtAge.getText().trim();
				String gender = "";
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				// 유효성 검사(정규식)
				if(!Pattern.matches("^[0-9]+$", age)) {
					JOptionPane.showMessageDialog(null, "나이를 숫자로 입력하세요");
					txtAge.requestFocus();
				}
				else {
					if(rdGenderMale.isSelected()) gender = "남자";
					else gender = "여자";
					
					// 모든 체크가 끝나면 DB에 새로운 회원정보을 수정처리한다.
					vo.setName(txtName.getText());
			  	vo.setAge(Integer.parseInt(age));
			  	vo.setGender(gender);
			  	vo.setIpsail(ipsail);
			  	
			  	res = dao.setInsaUpdate(vo);  // vo를 넘김 res로 위에 변수 설정
			  	
			  	if(res != 0) {
			  		JOptionPane.showMessageDialog(null, "회원정보가 수정되셨습니다.");
			  	}
			  	else {
			  		JOptionPane.showMessageDialog(null, "회원정보 수정 실패~~");
					}
			  }
			}
		});
		
		// 삭제 버튼(마우스)
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();  // txt필드에 있는 이름을 뽑아서 name에 넣음
				
				int ans = JOptionPane.showConfirmDialog(null, name + "회원을 삭제하시겠습니까?", "회원삭제창", JOptionPane.YES_NO_OPTION);  // 관리자가 삭제
				//System.out.println("ans : " + ans);
				if(ans == 0) {
					res = dao.setInsaDelete(name);
					if(res != 0) {
						JOptionPane.showMessageDialog(null, name + "회원 삭제 완료!!!");
						dispose();
						new InsaMain();
					}
					else JOptionPane.showMessageDialog(null, name + "회원 삭제 실패~~~");  // 현재 화면에 머물러 있음.
				}
				else JOptionPane.showMessageDialog(null, name + "회원 삭제 취소!!!");
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
				
//	public static void main(String[] args) {  // 여기서 안열리고 main에서 회원가입 등록 폼으로 감(연습할떄는 살려놓고, 정리할떄는 주석처리)
//		new InsaSearch();
//	}
}
