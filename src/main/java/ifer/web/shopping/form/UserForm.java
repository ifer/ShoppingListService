package ifer.web.shopping.form;


public class UserForm {
	private Integer userid;
	
	private String name;
	
	private String passwd;
	
	private String roles;

	public UserForm() {
		
	}

	public UserForm(Integer userid, String name, String passwd, String roles) {
		super();
		this.userid = userid;
		this.name = name;
		this.passwd = passwd;
		this.roles = roles;
	}

	public UserForm(Integer userid, String name, String passwd) {
		super();
		this.userid = userid;
		this.name = name;
		this.passwd = passwd;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
