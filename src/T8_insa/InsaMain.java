package T8_insa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class InsaMain extends JFrame{
	JButton btnInput, btnSearch, btnList, btnExit;
	
	public InsaMain() {
		super("인사관리 메뉴");
		setSize(800, 600);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 93);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인사관리프로그램(v1.0)");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 736, 73);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 113, 760, 353);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMainImage = new JLabel("");
		lblMainImage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMainImage.setIcon(new ImageIcon(InsaMain.class.getResource("/T8_insa/images/14.jpg")));  // \\는 /와 같음
		lblMainImage.setBounds(0, 0, 760, 353);
		pn2.add(lblMainImage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 476, 760, 75);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원등록");
		btnInput.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnInput.setBounds(27, 10, 156, 55);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnSearch.setBounds(210, 10, 156, 55);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnList.setBounds(393, 10, 156, 55);
		pn3.add(btnList);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("함초롬돋움", Font.PLAIN, 20));
		btnExit.setBounds(576, 10, 156, 55);
		pn3.add(btnExit);
		setVisible(true);
		
		// ---------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null);  // 윈도우 창을 가운데 정렬
		setResizable(false);  // 크기 조절 못 하도록 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 윈도우 종료버튼 활성화
		setVisible(true);
		// ---------------------------아래쪽은 메소드--------------------------------
		
		// 사원등록 버튼을 키보드 엔터키로 등록시 수행
		btnInput.addKeyListener(new KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				dispose();  // jvm 안닫히고 현재 창만 닫힘
				new InsaInput();
			};
		});

		
		// 사원등록 버튼을 마우스로 클릭시 수행
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);  // jvm이 닫힘
				dispose();  // jvm 안닫히고 현재 창만 닫힘
				new InsaInput();
			}
		});
		
		// 개별조회 버튼을 키보드 엔터버튼 클릭시 수행
		btnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요.");
				InsaDAO dao = new InsaDAO();  // 이게 있어야 db 검색가능
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.");
				else {
					dispose();
					new InsaSearch(vo);  // 매개변수가 없는 기본생성자인데 vo는 생성자가 있어서
				}
				dao.connClose();
			}
		});
		
		// 개별조회 버튼을 마우스 클릭시 수행
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요.");
				InsaDAO dao = new InsaDAO();  // 이게 있어야 db 검색가능
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.");
				else {
					dispose();
					new InsaSearch(vo);  // 매개변수가 없는 기본생성자인데 vo는 생성자가 있어서
				}
				dao.connClose();
			}
		});
		
		// 전체조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsaList();
			}
		});
		
		// 종료 버튼 키보드 엔터키 처리시 수행
		btnExit.addKeyListener(new KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				System.exit(0);
			};
		});
		
		// 종료 버튼 마우스 클릭시 수행
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new InsaMain();
	}
}
