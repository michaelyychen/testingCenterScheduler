package tsc.web.dao.impl;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import tsc.web.dao.TSCDao;
import tsc.web.utils.DBUtils;
import tsc.web.utils.IntHandler;
import tsc.web.utils.JdbcUtils;
import tsc.web.utils.LogUtils;

public class TSCInfoDataManager implements TSCDao {

	private  static final String CLASS_NAME = "TSCInfoDataManager";
	@Override
	public int updateTSC(Timestamp closeStart, Timestamp closeEnd, int numOfSeat,
			int numOfAside, int gap, int interval, String hours) {
		String sql = "{call update_TSC(?,?,?,?,?,?,?)}";
		List params = new ArrayList();
		params.add(closeStart);
		params.add(closeEnd);
		params.add(numOfSeat);
		params.add(numOfAside);
		params.add(gap);
		params.add(interval);
		params.add(hours);
		
		int result = 0;
		try {
			result = (Integer) JdbcUtils.queryByProc(sql,params,new IntHandler());
		} catch (Exception e) {
			LogUtils.outputError(CLASS_NAME, "updateTSC", e.getMessage());
			return result;
		}finally{
			LogUtils.outputDB(CLASS_NAME, "updateTSC", DBUtils.convertToText(sql,closeStart,closeEnd,numOfSeat,numOfAside,gap,interval,hours));
			return result;
		}
	
	}

	
}
