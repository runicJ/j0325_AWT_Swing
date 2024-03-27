package t7_windowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class T8_File extends JFrame {
	private JFileChooser chooser;
	private JButton btnUpload, btnDelete, btnExit;
	private JLabel lblImage;
	private JScrollPane scrollPane;
	private JTable table;
	private Vector title, vData;
	private DefaultTableModel dtm;
	
	public T8_File() {
		super("파일처리 연습");
		setSize(600, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocale(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 56);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		btnUpload = new JButton("그림업로드");
		btnUpload.setFont(new Font("굴림", Font.PLAIN, 16));
		btnUpload.setBounds(12, 10, 126, 37);
		pn1.add(btnUpload);
		
		btnDelete = new JButton("그림삭제");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 16));
		btnDelete.setBounds(147, 10, 126, 37);
		pn1.add(btnDelete);
		
		btnExit = new JButton("종  료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 16));
		btnExit.setBounds(446, 10, 126, 37);
		pn1.add(btnExit);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 54, 584, 337);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblImage = new JLabel("사진이 출력됩니다.");
		lblImage.setFont(new Font("굴림", Font.PLAIN, 14));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(278, 10, 294, 317);
		pn2.add(lblImage);
		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 10, 253, 317);
//		pn2.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 390, 584, 51);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		// JTable 설계
		title = new Vector<>();
		title.add("경로/파일명");
		
		// 폴더 안의 정보를 가져오기(함수로 만들기)
		getFolderInfo();
		
		dtm = new DefaultTableModel(vData, title);  // dtm 생성
		table = new JTable(dtm);  // dtm을 테이블에 얹음
		scrollPane = new JScrollPane(table);  // scrollPand에 테이블을 얹음
		scrollPane.setBounds(12, 10, 253, 317);
		pn2.add(scrollPane);
		
// ========================================================================		
		setVisible(true);
// ========================================================================
		
		// 그림 업로드 처리
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 파일 다이얼로그 생성
				chooser = new JFileChooser();
				
				// 파일 확장자 선별 출력처리..
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				
				// 파일 다이얼로그박스 출력처리
				int res = chooser.showOpenDialog(null);
				
				if(res != chooser.APPROVE_OPTION) {  // 사용자가 파일을 선택하지 않고 창을 닫거나 취소한 경우...
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				}
				else {
					// 사용자가 파일을 선택하고 '열기' 버튼을 누른 경우(또는 선택한 파일명을 더블클릭한 경우)
					String filePath = chooser.getSelectedFile().getPath();  // 파일 경로명을 알아온다.  // 문자로 넘어옴
					lblImage.setIcon(new ImageIcon(filePath));  // 이미지 경로에 의해서 아이콘 생성
					
					// 파일 업로드하기(쉬운방법 ctrl+c ctrl+v 개념, 웹에선 불안정해서 이렇게 쓰지 못함)
					try {  // 입출력(io)는 무조건 예외처리
						File imageFile = new File(filePath);  // 업로드 되는 파일의 위치정보+파일명 // 파일 껍데기를 만듦
						String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);  // 파일명+확장자
						String extension = filePath.substring(filePath.lastIndexOf(".")+1);  // 확장자  // 읽어와서 정보를 읽음
						
						BufferedImage image = ImageIO.read(imageFile);  // ImageIO 많이 사용
						File file = new File("myImages/" + fileName);  // 경로앞 폴더명 // 서버에 저장되는 폴더+파일명 // 파일에 저장  // "./myImages" 해도됨 생략도 가능 현재 위치
						if(!file.exists()) file.mkdir();  // 폴더가 존재하지 않으면 폴더를 만들어준다. // 존재하는가 exists()
							
						ImageIO.write(image, extension, file);  // images를 file로 업로드시켜준다.  // file server폴더 server 파일명으로 업로드 시켜준다.
						System.out.println("파일명 : " + fileName);  // 올리는 파일명 찍어보기
						JOptionPane.showMessageDialog(null, "이미지 업로드 완료!!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		// 종료
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	// 폴더 안의 파일 목록(정보)을 가져오는 메소드
	private void getFolderInfo() {  // 폴더에 파일 리스트를 담아옴 배열로
		File folder = new File("myImages");
		File files[] = folder.listFiles();  // 여러개니까 배열로 담아서  // 지정한 파일 목록을 전부 담아서 배열에 담아줌
//		for( File f : files) {
//			System.out.println(f.getName());
//		}
		vData = new Vector<>();  // VOS
		if(files.length != 0) {
			for(int i=0; i<files.length; i++) {
				System.out.println("파일("+(i+1)+") : " + files[i]);
				Vector vo = new Vector<>();
				vo.add(files[i]);  // vo
				vData.add(vo);  // VOS에 넣는 것과 같음
			}
		}
	}
	
	public static void main(String[] args) {
		new T8_File();
	}
}
