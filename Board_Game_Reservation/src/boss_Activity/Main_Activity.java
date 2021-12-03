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
import javax.accessibility.AccessibleContext;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;
//import caidan.yaotianshui;

public class Main_Activity extends JFrame {
	public JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel[] panels = new JPanel [4];
	JPanel[] res = new JPanel [4];
	JPanel[] foodPanels = new JPanel [4];

	//JPanel bottom = new JPanel();
	//Container contentPane = frame.getContentPane();
	
	//static Main_Activity window = new Main_Activity();
	Rooms num1 = new Rooms();
	Rooms num2 = new Rooms();
	Rooms num3 = new Rooms();
	Rooms num4 = new Rooms();
	
	static Rooms[] nums = new Rooms[4];
	String user = "";
	
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
	
	Main_Activity() {
		
		Make_Room mr = new Make_Room();
		
		nums[0] = num1;
		nums[1] = num2;
		nums[2] = num3;
		nums[3] = num4;
		
		for (int i = 0; i < 4; i++)
		{
			panels[i] = new JPanel();
			res[i] = new JPanel();
		}
		
		for (int i = 0; i < 4; i++)
		{
			foodPanels[i] = new JPanel();
			foodPanels[i].setBounds(0, 500, 784, 200);
			foodPanels[i].setBackground(new Color(255, 255, 0));
			foodPanels[i].setLayout(null);
			frame.add(foodPanels[i]); 				// foodPanels
			foodPanels[i].setVisible(false);
		}
		
		initialize(num1);
		initialize(num2);
			
		mr.setButton(this, num1, 100, 74, 0);
		mr.setButton(this, num2, 480, 74, 1);
		mr.setButton(this, num3, 100, 255, 2);
		mr.setButton(this, num4, 480, 255, 3);
	}

	public void initialize(Rooms num1) {
		
		//frame = new JFrame();
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
		// ��� �ʱ� �г�
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 100, 784, 400);
		// panel�� ���̾ƿ� ���� ����
		panel.setLayout(null);
		frame.getContentPane().add(panel);		
		
		JLabel intro = new JLabel("���� ���� ���� ��Ȳ");
		intro.setFont(new Font("Dialog", Font.PLAIN, 20));
		intro.setBounds(300, 0, 200, 100);						// ��Ʈ�� �ٿ�� ����
		
		top_panel.add(intro);
		/* room1 ~ 4, room1 ~ 4res �߰� (room2 ~ 4, room2 ~ 4res �߰� ����)	 */											
	}
	
}

/*
 �ʿ� ����
 manage_res ȭ�� �� ����
 (���� �߰��� �� �ִ� ����� ����� �� ���) -> Layout ����
 ���� ������ ������Ʈ�� �Ǿ�� �ϴµ� ��ư ������Ʈ�� ���� ����.
 */


/* ���� ������ 

*/
