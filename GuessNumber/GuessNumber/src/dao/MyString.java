package dao;

public class MyString{
	private String str;
	private int counta;
	private int countb;
	private int length;
	
	//构造函数
	public MyString(){
		str = "";
		counta = 0;
		countb = 0;
		length = 4;
	}
	public MyString(int len){
		str = "";
		counta = 0;
		countb = 0;
		length = len;
	}
	public MyString(String s){
		str =s;
		counta =0;
		countb = 0;
		length = s.length();
	}
	
	
	public String getStr()
	{
		return str;
	}
	public void setStr(String s)
	{
		str = s;
	}

	public int getCounta()
	{
		return counta;
	}
	public void setCounta(int a)
	{
		counta = a;
	}
	
	public int getCountb()
	{
		return countb;
	}
	public void setCountb(int b)
	{
		countb = b;
	}
	
	public int getLength()
	{
		return length;
	}
	public void setLength(int len)
	{
		length = len;
	}
	
	
	//生成新字符串
	public String initString()
	{
		int count =0;
		while(count<length)
		{
			int num = (int)(Math.random()*100)/10;
			String s = String.valueOf(num);
			if(str.indexOf(s)<0)
			{
				//System.out.println(""+num + ":" + s);
				//System.out.println(""+s);
				str += s;
				count++;
			}
		}
		return str;
	}
	//判断猜测情况是否猜对
	public boolean compareString(String guess)
	{
		counta = 0;
		countb = 0;
		for(int i=0; i<length; i++)
		{
			char c = str.charAt(i);
			if(c == guess.charAt(i))
				counta++;
			if(guess.indexOf(c)>=0)
				countb++;
		}
		countb -= counta;
		if(counta == 4 && countb == 0){
			return true;
		}else{
			return false;
		}
	}
}
