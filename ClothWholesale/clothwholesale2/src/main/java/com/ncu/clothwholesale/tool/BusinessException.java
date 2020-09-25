package com.ncu.clothwholesale.tool;

/**
 * <p>Title : 业务层异常</p>
 * <p>Description : 业务层异常，比如账号和密码出错 </p>
 * @author wpx
 * @date 2018年7月13日 下午7:15:20
 */
public class BusinessException extends Exception {

	/** serialVersionUID*/
	private static final long serialVersionUID = -5212079010855161498L;
	
	public BusinessException(String message){
		super(message);
		this.message = message;
	}

	//异常信息
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
