package t7_windowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import T8_insa.InsaDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class T6_JTable extends JFrame {
	private JTable table;
	private JButton btnPrint, btnExit;
	private Vector title, vData;  // 제너릭이 swing에서 사용이 안됨 예전버전이라(String, int, double은 가능, vo객체 제너릭x)
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	
	InsaDAO dao = new InsaDAO();  // 다른 패키지 import
	
	public T6_JTable() {
		super("JTable연습");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 484, 54);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnPrint = new JButton("선택셀값출력");
		btnPrint.setFont(new Font("굴림", Font.PLAIN, 16));
		btnPrint.setBounds(12, 10, 137, 35);
		pn1.add(btnPrint);
		
		btnExit = new JButton("종  료");
		
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(335, 10, 137, 35);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 53, 484, 164);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 216, 484, 45);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		JLabel lblMessage = new JLabel("JTable에서 선택된 값을 출력합니다.");
		lblMessage.setFont(new Font("굴림", Font.PLAIN, 16));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(0, 0, 484, 45);
		pn3.add(lblMessage);
		
		/* 아래로 JTable 설계하기 */
		// JTable 설계시는 '부제목' 과 '데이터'를 설계하여 Vector 타입으로 준비한다.(subtitle(name, age(나이))와 vData와 맞아야함) // arraylist 사용x
		
		// 1. '부제목'을 Vector에 저장
		title = new Vector<>();  // 타입만 안넣으면 됨.
		title.add("번호");  // 타입이 없어서 노란줄
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		// 2. '데이터'를 Vector타입으로 준비... 데이터는 데이터베이스에서 가져온다.
		vData = dao.getInsaList("","");  // Vector<> 안써도됨 위에 선언함
		
    // 3. DB에서 가져온 자료(vData)와 타이틀(title)을 DefaultTableModel객체를 생성하면서 담아준다. // vector 데이터를 가공해서 jTable의 모델로 담아야함
		dtm = new DefaultTableModel(vData, title);
		
		// 4. DefaultTableModel에 담긴 백터타입의 '데이터/타이틀'을 JTable 객체 생성시에 담아준다.
		table = new JTable(dtm);  // 위에서 한번에 넣어도 상관없음
		
		// 5. 자료가 담긴 JTable을 JScrollPane 객체 생성시에 함꼐 담아서 생성해 준다.
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 460, 154);
		pn2.add(scrollPane);
		
		// 6. 출력결과를 확인한다.
		
//------------------- 위는 UI / 아래는 메소드 --------------------------
		
		// 종료버튼 마우스클릭
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
//------------------------------------------------
		setVisible(true);
//------------------------------------------------
	}
	
	public static void main(String[] args) {
		new T6_JTable();
	}
}
