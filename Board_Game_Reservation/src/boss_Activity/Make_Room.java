package boss_Activity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.accessibility.AccessibleContext;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;
import rooms.Shuju;

public class Make_Room {
	/*
	JButton roomGlobal = new JButton();
	JButton roomresGlobal = new JButton();
	JButton resbtnGlobal = new JButton();
	JButton startbtnGlobal = new JButton();
	JButton res_cancelGlobal = new JButton();
	JButton res_to_startGlobal = new JButton();
	*/
	
	Shuju shu = new Shuju();
	
	void setButton(Main_Activity ma, Rooms newRoom, int xpos, int ypos, int flag)
	{	
		// �̸� �������
		JTextField name1 = new JTextField(15);
		
		// ��ȭ��ȣ �������
		JTextField phone1 = new JTextField(15);

		// �Ʒ� �κ� �г�
		// �̸� �Է�
		JPanel inputname = new JPanel();
		newRoom.setInputName(inputname);
		inputname.setBackground(new Color(51, 255, 255));
		inputname.setBounds(0, 0, 784, 10);
		inputname.add(new JLabel("�̸� : "));
		inputname.add(name1);
		ma.num1.setInputName(inputname);
		//num1.setName(name1.toString());
		
		// �ڵ��� ��ȣ �Է�
		JPanel phonenum = new JPanel();
		newRoom.setPhoneNum(phonenum);
		phonenum.setBackground(new Color(51, 255, 255));
		phonenum.setBounds(0, 0, 784, 10);
		phonenum.add(new JLabel("�ڵ��� ��ȣ : "));
		phonenum.add(phone1);
		newRoom.setPhoneNum(phonenum);
		//num1.setPhone(phonenum.toString());
		
		// ���� �ð� �Է�
		JPanel inputtime = new JPanel();
		newRoom.setInputTime(inputtime);
		inputtime.setBackground(new Color(51, 255, 255));
		inputtime.setBounds(0, 0, 784, 10);
		JLabel timeInsert = new JLabel("�ð� : ");
		inputtime.add(timeInsert);
		SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		Date time = new Date();
		String time1 = timeformat.format(time);
		JLabel temptime = new JLabel(time1);		// �ӽ� �ð�
		inputtime.add(temptime);
		newRoom.setInputTime(inputtime);
		
		// ���� / ���� ����
		JPanel status = new JPanel();
		status.setBackground(new Color(51, 255, 255));
		status.setBounds(0, 0, 784, 10);
		status.setLayout(new FlowLayout()); 					// new �� ���� ��!
		JButton resbtn = new JButton("����");
		//resbtnGlobal = resbtn;
		JButton startbtn = new JButton("����");
		//startbtnGlobal = startbtn;
		status.add(resbtn);
		status.add(startbtn);
		
		//panels[flag] ���� �Է�
		//JPanel bottom_panel = new JPanel();
		ma.panels[flag].setBackground(new Color(51, 255, 255));
		ma.panels[flag].setBounds(0, 500, 784, 200);
		//contentPane.add(bottom_panel);
		ma.panels[flag].setLayout(new BoxLayout(ma.panels[flag], BoxLayout.Y_AXIS));	// BoxLayout���� ����
		ma.panels[flag].add(newRoom.getInputName());
		ma.panels[flag].add(newRoom.getPhoneNum());
		ma.panels[flag].add(newRoom.getInputTime());
		ma.panels[flag].add(status);
		ma.panels[flag].setVisible(false);							// ��ư Ŭ�� ������ �� �� ����
		//bottom[flag].add(bottom_panel);
		
		//newRoom.setBottomPanel(bottom_panel); 					// bottom_panel �ֱ� (���߿� ������ ���� ����)
		
		// ���� ���� ȭ��
		//JPanel manage_res = new JPanel();
		JButton res_cancel = new JButton("���� ���");
		//res_cancelGlobal = res_cancel;
		JButton res_to_start = new JButton("��� ����");
		//res_to_startGlobal = res_to_start;
		ma.res[flag].add(res_cancel);								// ���� ��� ��ư �߰�
		ma.res[flag].add(res_to_start);							// ��� ���� ��ư �߰�
		res_cancel.setBounds(50, 50, 784, 10);
		res_to_start.setBounds(50, 80, 784, 10);
		ma.res[flag].setBackground(new Color(51, 255, 255));
		ma.res[flag].setBounds(0, 500, 784, 200);
		ma.frame.getContentPane().add(ma.res[flag]);
		//res[flag].setLayout(new BoxLayout(res[flag], BoxLayout.Y_AXIS));	// BoxLayout���� ����
		ma.res[flag].setVisible(false);							// ��ư Ŭ�� ������ �� �� ����
		//bottom[flag].add(manage_res);

		// ÷���� �޴� �κ�
		//masetBackground(new Color(51, 255, 255));
		//ma.foodPanels[flag].setBounds(0, 500, 784, 200);
		//ma.foodPanels[flag].setVisible(false);
		//ma.frame.getContentPane().add(ma.foodPanels[flag]);		// ÷���� frame�� �߰�
		
		JButton room = new JButton("�� " + (flag + 1));
		//roomGlobal = room;
		JButton roomres = new JButton("");
		//roomresGlobal = roomres;
		roomres.setVisible(false);
		JButton roomStart = new JButton("");
		roomStart.setVisible(false);
		
		// ��ư �ٿ�� ���� 
		room.setBounds(xpos, ypos, 200, 100);						
		roomres.setBounds(xpos, ypos, 200, 100);
		roomStart.setBounds(xpos, ypos, 200, 100);
		ma.panel.add(room);											
		ma.panel.add(roomres);
		ma.panel.add(roomStart);
		ma.frame.add(ma.panels[flag]);
		
		
		//foodPanels
		Button_Actioned ba = new Button_Actioned();		// ba ����
		ba.getFoodPanel(ma, this, flag);
		ma.frame.add(ma.foodPanels[flag]);
		
		// room��ư Ŭ�� �� 
		room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newRoom.setName(name1.getText());
				newRoom.setPhone(phone1.getText());
				Date timeupdate = new Date();
				SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time1 = timeformat.format(timeupdate);
				JLabel temptime = new JLabel(time1);
				newRoom.getInputTime().removeAll();			// �ð� �ʱ�ȭ
				JLabel timeInsert = new JLabel("�ð� : ");
				newRoom.getInputTime().add(timeInsert);
				newRoom.getInputTime().add(temptime);		// �ð� ������Ʈ -> ������ : ��� �ð��� �þ -> ���� �Ϸ�
				newRoom.setTime(time1);
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				ma.panels[flag].setVisible(true);
				ma.res[flag].setVisible(false);
				ma.foodPanels[flag].setVisible(false);		// foodPanels invisible
			}
		});
		
		// Roomers��ư Ŭ�� ��
		roomres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(true);
				ma.foodPanels[flag].setVisible(false);		// foodPanels invisible
			}
		});
		
		// ���� ��ư Ŭ�� �� 
		resbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				room.setVisible(false);				// room ����ȭ
				roomres.setVisible(true);				// roomres ����ȭ
				roomStart.setVisible(false);
				newRoom.setName(name1.getText());
				newRoom.setPhone(phone1.getText());
				Date timeupdate = new Date();
				SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time1 = timeformat.format(timeupdate);
				JLabel temptime = new JLabel(time1);
				newRoom.getInputTime().removeAll();			// �ð� �ʱ�ȭ
				JLabel timeInsert = new JLabel("�ð� : ");
				newRoom.getInputTime().add(timeInsert);
				newRoom.getInputTime().add(temptime);		// �ð� ������Ʈ -> ������ : ��� �ð��� �þ -> ���� �Ϸ�
				newRoom.setTime(time1);
				
				// �ٹٲ��� �̿��ϱ� ���� HTML ���
				roomres.setText(String.format("<HTML>���� �ð� : %s <br>�̸� : %s<br>��ȭ��ȣ : %s</HTML>",newRoom.getTime(), newRoom.getName(), newRoom.getPhone()));
				ma.panels[flag].setVisible(false);			// bottom_panel ����ȭ
				ma.foodPanels[flag].setVisible(false);		// foodPanels invisible
				
			}
		});
		
		// ���� ��� ��ư Ŭ�� ��
		res_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				room.setVisible(true);
				roomres.setVisible(false);
				ma.foodPanels[flag].setVisible(false);		// foodPanels invisible
			}
		});

		// ���� ��ư Ŭ�� ��
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < ma.foodPanels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				room.setVisible(false);				// room ����ȭ
				roomres.setVisible(false);
				roomStart.setVisible(true);
				newRoom.setName(name1.getText());
				newRoom.setPhone(phone1.getText());
				Date timeupdate = new Date();
				SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time1 = timeformat.format(timeupdate);
				JLabel temptime = new JLabel(time1);
				newRoom.getInputTime().removeAll();			// �ð� �ʱ�ȭ
				JLabel timeInsert = new JLabel("�ð� : ");
				newRoom.getInputTime().add(timeInsert);
				newRoom.getInputTime().add(temptime);		// �ð� ������Ʈ -> ������ : ��� �ð��� �þ -> ���� �Ϸ�
				newRoom.setTime(time1);
				
				// �ٹٲ��� �̿��ϱ� ���� HTML ���
				roomStart.setText(String.format("<HTML>���� �ð� : %s <br>�̸� : %s<br>��ȭ��ȣ : %s</HTML>",newRoom.getTime(), newRoom.getName(), newRoom.getPhone()));
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				ma.foodPanels[flag].setVisible(false);
			}
		});
		
		// ���࿡�� �������� �Ѿ�� �� ȭ��
		res_to_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < ma.foodPanels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				room.setVisible(false);				// room ����ȭ
				roomres.setVisible(false);
				roomStart.setVisible(true);
				newRoom.setName(name1.getText());
				newRoom.setPhone(phone1.getText());
				Date timeupdate = new Date();
				SimpleDateFormat timeformat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time1 = timeformat.format(timeupdate);
				JLabel temptime = new JLabel(time1);
				newRoom.getInputTime().removeAll();			// �ð� �ʱ�ȭ
				JLabel timeInsert = new JLabel("�ð� : ");
				newRoom.getInputTime().add(timeInsert);
				newRoom.getInputTime().add(temptime);		// �ð� ������Ʈ -> ������ : ��� �ð��� �þ -> ���� �Ϸ�
				newRoom.setTime(time1);
				
				// �ٹٲ��� �̿��ϱ� ���� HTML ���
				roomStart.setText(String.format("<HTML>���� �ð� : %s <br>�̸� : %s<br>��ȭ��ȣ : %s</HTML>",newRoom.getTime(), newRoom.getName(), newRoom.getPhone()));
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				ma.foodPanels[flag].setVisible(true);
			}
		});
		
		// ���۵� ��ư(roomStart) Ŭ�� ��
		roomStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				ma.foodPanels[flag].setVisible(true);		
			}
		});
		
		
		// Ȯ�� ��ư Ŭ�� ��
		ba.confirm.addActionListener(new ActionListener() {
			private JLabel JLabel;

			public void actionPerformed(ActionEvent e) {
				System.out.println(newRoom.getTime());
				Date timeupdate_end = new Date();
				SimpleDateFormat timeformat_end = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
				String time_end = timeformat_end.format(timeupdate_end);
				
				int starttime = ((newRoom.getTime().charAt(10) * 10) + newRoom.getTime().charAt(11)) * 60 
						+ newRoom.getTime().charAt(14) * 10 + newRoom.getTime().charAt(15);
				int endtime = ((time_end.charAt(10) * 10) + time_end.charAt(11)) * 60 
						+ time_end.charAt(14) * 10 + time_end.charAt(15);
				
				int finalPrice = (endtime - starttime) * 100;
			
				//finalPrice = finalPrice + shu.getTotalPrice();
				// ���� â�� ���� ���ִ� �ڵ�
				ba.finalFrame(finalPrice, flag);
				
				room.setVisible(true);				// room ����ȭ
				roomres.setVisible(false);				// roomres ����ȭ
				roomStart.setVisible(false);
				
				for (int i = 0; i < ma.panels.length; i++)
				{
					if (flag != i)
					{
						ma.panels[i].setVisible(false);
						ma.res[i].setVisible(false);
						ma.foodPanels[i].setVisible(false);		// foodPanels invisible
					}
				}
				
				ma.panels[flag].setVisible(false);
				ma.res[flag].setVisible(false);
				ma.foodPanels[flag].setVisible(false);
				
				
			}
		});
		
		ba.cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ma.foodPanels[flag].setVisible(false);
				room.setVisible(true);				// room ����ȭ
				roomres.setVisible(false);				// roomres ����ȭ
				roomStart.setVisible(false);
				
			}
		});
	}

}