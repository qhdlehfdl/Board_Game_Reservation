package rooms;

public class Rooms {
	private String name;
	private int phone;
	private int time;
	private int res;
	private int cancel;
	private int accept;
	private int price;
	
	public String getName() {				// ���� �̸� �Է� �ޱ�
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {					// ���� �ð� �Է� �ޱ�
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getTime() {					// ���� �ð� �Է� �ޱ�
		return time;
	}
	public void setTime(int time) {
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
}
