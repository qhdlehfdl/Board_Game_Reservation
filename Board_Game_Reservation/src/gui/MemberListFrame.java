package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.MemberDao;
import models.Member;
import util.Sample;

public class MemberListFrame extends JFrame {

	private String username; //세션
	private JPanel contentPane;
	private JTable table;
	private JLabel lbTitle;
	private JButton logoutBtn;
	private DefaultTableModel tableModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberListFrame frame = new MemberListFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberListFrame() {
		this(null);
	}
	public MemberListFrame(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1032, 584);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lbTitle = new JLabel("회원정보");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("나눔고딕", Font.BOLD, 20));
		lbTitle.setPreferredSize(new Dimension( 738, 50 ));
		contentPane.add(lbTitle, BorderLayout.NORTH);
		
		//샘플 데이터 가져오기 (나중에 DB에서 가져와야 함)
		//Vector<String> memberName = Sample.getMemberName();
		//Vector<Member> members = Sample.getMembers();

		//DB 데이터 가져오기
		Vector<String> memberName = Sample.getMemberName();
		MemberDao dao = MemberDao.getInstance();
		Vector<Member> members = dao.findByAll();
		
		//tableModel에 열 이름과 행 개수 설정
		tableModel = new DefaultTableModel(memberName,0);
		
		//tableModel에 전체 행 넣기
		for (int i = 0; i < members.size(); i++) {
			Vector<Object> row = new Vector<>();
			row.addElement(members.get(i).getId());
			row.addElement(members.get(i).getUsername());
			row.addElement(members.get(i).getPassword());
			row.addElement(members.get(i).getName());
			row.addElement(members.get(i).getEmail());
			row.addElement(members.get(i).getPhone());
			row.addElement(members.get(i).getCreateDate());	
			tableModel.addRow(row);
		}
		
		//tableModel을 JTable에 넣기
		table = new JTable(tableModel);
		table.setFont(new Font("돋움", Font.PLAIN, 20));
		table.setRowHeight(25);
		
		//JTable에 scroll달아서 add하기
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		logoutBtn = new JButton("로그아웃");
		contentPane.add(logoutBtn, BorderLayout.SOUTH);
		
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				dispose();
				new LoginFrame();
			}
		});
		
		if(username == null) {
			JOptionPane.showMessageDialog(null, "인증되지 않은 사용자 입니다.");
			dispose();
		}else {
			setVisible(true);	
		}
	}

}




