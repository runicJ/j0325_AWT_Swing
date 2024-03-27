package t7_windowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import T8_insa.InsaDAO;
import T8_insa.InsaVO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

@SuppressWarnings({"serial","rawtypes","unchecked"})
public class T7_JTable extends JFrame {
	private JTable table;
	private JButton btnPrint, btnExit;
	private Vector title, vData;  // 제너릭이 swing에서 사용이 안됨 예전버전이라(String, int, double은 가능, vo객체 제너릭x)
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	
	InsaDAO dao = new InsaDAO();  // 다른 패키지 import
	
	public T7_JTable() {
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
		
		// 테이블의 내용을 행(타이틀)이름으로 정렬(오름차순/내림차순)하고자 한다면??
		table.setRowSorter(new TableRowSorter<>(dtm));
		
		// 5. 자료가 담긴 JTable을 JScrollPane 객체 생성시에 함꼐 담아서 생성해 준다.
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 460, 154);
		pn2.add(scrollPane);
		
		// 6. 출력결과를 확인한다.
		
		/* JTable 속성 제어하기 */
		// table의 컴럼크기/크기고정/셀의 위치고정 설정
		table.getColumnModel().getColumn(0).setMaxWidth(50);  // 컬럼의 최대크기 지정 // 여기선 Model이라고 함.
		table.getColumnModel().getColumn(2).setMaxWidth(50);
		table.getColumnModel().getColumn(0).setResizable(false);  // 컬럼 크기 변경불가 // 전부다 하려면 for문 다른데서도 사용하려면 반복문 메소드 처리
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getTableHeader().setReorderingAllowed(false);  // 컬럼 고정 // 열 순서 바꾸기 허용x
		
		// 테이블 셀 안의 내용 수평정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();  // default테이블 안에있는 cell을 재구성 랜더링
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);  // 열거형 상수 있음
		TableColumnModel tcm = table.getColumnModel();  // 누구를 가운데 정렬할지
		//tcm.getColumn(3).setCellRenderer(dtcr);
		
		// 전체셀 가운데 정렬...
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
//------------------- 위는 UI / 아래는 메소드 --------------------------
		
		// 테이블에서 선택된 셀의 레코드(행)의 정보를 출력하기
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();  // 선택된행의 정보 가져옴
				int column = table.getSelectedColumn();
//				if(row < 0) {
//					System.out.println("행을 선택 후 버튼을 눌러주세요.");
//					JOptionPane.showMessageDialog(null, "행을 선택 후 버튼을 눌러주세요.");
//				}
//				else {
//					System.out.println("선택된 인덱스 행번호 : " + row + " , 열번호 : " + column);
//					JOptionPane.showMessageDialog(null, "선택된 인덱스 행번호 : " + row + " , 열번호 : " + column);
//				}
				if(row != -1) {
//					System.out.println(table.getValueAt(row, column));
//					lblMessage.setText("선택된 내용 : " + table.getValueAt(row, column));
					// 선택된 행의 모든 정보를 메세지창에 띄우시오.
					InsaVO vo = dao.getNameSearch(table.getValueAt(row, 1)+"");
					String temp = "성명:"+vo.getName()+" , 나이:"+vo.getAge()+" , 성별:"+vo.getGender()+" , 입사일:" + vo.getIpsail().substring(0,10);
					System.out.println(temp);
					JOptionPane.showMessageDialog(null, temp);
				}
			}
		});

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
		new T7_JTable();
	}
}
