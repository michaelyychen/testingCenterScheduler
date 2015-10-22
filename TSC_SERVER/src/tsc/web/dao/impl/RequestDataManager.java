package tsc.web.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import tsc.web.dao.RequestDao;
import tsc.web.utils.DBUtils;
import tsc.web.utils.IntHandler;
import tsc.web.utils.JdbcUtils;
import tsc.web.utils.LogUtils;

public class RequestDataManager implements RequestDao{

	private String CLASS_NAME = "RequestDataManager";
	@Override
	public int addRequest(int userId, int examId, int status) {
		
		String sql = "{call add_appointment(?,?,?,?)}";
		List params = new ArrayList();
		params.add(userId);
		params.add(examId);
		params.add(status);


		int result = 0;
		
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addRequest", e.getMessage());
			return -1;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "addRequest", DBUtils.convertToText(sql, userId,examId,status));
			
		}
		
		return 0;
	}

	@Override
	public int addExam(int courseId, int identifier, int examType,
			Timestamp start, Timestamp end, int duration, int pterm) {
		String sql = "{call exam(?,?,?,?,?,?,?)}";
		List params = new ArrayList();
		params.add(courseId);
		params.add(identifier);
		params.add(examType);
		params.add(start);
		params.add(end);
		params.add(duration);
		params.add(pterm);

		int result = 0;
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "addExam", e.getMessage());
			return -1;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "addExam", DBUtils.convertToText(sql,courseId,identifier,examType,start,end,duration,pterm));
			
		}
		
		return result;
	}
	
	
	
	
	

	
}
