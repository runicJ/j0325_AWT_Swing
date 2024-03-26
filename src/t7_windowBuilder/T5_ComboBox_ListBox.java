package t7_windowBuilder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class T5_ComboBox_ListBox extends JFrame {
	JButton btnCombo, btnExit, btnList1;
	JComboBox comboJob;
	JLabel lblMessage;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T5_ComboBox_ListBox() {
		super("콤보상자 연습");
		setSize(600, 500);
		
		JPanel pn4 = new JPanel();
		pn4.setBounds(0, 396, 584, 55);
		getContentPane().add(pn4);
		pn4.setLayout(null);
		
		lblMessage = new JLabel("출력메시지");
		lblMessage.setFont(new Font("굴림", Font.PLAIN, 16));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(12, 10, 560, 35);
		pn4.add(lblMessage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 337, 584, 60);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnCombo = new JButton("콤보출력");
		btnCombo.setFont(new Font("굴림", Font.PLAIN, 16));
		btnCombo.setBounds(9, 10, 102, 40);
		pn3.add(btnCombo);
		
	  btnExit = new JButton("종료버튼");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(452, 10, 121, 40);
		pn3.add(btnExit);
		
		JButton btnList1 = new JButton("리스트상자출력1");
		btnList1.setFont(new Font("굴림", Font.PLAIN, 16));
		btnList1.setBounds(120, 10, 157, 40);
		pn3.add(btnList1);
		
		JButton btnList2 = new JButton("리스트상자출력2");
		btnList2.setFont(new Font("굴림", Font.PLAIN, 16));
		btnList2.setBounds(286, 10, 157, 40);
		pn3.add(btnList2);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 292, 338);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("직업을 선택하세요");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(12, 10, 268, 48);
		pn1.add(lblNewLabel);
		
		comboJob = new JComboBox();
		comboJob.setModel(new DefaultComboBoxModel(new String[] {"학  생", "회사원", "군  인", "변호사", "의  사", "공무원", "기  타"}));
		comboJob.setFont(new Font("굴림", Font.PLAIN, 16));
		comboJob.setBounds(12, 68, 268, 40);
		pn1.add(comboJob);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 118, 268, 210);
		pn1.add(scrollPane_1);
		
		JTextArea txtaMemo = new JTextArea();
		scrollPane_1.setViewportView(txtaMemo);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(292, 0, 292, 338);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		JList listJob = new JList();
		listJob.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "의사", "변호사", "회계사", "판사", "군인", "공무원", "간호사", "역무원", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listJob.setBounds(307, 23, 265, 118);
		pn2.add(listJob);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(307, 164, 265, 147);
		pn2.add(scrollPane);
		
		JList listJob2 = new JList();
		listJob2.setModel(new AbstractListModel() {
			String[] values = new String[] {"학생", "의사", "변호사", "회계사", "판사", "군인", "공무원", "간호사", "역무원", "기타"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listJob2);
		
		// ---------------------------위쪽은 UI----------------------------------
		setLocationRelativeTo(null);  // 윈도우 창을 가운데 정렬
		setResizable(false);  // 크기 조절 못 하도록 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 윈도우 종료버튼 활성화
		setVisible(true);
		// ---------------------------아래쪽은 메소드--------------------------------
		
		// 콤보상자의 내용 출력하는 버튼
		btnCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = comboJob.getSelectedItem().toString() + "("+comboJob.getSelectedIndex()+")";  // 선택된 문구를 가져옴  // 형변환(object->String)
				lblMessage.setText(msg);  // 값을 꺼내야지 db에 넣을 수 있음.
			}
		});

		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 리스트상자출력1...버튼
		btnList1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				//Object[] jobs = listJob.getSelectedValues().toArray();  // 객체 배열에 넣음  // 배열로
				Object[] jobs = listJob.getSelectedValuesList().toArray();
				for(Object job : jobs) {
					msg += job + "/";
				}
				msg = msg.substring(0, msg.length()-1);
				
				lblMessage.setText(msg);
			}
		});
		
		// 리스트상자2출력버튼(리스트상자2의 내용을 선택하면 왼쪽 메모창에 내용을 출력시켜준다.)
//		btnList2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String msg = "";
//				Object[] jobs = listJob2.getSelectedValuesList().toArray();
//				for(Object job : jobs) msg += job + "\n";
//				//msg = msg.substring(0, msg.length()-1);
//				txtaMemo.setText(msg);
//			}
//		});
		
		btnList2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtaMemo.append(listJob2.getSelectedValue() + "\n");  // append 기존 내용에 계속 추가  // values 리스트 // \n이 붙으면 문자가 됨 toString 없어도됨 
			}
		});
	}
	
	public static void main(String[] args) {
		new T5_ComboBox_ListBox();
	}
}
