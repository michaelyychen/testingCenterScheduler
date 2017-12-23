package tsc.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import tsc.web.bean.UserBean;
import tsc.web.dao.UserDao;
import tsc.web.utils.BeanHandler;
import tsc.web.utils.DBUtils;
import tsc.web.utils.IntHandler;
import tsc.web.utils.JdbcUtils;
import tsc.web.utils.LogUtils;
import tsc.web.utils.WebUtils;

public class UserDataManager implements UserDao{

	private final String CLASS_NAME = "UserDataManager";
	@Override
	public UserBean findUser(String email, String id, String password) {
		
		
		String sql = "{call find_user(?,?,?)}";
		List params = new ArrayList();
		params.add(email);
		params.add(id);
		params.add(password);
		UserBean user = null;
		try {
			user = (UserBean) JdbcUtils.queryByProc(sql,params,new BeanHandler(UserBean.class));
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "findUser", e.getMessage());
			return user;
		}finally{
			LogUtils.outputDB(CLASS_NAME,"findUser",DBUtils.convertToText(sql, email,id,password));
		}
		return user;
	}

}
