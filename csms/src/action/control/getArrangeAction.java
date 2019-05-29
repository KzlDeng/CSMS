package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import util.LayuiData;
import model.TArrange;
import model.TClass;
import model.TCollege;
import model.VClass;
import model.VScene;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class getArrangeAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		if (op.equals("list")) {
			// 获取学院信息和班级信息
			List<TCollege> collegelist = collegedao.select();
			List<TClass> classlist = classesdao.select();
			request.setAttribute("collegelist", collegelist);
			request.setAttribute("classlist", classlist);
			return SUCCESS;
		} else if (op.equals("load")) {

			String type = request.getParameter("type");
			if (type != null) {
				String collegeid = request.getParameter("collegeid");
				// 获取学院信息和班级信息
				if (collegeid != null && !collegeid.equals("")) {
					List<VClass> classlist = bdao
							.select("from VClass where collegeid=" + collegeid);
					try {
						out = response.getWriter();
						out.write(JSON.toJSONString(classlist));
						out.flush();
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					List<VClass> classlist = bdao.select("from VClass");
					try {
						out = response.getWriter();
						out.write(JSON.toJSONString(classlist));
						out.flush();
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return SUCCESS;

			} else {

				String startPage = request.getParameter("page");// 当前
				int limit = Integer.parseInt(request.getParameter("limit"));// 条数
				String strwhere = request.getParameter("strwhere");
				String collegeid = request.getParameter("collegeid");
				String classid = request.getParameter("classid");

				String strsearch = "";
				if (strwhere != null && !strwhere.equals("")) {
					strsearch += " where (addr like '%" + strwhere
							+ "%' or proname like '%" + strwhere
							+ "%' or teacollegename like '%" + strwhere
							+ "%' or teausername like '%" + strwhere
							+ "%' or username like '%" + strwhere + "%')  ";
				}
				if (collegeid != null && !collegeid.equals("")) {
					if (strwhere != null && !strwhere.equals("")) {
						strsearch += " and collegeid=" + collegeid;
					} else {
						strsearch += " where (collegeid=" + collegeid
								+ " or teacollegeid=" + collegeid + ")";
					}
				}
				if (classid != null && !classid.equals("")) {
					if (classid != null && !classid.equals("")) {
						strsearch += " and classid='" + classid + "'";
					} else {
						strsearch += " where classid='" + classid + "'";
					}
				}
				int allcount = bdao
						.selectValue("select count(sceneid) from VScene "
								+ strsearch);
				Writer out;
				try {
					out = response.getWriter();
					LayuiData data = new LayuiData(0, "成功", allcount,
							bdao.selectByPage("from VScene" + strsearch,
									Integer.parseInt(startPage), limit));

					out.write(JSON.toJSONString(data));
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return SUCCESS;
			}

		}
		return SUCCESS;

	}
}