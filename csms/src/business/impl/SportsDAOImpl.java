package business.impl;

import java.util.List;

import model.TConfig;
import basic.iHibBaseDAO;
import business.dao.SportsDAO;

public class SportsDAOImpl implements SportsDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public boolean insert(TConfig config) {
		int row = (Integer)bdao.insert(config);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean update(TConfig config) {
		return bdao.update(config);
	}

	@Override
	public List<TConfig> select() {
		String hql = "from TConfig";
		return bdao.select(hql);
	}
	
	@Override
	public TConfig getConfig() {
		String hql = "from TConfig order by sportid desc";
		List<TConfig> list = bdao.select(hql);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
