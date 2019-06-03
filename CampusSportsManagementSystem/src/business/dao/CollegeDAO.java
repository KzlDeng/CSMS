package business.dao;

import java.util.List;

import model.College;

public interface CollegeDAO {
	/**
	 * 添加学院
	 * @param college 学院对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(College college);
	
	/**
	 * 删除学院
	 * @param collegeid 学院id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int collegeid);
	
	/**
	 * 根据学院id获取学院对象
	 * @param collegeid 学院id
	 * @return 学院对象
	 */
	public College selectByid(int collegeid);
	
	/**
	 * 获取所有学院对象列表
	 * @return 学院对象列表
	 */
	public List<College> select();
	
	/**
	 * 分页查询数据
	 * @return
	 */
	public List<College> selectByPage();
}
