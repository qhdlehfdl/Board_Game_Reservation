package login_Activity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main_Activity_Join extends JFrame{
	
	String choice = null;
	public Main_Activity_Join()
	{
		setTitle("ȸ������ ȭ��");
		
		// 1. ������Ʈ���� ����� ����.
		JLabel title = new JLabel("ȸ������", JLabel.CENTER);
		
		title.setForeground(new Color(5, 0, 153));
		title.setFont(new Font("�޸�����ü", Font.BOLD, 30));
		
		JButton join = new JButton("ȸ������");
		JButton cancel = new JButton("���");
		
		JTextField id = new JTextField(10);
		JPasswordField pwd = new JPasswordField(10);
		JTextField name = new JTextField(10);
		JTextField phone = new JTextField(10);
		
		JRadioButton client = new JRadioButton("��");
		JRadioButton manager = new JRadioButton("������");
		JRadioButton etc = new JRadioButton("��Ÿ");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(client); bg.add(manager); bg.add(etc);
		
		// radio panel
		JPanel radioPanel = new JPanel();
		radioPanel.add(client);
		radioPanel.add(manager);
		radioPanel.add(etc);
		
		// form panel
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("���̵� : "));
		idPanel.add(id);
		
		
		JPanel pwdPanel = new JPanel();
		pwdPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwdPanel.add(new JLabel("��й�ȣ : "));
		pwdPanel.add(pwd);
		
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("��    �� : "));
		namePanel.add(name);
		
		
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		phonePanel.add(new JLabel("�� �� ó : "));
		phonePanel.add(phone);
		
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 1));
		formPanel.add(idPanel);
		formPanel.add(pwdPanel);
		formPanel.add(namePanel);
		formPanel.add(phonePanel);
		
		// radio + form panel
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(radioPanel);
		contentPanel.add(formPanel);
		
		// button panel
		JPanel panel = new JPanel();
		panel.add(join);
		panel.add(cancel);
		
		
		add(title, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		
		setBounds(200, 200, 250, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
		// �̺�Ʈ ó��
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String myId = id.getText();
				String myPwd = new String(pwd.getPassword());
				String myName = name.getText();
				String myPhone = phone.getText();
				
				if(client.isSelected()) {
					choice = client.getText();
				}else if(manager.isSelected()) {
					choice = manager.getText();
				}else if(etc.isSelected()) {
					choice = etc.getText();
				}
				
				JOptionPane.showMessageDialog
					(null, "���̵� : "+myId+", ��й�ȣ : "+myPwd+
					", �� �� : "+myName+", ����ó : "+myPhone+
					", �������� : "+choice);
			}
		});
		
		
		// ��� ��ư�� Ŭ������ �� �̺�Ʈ ó��
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Main_Activity_login();
				dispose();
				
			}
		});
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
