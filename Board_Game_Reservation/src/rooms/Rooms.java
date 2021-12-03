package rooms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import rooms.Rooms;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Rooms {
	private String name;
	private String phone;
	private String time;
	private int res;
	private int cancel;
	private int accept;
	private int price;
	public JPanel bottom_panel;
	public JPanel inputname;
	public JPanel phonenum;
	public JPanel inputtime;
	public int is_res = 0;

	public String getName() {				// ���� �̸� �Է� �ޱ�
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {					// ���� �ð� �Է� �ޱ�
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {					// ���� �ð� �Է� �ޱ�
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getRes() {					// ���� �Է� �ޱ�
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	
	public int resCancel() {				// ���� ���
		return cancel;
	}
	public void setCancel(int cancel) {		
		this.cancel = cancel;
	}
	public int resAccept() {				// ���� ����
		return accept;
	}
	public void setAccept(int accept) {
		this.accept = accept;
	}
	
	public int getPrice() {					// ���� ����
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setBottomPanel(JPanel panel)
	{
		this.bottom_panel = panel;
	}
	public JPanel getBottomPanel()
	{
		return bottom_panel;
	}
	
	public void setInputName(JPanel inputname)
	{
		this.inputname = inputname;
	}
	public JPanel getInputName()
	{
		return inputname;
	}
	public void setPhoneNum(JPanel phonenum)
	{
		this.phonenum = phonenum;
	}
	public JPanel getPhoneNum()
	{
		return phonenum;
	}
	public void setInputTime(JPanel inputtime)
	{
		this.inputtime = inputtime;
	}
	public JPanel getInputTime()
	{
		return inputtime;
	}
}