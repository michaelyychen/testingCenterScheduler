package tsc.web.dao;

import java.util.List;

import tsc.web.bean.ClassBean;
import tsc.web.bean.RosterBean;
import tsc.web.bean.UserBean;

public interface ImportDao {

	List<Integer> addClasses(List<ClassBean> classes);
	int addClass(ClassBean classBean);
	
	List<Integer> addUsers(List<UserBean> users);
	int addUser(UserBean user);
	
	
	List<Integer> addSomeToRoster(List<RosterBean> rosters);
	int addOneToRoster(RosterBean roster);
}
