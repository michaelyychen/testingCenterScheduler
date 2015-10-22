package tsc.web.dao;

import java.sql.Timestamp;

public interface RequestDao {

	int addRequest(int userId,int examId,int status);
	int addExam(int courseId,int identifier, int examType, Timestamp start ,Timestamp end,int duration,int pterm);
}
