package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

import dao.MemberDao;
import boss_Activity.Main_Activity;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername; //, tfPassword; //���̵�, ��й�ȣ �Է�ĭ
	private JPasswordField tfPassword;
	private JButton loginBtn, joinBtn, findBtn; //�α���, ȸ������ ��ư

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						LoginFrame frame = new LoginFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("username");
		lblLogin.setBounds(51, 52, 69, 35);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 103, 69, 35);
		contentPane.add(lblPassword);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(187, 52, 176, 35);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		joinBtn = new JButton("ȸ������");
		joinBtn.setBounds(340, 154, 100, 29);
		contentPane.add(joinBtn);
		
		loginBtn = new JButton("�α���");
		loginBtn.setBounds(200, 154, 100, 29);
		contentPane.add(loginBtn);
		
		findBtn = new JButton("ID/PW ã��");
		findBtn.setBounds(60, 154, 100, 29);
		contentPane.add(findBtn);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(187, 103, 176, 35);
		contentPane.add(tfPassword);
		
		setVisible(true);
		
		//id pw ã�� ��������
		findBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				FindFrame frame=new FindFrame();
			}
		});
		//ȸ������ ��������
		joinBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinFrame frame = new JoinFrame();
			}
		});
		
		//�α��� ��������
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = tfPassword.getText();
				MemberDao dao = MemberDao.getInstance();
				int result = dao.findByUsernameAndPassword(username, password);
				if(result == 1) 
				{
					//�α��� ���� �޽���
					JOptionPane.showMessageDialog(null, "�α��� ����");
					//Main_Activity.main(null); //�� ���� ȭ������ �Ѿ
					//ȸ�� ���� ����Ʈ ȭ�� �̵��� ���ÿ� username ���ǰ����� �ѱ�.
					//MemberListFrame mlf = new MemberListFrame(username);
					AfterLoginFrame alf=new AfterLoginFrame(username);
					dispose(); //���� ȭ�� ����
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "�α��� ����");
				}
				
			}
		});
	}
}


