package com.ncu.clothwholesale.tool;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <p>Title : 数据格式转换工具类</p>
 * <p>Description : </p>
 * @author wpx
 * @date 2018年7月14日 下午3:19:39
 */
public class MyDataFormatUtil {
	/**
	 * int类型 ，以秒为单位的时间转为字符串时分秒
	 * @param time
	 * @return
	 */
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormatTen(minute) + "分" + unitFormatTen(second) + "秒";
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormatTen(hour) + "时" + unitFormatTen(minute) + "分" + unitFormatTen(second)+"秒";
            }
        }
        return timeStr;
    }
    /**
     * 时间格式 +0(十位加0)
     * @param i
     * @return
     */
    public static String unitFormatTen(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else if(i>=10 && i< 100)
            retStr = "" + i;
        return retStr;
    }
    /**
     * 百位十位加0
     * @param i
     * @return
     */
    public static String unitFormatHundred(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "00" + Integer.toString(i);
        else if(i>=10 && i< 100)
        	retStr = "0" + Integer.toString(i);
        else if(i>=100 && i<1000)
            retStr = "" + i;
        return retStr;
    }
    /**
     * 将年月日变为编号的可模糊查询形式
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String dateToSeachCode(String year,String month,String day){
    	String recCode = "";
		if(year!=null && !year.equals("")){
			recCode+=year;
		}else{
			recCode+="____";
		}
		if(month!=null && !month.equals("")){
			recCode+=unitFormatTen(Integer.parseInt(month));
		}else{
			recCode+="__";
		}
		if(day!=null && !day.equals("")){
			recCode+=unitFormatTen(Integer.parseInt(day));
		}else{
			recCode+="__";
		}
		return recCode;
    }
  

	public static String secToTime(Long totaTime) {
		// TODO Auto-generated method stub
		String string = String.valueOf(totaTime);
		int time = Integer.parseInt(string);
		return secToTime(time);
	}
	
	public static String DoubleToString(Double data){
		DecimalFormat df = new DecimalFormat("0.00"); 
		return  df.format(data);
	}
	
	public static String DoubleToString(Long data){
		DecimalFormat df = new DecimalFormat("0.00"); 
		return  df.format(data);
	}
	public static String DateToStrYMDHMSS(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
		return format.format(date);
	}
	public static String DateToStrYMDHMS(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}
	public static String DateToStrYMD(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	public static String DateToStrYMDHM(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return format.format(date);
	}
	public static String DateToYMDHMSS(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		return format.format(date);
	}
 
	public static String getYear(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(date);
	}
	public static String getMonth(Date date){
		SimpleDateFormat format = new SimpleDateFormat("MM");
		return format.format(date);
	}
	public static String getDay(Date date){
		SimpleDateFormat format = new SimpleDateFormat("dd");
		return format.format(date);
	}
	public static String getHour(Date date){
		SimpleDateFormat format = new SimpleDateFormat("hh");
		return format.format(date);
	}
	public static String getMinite(Date date){
		SimpleDateFormat format = new SimpleDateFormat("mm");
		return format.format(date);
	}
	public static String getSecond(Date date){
		SimpleDateFormat format = new SimpleDateFormat("ss");
		return format.format(date);
	}
	public static String getMillisecond(Date date){
		SimpleDateFormat format = new SimpleDateFormat("SSS");
		return format.format(date);
	}
}
