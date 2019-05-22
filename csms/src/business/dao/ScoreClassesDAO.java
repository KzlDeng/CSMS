package business.dao;

import java.util.List;

import model.*;


/**
 * 班级成绩业务接口类
 * @author jock
 *
 */
public interface ScoreClassesDAO {
	/**
	 * 
	 * @param classid 班级id
	 * @return 班级成绩信息
	 */
	public VClass getByClassid(int classid);
	/**
	 * 查询所有班级成绩
	 * @return List<VClass>数据集
	 */
	public List<VClass> getAllScoreClasses();
}
