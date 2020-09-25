package control;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.MyString;


public class GameLogic {
	private String str;
	private int count;
//	private long beginTime;
//	private long endTime;
	private Date time;
	private String timer;
	
	public GameLogic(){
		
	}
	
	public String getStr(){
		return str;
	}
//	public String setStr(String s){
//		str = s;
//		return str;
//	}
	public int getCount(){
		return count;
	}
//	public int setCount(int c){
//		count = c;
//		return count;
//	}
//	public long getBeginTime(){
//		return beginTime;
//	}
//	public long setBeginTime(long b){
//		beginTime = b;
//		return beginTime;
//	}
//	public long getEndTime(){
//		return endTime;
//	}
//	public long setEndTime(long e){
//		endTime = e;
//		return endTime;
//	}
	public Date getTime(){
		return time;
	}
//	public Time setTime(Time t){
//		time = t;
//		return time;
//	}
	public String getTimer(){
		return timer;
	}
	
	public String GenerateString(){
		MyString s = new MyString();
		str = s.initString();
		System.out.println("string:"+str);
		System.out.println("游戏开始！请输入第一次所猜数字：");
		count=0;
		return str;
	}
	public String GenerateString(int len){
		MyString s = new MyString(len);
		str = s.initString();
		System.out.println("string:"+str);
		count=0;
		return str;
	}
	public String GenerateString(String s){
		str = s;
		MyString mys = new MyString();
		mys.setStr(s);
		return str;
	}
	//检查输入
	public int checkString(String guess){
		count ++;
		
		int flag = 0;
		String pattern = "^[0-9]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(guess);

		if(guess.length()!=str.length()){
			flag = -1;
			System.out.println("长度不符合");
		}else if(!m.matches()){
			flag = -2;
			System.out.println("输入非数字");
		}else{
			for(int i = 0; i<guess.length()-1; i++){
				for(int j = i+1; j< guess.length(); j++)
				if(guess.charAt(j)==guess.charAt(i)){
					flag = -3;
					System.out.println("输入有重复数字");
					break;
				}
				if(flag == -3)break;
			}
		}
		if(flag<0)
			System.out.println("输入不合法，请重新输入！");
		
		return flag;
	}
	
	public String compareString(String guess){
		String result = "";
		MyString s = new MyString(str);
		s.compareString(guess);
		result = ""+s.getCounta()+"A"+s.getCountb()+"B";
		
		if(result.equals("4A0B")){
			
			System.out.println("一共猜了"+count+"次,总用时"+timer);
		}
		else{
			System.out.println("猜测结果："+result+"。请输入下一次所猜数字");
		}
		return result;
	}
	
//	public long timeingBegin(){
//		beginTime = System.currentTimeMillis();
//		return beginTime;
//	}
//	
//	public Date timingNow(){
//		endTime = System.currentTimeMillis();
//		time = new Date(endTime - beginTime);
//		SimpleDateFormat min = new SimpleDateFormat("mm");
//		SimpleDateFormat sec = new SimpleDateFormat("ss");
//		timer = min.format(time)+ ":" +sec.format(time);
//		//System.out.println("endTime:"+endTime);
//		
//		return time;
//	}
	
	
	
//	public void gameBegin(){
//		GenerateString();
//		timeingBegin();
//		timingNow();
//	}
	
	public String guessOnce(String guess){
		String result = "";
		if(checkString(guess) == 0)
			result = compareString(guess);
		
		return result;
	}
	
}
