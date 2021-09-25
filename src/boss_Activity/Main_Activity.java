/*
 �߰����� : �� �߰� ��� ����
 */

package boss_Activity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_Activity {
	private JFrame frame;
	
	Rooms num1, num2, num3, num4;
	String user = "";
	int start_time;
	int end_time;
	
	/*���� �ҽ� ���� ���� (13 ~ 25)*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Activity window = new Main_Activity(); //
					window.frame.setVisible(true);				//
				} catch (Exception e) {
					e.printStackTrace();						//
				}
			}
		});
	}
	
	public Main_Activity() {
		initialize();
	}
	
	public void initialize() {
		num1 = new Rooms();										// num1 ����
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 750); 					// ���� ��ġ, ���� ��ġ, ���� ����, ���� ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/* �� �κ� �г� */
		JPanel top_panel = new JPanel();
		top_panel.setBackground(new Color(3, 252, 148));		// �� ����
		top_panel.setBounds(0, 0, 784, 100);
		frame.getContentPane().add(top_panel);
		top_panel.setLayout(null);
		
		/* �߰� �κ� �г� */
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 100, 784, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/* �Ʒ� �κ� �г� */
		/* �̸� �Է� */
		JPanel inputname = new JPanel();
		inputname.setBackground(new Color(51, 255, 255));
		inputname.setBounds(0, 0, 784, 10);
		inputname.add(new JLabel("�̸� : "));
		inputname.add(new JTextField(15));
		
		/* �̸� �Է� */
		JPanel phonenum = new JPanel();
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("�ڵ��� ��ȣ : "));
		phonenum.add(new JTextField(15));
		
		/* ���� �ð� �Է� */
		JPanel inputtime = new JPanel();
		inputtime.setBackground(new Color(51, 255, 255));
		inputtime.setBounds(0, 0, 784, 10);
		inputtime.add(new JLabel("�ð� : "));
		SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		Date time = new Date();
		String time1 = timeformat.format(time);
		inputtime.add(new JLabel(time1));
		
		/* ���� / ���� ���� */
		JPanel status = new JPanel();
		status.setBackground(new Color(51, 255, 255));
		status.setBounds(0, 0, 784, 10);
		status.setLayout(new FlowLayout()); 					// new �� ���� ��!
		JButton resbtn = new JButton("����");
		JButton startbtn = new JButton("����");
		status.add(resbtn);
		status.add(startbtn);
		
		JPanel bottom_panel = new JPanel();
		bottom_panel.setBackground(new Color(51, 255, 255));
		bottom_panel.setBounds(0, 500, 784, 200);
		frame.getContentPane().add(bottom_panel);
		bottom_panel.setLayout(new BoxLayout(bottom_panel, BoxLayout.Y_AXIS));	// BoxLayout���� ����
		bottom_panel.add(inputname);
		bottom_panel.add(phonenum);
		bottom_panel.add(inputtime);
		bottom_panel.add(status);
		bottom_panel.setVisible(false);							// ��ư Ŭ�� ������ �� �� ����
		
		JLabel intro = new JLabel("���� ���� ���� ��Ȳ");
		
		/* �� 1 ��ư Ŭ�� �� */
		JButton room1 = new JButton("�� 1");
		room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bottom_panel.setVisible(true);
			}
		});
		
		/* ���� ��ư Ŭ�� �� */
		resbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		/* ���� ��ư Ŭ�� �� */
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		intro.setFont(new Font("Dialog", Font.PLAIN, 20));
		intro.setBounds(300, 0, 200, 100);						// ��Ʈ�� �ٿ�� ����
		room1.setBounds(100, 74, 200, 100);						// ��ư �ٿ�� ����
		top_panel.add(intro);
		panel.add(room1);										// room1 �߰�
		
	}
	
	
	
}

/* ���� ������ 
void start(Rooms room)
	{
		JOptionPane Jstart=new JOptionPane();
		String username=Jstart.showInputDialog("�̸��� �Է��ϼ���");
		room.setName(username);
		// System.out.println(room.getName());					// Ȯ�ο�. "//" ���� �� �ֿܼ� �̸� ���.
		
		

	}
*/
