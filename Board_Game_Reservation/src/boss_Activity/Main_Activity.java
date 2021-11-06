/*
 VER1
 �߰����� : 
 �� �߰� ��� ����
 �� ��ư �߰�
 
 VER2
 �߰����� : 
 ����� ������ ��ư ��� �߰�
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
		/* �̸� ������� */
		JTextField name1 = new JTextField(15);
		
		/* ��ȭ��ȣ ������� */
		JTextField phone1 = new JTextField(15);
		
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
		inputname.add(name1);
		//num1.setName(name1.getText());
		
		/* �ڵ��� ��ȣ �Է� */
		JPanel phonenum = new JPanel();
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("�ڵ��� ��ȣ : "));
		phonenum.add(phone1);
		
		/* ���� �ð� �Է� -> �̰� �ٽ� �ؾ��� �� */
		JPanel inputtime = new JPanel();
		inputtime.setBackground(new Color(51, 255, 255));
		inputtime.setBounds(0, 0, 784, 10);
		JLabel timeInsert = new JLabel("�ð� : ");
		inputtime.add(timeInsert);
		SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		Date time = new Date();
		String time1 = timeformat.format(time);
		JLabel temptime = new JLabel(time1);		// �ӽ� �ð�
		inputtime.add(temptime);
		
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
		
		/* ���� ���� ȭ�� */
		JPanel manage_res = new JPanel();
		JButton res_cancel = new JButton("���� ���");
		JButton res_to_start = new JButton("��� ����");
		manage_res.add(res_cancel);								// ���� ��� ��ư �߰�
		manage_res.add(res_to_start);							// ��� ���� ��ư �߰�
		res_cancel.setBounds(50, 50, 784, 10);
		res_to_start.setBounds(50, 80, 784, 10);
		manage_res.setBackground(new Color(51, 255, 255));
		manage_res.setBounds(0, 500, 784, 200);
		frame.getContentPane().add(manage_res);
		//manage_res.setLayout(new BoxLayout(manage_res, BoxLayout.Y_AXIS));	// BoxLayout���� ����
		manage_res.setVisible(false);							// ��ư Ŭ�� ������ �� �� ����
		
		JLabel intro = new JLabel("���� ���� ���� ��Ȳ");
	
		JButton room1 = new JButton("�� 1");
		JButton room1res = new JButton("");
		room1res.setVisible(false);
		
		/* room1��ư Ŭ�� �� */
		room1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bottom_panel.setVisible(true);
				manage_res.setVisible(false);
			}
		});
		
		/* room1res��ư Ŭ�� �� */
		room1res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bottom_panel.setVisible(false);
				manage_res.setVisible(true);
			}
		});
		
		/* ���� ��ư Ŭ�� �� */
		resbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room1.setVisible(false);				// room1 ����ȭ
				room1res.setVisible(true);				// room1res ����ȭ
				num1.setName(name1.getText());
				num1.setPhone(phone1.getText());
				Date timeupdate = new Date();
				String time1 = timeformat.format(timeupdate);
				JLabel temptime = new JLabel(time1);
				inputtime.removeAll();
				JLabel timeInsert = new JLabel("�ð� : ");
				inputtime.add(timeInsert);
				inputtime.add(temptime);		// �ð� ������Ʈ -> ������ : ��� �ð��� �þ -> ���� �Ϸ�
				num1.setTime(time1);
				
				/*�ٹٲ��� �̿��ϱ� ���� HTML ���*/
				room1res.setText(String.format("<HTML>���� �ð� : %s <br>�̸� : %s<br>��ȭ��ȣ : %s</HTML>",num1.getTime(), num1.getName(), num1.getPhone()));
				bottom_panel.setVisible(false);			// bottom_panel ����ȭ, ���� ���� ����ȭ(�߰� ����)
				
			}
		});
		
		/* ���� ��� ��ư Ŭ�� �� */
		res_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				bottom_panel.setVisible(true);
				manage_res.setVisible(false);
				room1.setVisible(true);
				room1res.setVisible(false);
			}
		});
		
		/* ���� ��ư Ŭ�� �� */
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		intro.setFont(new Font("Dialog", Font.PLAIN, 20));
		intro.setBounds(300, 0, 200, 100);						// ��Ʈ�� �ٿ�� ����
		/* ��ư �ٿ�� ���� */
		room1.setBounds(100, 74, 200, 100);						
		room1res.setBounds(100, 74, 200, 100);
		top_panel.add(intro);
		/* room1 ~ 4, room1 ~ 4res �߰� (room2 ~ 4, room2 ~ 4res �߰� ����)	 */
		panel.add(room1);											
		panel.add(room1res);									
	}
	
	
	
}

/*
 �ʿ� ����
 manage_res ȭ�� �� ����
 (���� �߰��� �� �ִ� ����� ����� �� ���) -> Layout ����
 ���� ������ ������Ʈ�� �Ǿ�� �ϴµ� ��ư ������Ʈ�� ���� ����.
 */


/* ���� ������ 

void start(Rooms room)
	{
		JOptionPane Jstart=new JOptionPane();
		String username=Jstart.showInputDialog("�̸��� �Է��ϼ���");
		room.setName(username);
		// System.out.println(room.getName());					// Ȯ�ο�. "//" ���� �� �ֿܼ� �̸� ���.
		
		

	}
*/
