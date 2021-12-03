package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import models.Member;
import util.Time;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance=new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	private Connection conn; //DB ���� ��ü
	private PreparedStatement pstmt; //Query �ۼ� ��ü
	private ResultSet rs; //Query ��� Ŀ��
	
	//���� 1, ���� -1, ���� 0
	public int findByUsernameAndPassword(String username, String password) { //�α��� ���� ���� �Լ�
		//1. DB ����
		conn = DBConnection.getConnection();
		
		try {
			//2. Query �ۼ�
			pstmt = conn.prepareStatement("select * from member where username = ? and password = ?");
			
			//3. Query ? �κ� �ϼ� (index 1�� ���� ����)
			//setString, setInt, setDouble, setTimeStamp ���� ����.
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			//4. Query ����
			//(1) executeQuery() = select = ResultSet ����
			//(2) executeUpdate() = insert, update, delete = ���� ����.
			rs = pstmt.executeQuery();
			
			//5. rs�� query�� ����� ù��° ��(���ڵ�) ������ �����
			//����� count(*) �׷��Լ��̱� ������ 1���� ���� ���ϵ�. while���� �ʿ� ����.
			if(rs.next()) { //next()�Լ��� Ŀ���� ��ĭ �����鼭 �ش� �࿡ �����Ͱ� ������ true, ������ false ��ȯ
				//����� �ִٴ� ���� �ش� ���̵�� ����� ��Ī�Ǵ� ���� �ִٴ� ��.
				return 1; //�α��� ����
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return -1; //�α��� ����
	}
	
	public String findID(String name, String phone) { //���̵� ã�� �Լ�
		//1. DB ����
		conn = DBConnection.getConnection();
		
		try {
			//2. Query �ۼ�
			pstmt = conn.prepareStatement("select * from member where name = ? and phone = ?");
			
			//3. Query ? �κ� �ϼ� (index 1�� ���� ����)
			//setString, setInt, setDouble, setTimeStamp ���� ����.
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			//4. Query ����
			//(1) executeQuery() = select = ResultSet ����
			//(2) executeUpdate() = insert, update, delete = ���� ����.
			rs = pstmt.executeQuery();
			
			//5. rs�� query�� ����� ù��° ��(���ڵ�) ������ �����
			//����� count(*) �׷��Լ��̱� ������ 1���� ���� ���ϵ�. while���� �ʿ� ����.
			if(rs.next()) { //ã��
				return "���̵�� "+rs.getString("username")+"�Դϴ�"; //���̵� ����
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return "ȸ�������� �����ϴ�"; //���̵� ����
	}
	
	
	public String findPW(String name, String phone) { //���̵� ã�� �Լ�
		//1. DB ����
		conn = DBConnection.getConnection();
		
		try {
			//2. Query �ۼ�
			pstmt = conn.prepareStatement("select * from member where name = ? and phone = ?");
			
			//3. Query ? �κ� �ϼ� (index 1�� ���� ����)
			//setString, setInt, setDouble, setTimeStamp ���� ����.
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			
			//4. Query ����
			//(1) executeQuery() = select = ResultSet ����
			//(2) executeUpdate() = insert, update, delete = ���� ����.
			rs = pstmt.executeQuery();
			
			//5. rs�� query�� ����� ù��° ��(���ڵ�) ������ �����
			//����� count(*) �׷��Լ��̱� ������ 1���� ���� ���ϵ�. while���� �ʿ� ����.
			
			if(rs.next()) { //ã��
				return "�н������ "+rs.getString("password")+"�Դϴ�"; //�н����� ����
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return "ȸ�������� �����ϴ�"; //�н����� ����
	}
	
	
	//���� 1, ���� -1, 
	public int save(Member member) { //DB�� ������ ����
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement("insert into member values(member_seq.nextval, ?,?,?,?,?, sysdate)");
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getPhone());
			pstmt.executeQuery(); //return���� ó���� ���ڵ��� ����
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void delete(String id)
	{
		conn=DBConnection.getConnection();
		String sql="delete from member where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	//���� Vector<Member>, ���� null
	public Vector<Member> findByAll(){
		conn = DBConnection.getConnection();
		Vector<Member> members = new Vector<>();
		try {
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getLong("id"));
				member.setUsername(rs.getString("username"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setCreateDate(rs.getTimestamp("createDate"));
				members.add(member);
			}
			return members;
	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	

}



