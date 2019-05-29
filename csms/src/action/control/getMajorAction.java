package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import model.ReturnData;
import model.TForumTitle;
import model.TMajor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.ForumDAO;
import business.dao.MajorDAO;
import business.impl.ForumDAOImpl;

import com.alibaba.fastjson.JSON;

public class getMajorAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		try {
			String collegeid = request.getParameter("collegeid");
			if(collegeid!=null && !collegeid.equals("")){
				List<TMajor> list = majordao.selectByColl(Integer.parseInt(collegeid));
				ReturnData rd = new ReturnData();
				rd.code = ReturnData.SUCCESS;
				rd.msg = "�ɹ�";
				rd.data = list;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			}else{
				out.write("ʧ��");
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}