package tsc.web.dao;

import tsc.web.bean.UserBean;

public interface UserDao {

	public UserBean findUser(String email,String id,String password);
}
