package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static final String FORMAT="yyyy-MM-dd HH:mm:ss";
	
	public  static String getTime(Date time){
		if(time==null){
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(FORMAT);
		return sdf.format(time);
	}
	
	public static Date getTime(String time){
		SimpleDateFormat sdf=new SimpleDateFormat(FORMAT);
		Date date=null;
		try {
			date=sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
