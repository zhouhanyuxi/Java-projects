package com.ncu.clothwholesale.vo;

public class RegisterInfo {
	private String username;

    private String customerName;

    private String password;

    private String password2;

    private String mobile;

    private String email;

    private String contactAddr;

    private String postcode;

    public RegisterInfo(){}
    
	public RegisterInfo(String username, String customerName, String password,
			String password2, String mobile, String email, String contactAddr,
			String postcode) {
		super();
		this.username = username;
		this.customerName = customerName;
		this.password = password;
		this.password2 = password2;
		this.mobile = mobile;
		this.email = email;
		this.contactAddr = contactAddr;
		this.postcode = postcode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactAddr() {
		return contactAddr;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "RegisterInfo [username=" + username + ", customerName="
				+ customerName + ", password=" + password + ", password2="
				+ password2 + ", mobile=" + mobile + ", email=" + email
				+ ", contactAddr=" + contactAddr + ", postcode=" + postcode
				+ "]";
	}
    
    
}
