package action.control;

import java.io.IOException;
import java.util.List;

import model.TProject;
import util.LayuiData;

import com.alibaba.fastjson.JSON;
import common.properties.RoleType;

public class getProjectAction extends BaseAction {
	private String userid;
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	public String execute() throws IOException {
		
		String type=request.getParameter("type");
		if(type!=null&&!type.equals("")){
			String proname=request.getParameter("strwhere");
			int roletype = Integer.parseInt(session.getAttribute("role").toString());
			String startPage = request.getParameter("page");
			String pageSize = request.getParameter("limit");
			int count =0;
			String strwhere="";
			if(roletype==RoleType.Student){
				count= bdao.selectValue("select count(proid) from TProject where (protype=1 or protype=2) and proname like '%"+proname+"%'");
				strwhere= "from TProject where (protype=1 or protype=2) and proname like '%"+proname+"%'";
			}
			else
			{
				count= bdao.selectValue("select count(proid) from TProject where (protype=3 or protype=4) and proname like '%"+proname+"%'");
				strwhere= "from TProject where (protype=3 or protype=4) and proname like '%"+proname+"%'";
			}
			List<TProject> list = bdao.selectByPage(strwhere, Integer.parseInt(startPage),Integer.parseInt(pageSize));
			out = response.getWriter();
			LayuiData data = new LayuiData(0, "�ɹ�", count, list);
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
			return SUCCESS;
		}else{
			int roletype = Integer.parseInt(session.getAttribute("role").toString());
			String startPage = request.getParameter("page");
			String pageSize = request.getParameter("limit");
			int count = projectdao.getProCount(roletype);
			List<TProject> list = projectdao.selectByPage(roletype, Integer.parseInt(startPage), Integer.parseInt(pageSize));
			out = response.getWriter();
			LayuiData data = new LayuiData(0, "�ɹ�", count, list);
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
			return SUCCESS;
		}
		
	}
}