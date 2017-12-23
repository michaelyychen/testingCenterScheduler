package tsc.web.dao;

import java.sql.Date;
import java.sql.Timestamp;



public interface TSCDao {


	int updateTSC(Timestamp closeStart,Timestamp closeEnd,int numOfSeat,int numOfAside,int gap,int interval, String hours);
}
