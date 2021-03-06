package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.TCollege;
import model.TConfig;
import model.VClass;
import util.LayuiData;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class getCollegeAction extends BaseAction {
	//成功返回的页面
		private String requesturl;
		public String getRequesturl() {
			return requesturl;
		}
		public void setRequesturl(String requesturl) {
			this.requesturl = requesturl;
		}
	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		//返回所有学院信息列表
		List<TCollege> listcollege = collegedao.select();
		request.setAttribute("listcollege", listcollege);
		if(op.equals("histogram")){
			List<TConfig> sportlist = sportsdao.select();
			//排序
			Collections.sort(sportlist, new Comparator<TConfig>(){
				@Override
				public int compare(TConfig config1, TConfig config2){
					Integer id1 = config1.getSportid();
					Integer id2 = config2.getSportid();
					return id1.compareTo(id2);//正序
					//id2.compareTo(id1)//倒序1
				}
			});
			try {
				LayuiData data = new LayuiData();
				data.code = LayuiData.SUCCESS;
				data.data = listcollege;
				data.data1 = sportlist;
				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(op.equals("college")){
			requesturl = "collegeScore.jsp";
		}else if(op.equals("major")){
			requesturl = "majorScore.jsp";
		}else if(op.equals("class")){
			requesturl = "classScore.jsp";
		}else if(op.equals("single")){
			requesturl = "singleScore.jsp";
		}else if(op.equals("project")){
			requesturl = "projectScore.jsp";
		}
		return SUCCESS;
//		//返回layui表格
//		if (op.equals("table")) {
//			String startPage = request.getParameter("page");// 起始页面
//			int limit = Integer.parseInt(request.getParameter("limit"));// 每页限制条数
//			int allcount = bdao
//					.selectValue(("select count(collegeid) from TCollege"));
//			Writer out;
//			try {
//				out = response.getWriter();
//				LayuiData data = new LayuiData(0, "成功", allcount,
//						bdao.selectByPage("from TCollege",
//								Integer.parseInt(startPage), limit));
//
//				out.write(JSON.toJSONString(data));
//				out.flush();
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return SUCCESS;
//		} else if (op.equals("all")) {
//			//返回所有学院信息列表
//			List<TCollege> listcollege = collegedao.select();
//			request.setAttribute("listcollege", listcollege);
//			requesturl = "singleScore";
//			return SUCCESS;
//		} else if (op.equals("byid")) {
//			//根据学院id返回该学院信息列表
//			int collegeid  = (Integer) request.getAttribute("collegeid");
//			TCollege college = collegedao.selectByid(collegeid);
//			request.setAttribute("college", college);
//			return SUCCESS;
//		}
	}
}