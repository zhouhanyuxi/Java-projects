package com.ncu.clothwholesale.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {


    /**
     * 验证是否为手机号
     *
     * @param mobileNo
     * @return
     */
    public static boolean isValidMobileNo(String mobileNo) {
        // 1、(13[0-9])|(15[02789])|(18[679])|(17[0-9]) 13段 或者15段 18段17段的匹配
        // 2、\\d{8} 整数出现8次
        boolean flag = false;
        Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9]))\\d{8}$");
        Matcher match = p.matcher(mobileNo);
        if (mobileNo != null) {
            flag = match.matches();
        }
        return flag;
    }


    /**
     * 验证是否为正确的邮箱号
     *
     * @param email
     * @return
     */
    public static boolean isValidEmail(String email) {
        // 1、\\w+表示@之前至少要输入一个匹配字母或数字或下划线 \\w 单词字符：[a-zA-Z_0-9]
        // 2、(\\w+\\.)表示域名. 如新浪邮箱域名是sina.com.cn
        // {1,3}表示可以出现一次或两次或者三次.
        String reg = "\\w+@(\\w+\\.){1,3}\\w+";
        Pattern pattern = Pattern.compile(reg);
        boolean flag = false;
        if (email != null) {
            Matcher matcher = pattern.matcher(email);
            flag = matcher.matches();
        }
        return flag;
    }
    public static void main(String[] args) {
		boolean validMobileNo = isValidEmail("762@qq.com");
		System.out.println(validMobileNo);
	}
    
    /**
     * 判断 为空
     * @param str
     * @return true 为空 ， false 不为空
     */
    public static boolean JudgeEmpty(String str){
    	if(str == null || "".equals(str)){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * 判断身份证是否合格
     */
    public static boolean validateIdentity(String no){
    	 
    	      // 对身份证号进行长度等简单判断
    	      if (no == null || no.length() != 18 || !no.matches("\\d{17}[0-9X]"))
    	      {
    	         return false;
    	      }
    	      // 1-17位相乘因子数组
    	      int[] factor = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
    	      // 18位随机码数组
    	      char[] random = "10X98765432".toCharArray();
    	      // 计算1-17位与相应因子乘积之和
    	      int total = 0;
    	      for (int i = 0; i < 17; i++)
    	      {
    	         total += Character.getNumericValue(no.charAt(i)) * factor[i];
    	      }
    	      // 判断随机码是否相等
    	      return random[total % 11] == no.charAt(17);
    	   }
    public static boolean checkEmail(String email)
    {// 验证邮箱的正则表达式 
     String format = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
     //p{Alpha}:内容是必选的，和字母字符[\p{Lower}\p{Upper}]等价。如：200896@163.com不是合法的。
     //w{2,15}: 2~15个[a-zA-Z_0-9]字符；w{}内容是必选的。 如：dyh@152.com是合法的。
     //[a-z0-9]{3,}：至少三个[a-z0-9]字符,[]内的是必选的；如：dyh200896@16.com是不合法的。
     //[.]:'.'号时必选的； 如：dyh200896@163com是不合法的。
     //p{Lower}{2,}小写字母，两个以上。如：dyh200896@163.c是不合法的。
     if (email.matches(format))
      { 
       return true;// 邮箱名合法，返回true 
      }
     else
      {
       return false;// 邮箱名不合法，返回false
      }
    } 

     
  }  