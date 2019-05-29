package business.impl;

import java.util.List;

import model.VClassScore;
import model.VScore;
import model.VStudentScore;
import basic.iHibBaseDAO;
import business.dao.ScoreStudentDAO;

public class ScoreStudentDaoImpl implements ScoreStudentDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public VStudentScore getByUserid(String userid) {
		String hql = "from VStudentScore where userid=?";
		Object[] param = {userid};
		List<VStudentScore> list = bdao.select(hql,param);
		if(list!=null && list.size()>0){
			for(VStudentScore score:list){
				VStudentScore newScore = score;
				return newScore;
			}
			return null;
		}else{
			return null;
		}
	}

	@Override
	public List<VScore> getScoreStudent(String userid) {
		String hql = "from VScore where userid=?";
		Object[] param = {userid};
		List<VScore> list = bdao.select(hql,param);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<VScore> getAllScoreByPage(int startPage,int pageSize) {
		String hql = "from VScore";
		List<VScore> list=bdao.selectByPage(hql, startPage, pageSize);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public int allScoreCount() {
		String hql = "select count(*) from VScore";
		int count = bdao.selectValue(hql);
		return count;
	}
	@Override
	public double allScore(String userid) {
		String hql = "select round(sum(scorenumber),2) as scorenumber from VScore where userid=?";
		Object[] param = {userid};
		List list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			return (Double)list.get(0);
		}else{
			return 0;
		}
	}
	@Override
	public double avgScore(String userid) {
		String hql = "select round(avg(scorenumber),2) as scorenumber from VScore where userid=?";
		Object[] param = {userid};
		List list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			return (Double)list.get(0);
		}else{
			return 0;
		}
	}

}
