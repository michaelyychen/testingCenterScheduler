package tsc.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import tsc.web.bean.ClassBean;
import tsc.web.bean.RosterBean;
import tsc.web.bean.UserBean;
import tsc.web.dao.ImportDao;
import tsc.web.utils.DBUtils;
import tsc.web.utils.IntHandler;
import tsc.web.utils.JdbcUtils;
import tsc.web.utils.LogUtils;

public class ImportDataManager implements ImportDao{

	private  final String CLASS_NAME = "ImportDataManager";
	@Override
	public List<Integer> addClasses(List<ClassBean> classes) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		for(ClassBean classBean : classes){
		try {
			
				result.add(addClass(classBean));
			
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addClasses", e.getMessage());
			continue;
		}
		}
		return result;
	}

	@Override
	public int addClass(ClassBean classBean) {
		String sql = "{call add_class(?,?,?,?,?,?)}";
		List params = new ArrayList();
		params.add(classBean.getClassId());
		params.add(classBean.getSubject());
		params.add(classBean.getCatalogNumber());
		params.add(classBean.getSection());
		params.add(classBean.getInstructorNetID());
		params.add(classBean.getClassName());
		int result = 0;
		
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addClass", e.getMessage());
			return -1;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "addClass", DBUtils.convertToText(sql,classBean.toString()));
			
		}
		
		return result;
	}

	@Override
	public List<Integer> addUsers(List<UserBean> users) {
		List<Integer> result = new ArrayList<Integer>();
		for(UserBean user : users){
		try {
			
				result.add(addUser(user));
			
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addUsers", e.getMessage());
			continue;
		}
		}
		return result;
	}

	@Override
	public int addUser(UserBean user) {
		String sql = "{call add_user(?,?,?,?)}";
		List params = new ArrayList();
		params.add(user.getUserId());
		params.add(user.getEmail());
		params.add(user.getLastName());
		params.add(user.getFirstName());
	
		int result = 0;
		
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addUser", e.getMessage());
			return -1;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "addUser", DBUtils.convertToText(sql,user.toString()));
			
		}
		
		return result;
	}

	@Override
	public List<Integer> addSomeToRoster(List<RosterBean> rosters) {
		List<Integer> result = new ArrayList<Integer>();
		for(RosterBean roster : rosters){
		try {
			
				result.add(addOneToRoster(roster));
			
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addSomeToRoster", e.getMessage());
			continue;
		}
		}
		return result;
	}

	@Override
	public int addOneToRoster(RosterBean roster) {
		String sql = "{call add_roster(?,?)}";
		List params = new ArrayList();
		params.add(roster.getNetId());
		params.add(roster.getClassId());
		int result = 0;
		
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addOneToRoster", e.getMessage());
			return -1;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "addOneToRoster", DBUtils.convertToText(sql,roster.toString()));
			
		}
		return result;

	}

}
