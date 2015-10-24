package tsc.web.dao;

import java.sql.Timestamp;
import java.util.List;

import tsc.web.bean.RequestBean;

public interface RequestDao {

	int addRequest(int userId,int examId,int status);
	int addExam(int courseId,String identifier, int examType, Timestamp start ,Timestamp end,int duration,int pterm);
	List<RequestBean> getRequests(int role,int userid);
	int updateRequestStatus(int requestId,int status);
}
