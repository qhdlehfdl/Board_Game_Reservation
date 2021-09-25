package login_Activity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Main_Activity_login extends JFrame{
	

    
    public Main_Activity_login()
    {
    	setTitle("��ǰ���� �ý���");
		
		JPanel title = new JPanel();
		
		// title �����̳ʿ� �� ������Ʈ�� ����� ����.
		JLabel login = new JLabel("�α��� ȭ��");
		
		// Color color = new Color(5, 0, 153)
		
		login.setForeground(new Color(5, 0, 153));
		
		// Font font = new Font("�޸�����ü", Font.BOLD, 25);
		
		login.setFont(new Font("�޸�����ü", Font.BOLD, 25));
		
		// ������Ʈ�� title �����̳ʿ� �÷� ����.
		title.add(login);
		
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3, 2));
		
		JPanel idPanel = 
			new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb1 = new JLabel("���̵� : ", JLabel.CENTER);
		
		idPanel.add(jlb1);
		
		JPanel idPanel2 = 
				new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf1 = new JTextField(10);
			
		idPanel2.add(jtf1);
		
		jp1.add(idPanel); jp1.add(idPanel2);
		
		
		JPanel pwdPanel = 
			new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb2 = new JLabel("��й�ȣ : ", JLabel.CENTER);
		
		JPanel pwdPanel2 = 
				new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPasswordField jtf2 = new JPasswordField(10);
		
		pwdPanel.add(jlb2); pwdPanel2.add(jtf2);
		
		jp1.add(pwdPanel); jp1.add(pwdPanel2);
		
		
		JPanel loginPanel = 
				new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jLogin = new JButton("�α���");
		
		JPanel joinPanel = 
				new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton join = new JButton("ȸ������");
		
		loginPanel.add(jLogin); joinPanel.add(join);
		
		jp1.add(loginPanel); jp1.add(joinPanel);
		
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(jp1);
		
		setLayout(new BorderLayout());
		
		add(title, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		
		setBounds(200, 200, 300, 250);
		
		setResizable(false);  // ȭ�� ũ�� �����ϴ� �۾�
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		// �̺�Ʈ ó��
		jLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String myId = jtf1.getText();
				String myPwd = new String(jtf2.getPassword());
				
				JOptionPane.showMessageDialog
					(null, "���̵� : "+myId+", ��й�ȣ : "+myPwd);
			}
		});
		
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Main_Activity_Join();
				dispose();  // ������ frame�� �����Ű�� �޼���.
				
			}
		});
    }
    
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		 new Main_Activity_login();
//	}

}
