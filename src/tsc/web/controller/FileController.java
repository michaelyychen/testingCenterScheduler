package tsc.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSON;

import tsc.web.bean.ClassBean;
import tsc.web.bean.RosterBean;
import tsc.web.bean.UserBean;
import tsc.web.dao.impl.ImportDataManager;
import tsc.web.framework.Control;
import tsc.web.framework.Controller;
import tsc.web.framework.ControllerServlet;
import tsc.web.utils.FunUtils;
import tsc.web.utils.LogUtils;

@Control("/control/file")
public class FileController implements Controller{

	ImportDataManager dao = new ImportDataManager();
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void errorPage(HttpServletRequest request,
			HttpServletResponse response, String message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void webPageResponse(HttpServletRequest request,
			HttpServletResponse response, String path) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jsonDataResponse() {
		// TODO Auto-generated method stub
		
	}
	
	public void uploadClass(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = ControllerServlet.file_root + File.separator + "class.csv";
		String data = FileUtils.readFileToString(new File(path));
		String classes[] = data.split("\r\n");
		List<ClassBean> list = new ArrayList<ClassBean>();
		for(int i=1;i<classes.length;i++){
			try {
				String line = classes[i];
				String elements[] = line.split(",");
				ClassBean classBean = new ClassBean();
				classBean.setClassId(elements[0].trim());
				classBean.setSubject(elements[1].trim());
				classBean.setCatalogNumber(Integer.parseInt(elements[2].trim()));
				classBean.setSection((elements[3].trim()));
				classBean.setInstructorNetID((elements[4].trim()));
				classBean.setClassName(new StringBuffer().append(classBean.getSubject()).append(classBean.getCatalogNumber()).append("-").append(classBean.getSection()).toString());
				list.add(classBean);
			} catch (Exception e) {
				continue;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		result = dao.addClasses(list);
		FunUtils.outHTML(response,JSON.toJSONString(result));
	}
	
	public void uploadUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = ControllerServlet.file_root + File.separator + "user.csv";
		String data = FileUtils.readFileToString(new File(path));
		String users[] = data.split("\r\n");
		List<UserBean> list = new ArrayList<UserBean>();
		for(int i=1;i<users.length;i++){
			try {
				String line = users[i];
				String elements[] = line.split(",");
				UserBean user = new UserBean();
				user.setFirstName(elements[0]);
				user.setLastName(elements[1]);
				user.setUserId(elements[2]);
				user.setEmail(elements[3]);
				list.add(user);
			} catch (Exception e) {
				continue;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		result = dao.addUsers(list);
		FunUtils.outHTML(response,JSON.toJSONString(result));
	}

	public void uploadRoster(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = ControllerServlet.file_root + File.separator + "roster.csv";
		String data = FileUtils.readFileToString(new File(path));
		String roster[] = data.split("\r\n");
		List<RosterBean> list = new ArrayList<RosterBean>();
		for(int i=1;i<roster.length;i++){
			try {
				String line = roster[i];
				String elements[] = line.split(",");
				RosterBean rosterBean = new RosterBean();
				rosterBean.setNetId(elements[0]);
				rosterBean.setClassId(elements[1]);
		
				list.add(rosterBean);
			} catch (Exception e) {
				continue;
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		result = dao.addSomeToRoster(list);
		FunUtils.outHTML(response,JSON.toJSONString(result));
	}
}
