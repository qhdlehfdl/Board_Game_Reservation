package gui;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import boss_Activity.Main_Activity;

public class AfterLoginFrame extends JFrame{
	
	private JPanel contentPane;
	private JButton listBtn, reserveBtn; //ȸ������ ����Ʈ ��ư, �����ư
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLoginFrame frame = new AfterLoginFrame(); 
								
				} catch (Exception e) {
					e.printStackTrace();						
				}
			}
		});
	}
	public AfterLoginFrame()
	{
		this(null);
	}
	
	public AfterLoginFrame(String username)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listBtn = new JButton("ȸ������");  ///ȸ������ ��ư
		listBtn.setBounds(135, 154, 106, 29);
		contentPane.add(listBtn);
		
		
		reserveBtn = new JButton("�����ϱ�"); //�����ư
		reserveBtn.setBounds(135, 74, 106, 29);
		contentPane.add(reserveBtn);
		
		setVisible(true);
		
		reserveBtn.addActionListener(new ActionListener() { //�����ϱ� ��������
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Main_Activity.main(null);
			}
		});
		
		listBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				MemberListFrame mlf= new MemberListFrame(username);
			}
				});
	}
}
