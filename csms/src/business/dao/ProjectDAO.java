package business.dao;

import java.util.List;

import model.TProject;
import model.VSportProject;

/**
 * 比赛项目业务接口类
 * 
 * @author Administrator
 *
 */
public interface ProjectDAO {
	/**
	 * 添加比赛项目
	 * 
	 * @param project
	 *            项目对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TProject project);

	/**
	 * 修改比赛项目
	 * 
	 * @param project
	 *            项目对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean update(TProject project);

	/**
	 * 删除比赛项目
	 * 
	 * @param projectid
	 *            项目id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int projectid);

	/**
	 * 根据项目id获取项目
	 * 
	 * @param projectid
	 * @return
	 */
	public TProject getptoject(int projectid);

	/**
	 * 获取所有项目对象列表
	 * 
	 * @return 项目对象列表
	 */
	public List<VSportProject> select();

	/**
	 * 获取所有项目对象列表
	 * 
	 * @param strwhere查询条件
	 * @param startPage
	 * @param pagesize
	 * @return 项目对象列表
	 */
	public List<VSportProject> selectList(String strwhere, int startPage,
			int pageSize);

	/**
	 * 通过项目类型获取项目对象列表
	 * 
	 * @param type
	 *            项目类型
	 * @return 项目对象列表
	 */
	public List<VSportProject> selectByType(int type);

	/**
	 * 根据角色类型分页获取比赛项目
	 * 
	 * @param startPage
	 * @param pagesize
	 * @return
	 */
	public List<VSportProject> selectByPage(String strwhere, int roletype,
			int startPage, int pageSize);

	/**
	 * 获取比赛项目数
	 * 
	 * @param roletype
	 *            角色类型
	 * @return 返回比赛项目数
	 */
	public int getProCountByRole(String strwhere, int roletype);

	/**
	 * 获取比赛项目数
	 * 
	 * @param roletype
	 *            角色类型
	 * @return 返回比赛项目数
	 */
	public int getProCount(String strwhere);

	/**
	 * 获取当前运动会所有项目
	 * 
	 * @param strwhere
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<VSportProject> getAllProject(String strwhere, int page,
			int limit);

	/**
	 * 获取当前运动会所有项目
	 * 
	 * @param strwhere
	 * @return
	 */
	public int getAllAmount(String strwhere);

}
