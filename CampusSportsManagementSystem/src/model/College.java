package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ѧԺʵ����
 * @author Administrator
 *
 */
public class College {
	
	private int collegeid;
	private String collegename;
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public College(int collegeid, String collegename) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
	}
	
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	
	/**
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public College(ResultSet rs) {
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.collegeid = rs.getInt("collegeid");
				this.collegename = rs.getString("collegename");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ResultSet�����תList
	 * @param rs ResultSet�����
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//��̬���������ڽ�0~N��VUser��ͼ���ݽ�����List��������
		List<College> list = new ArrayList<College>();
		if(rs != null){
			try{
				do{
					College college = new College();
					college.setCollegeid((rs.getInt("collegeid")));
					college.setCollegename((rs.getString("collegename")));
					list.add(college);
				}while(rs.next());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
}