package t7_windowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Test2 extends JFrame {
	private JTextField textField;

	public Test2() {
		super("회원가입");
		setSize(600, 480);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 560, 53);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 536, 33);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 73, 560, 260);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(31, 23, 104, 50);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(158, 23, 292, 56);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 343, 560, 88);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 10, 132, 48);
		panel_2.add(btnNewButton);
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new Test2();	
	}
}
