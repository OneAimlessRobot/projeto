package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.User;

public abstract class UserClass implements User, Serializable {

	private static final long serialVersionUID = 1L;
	protected String login,email;
	
	public UserClass(String login,String email) {
		this.login=login;
		this.email=email;
		
		
	}

	public String getLogin() {
		
		return login;
		
	}
	public String getEmail() {
		
		return email;
		
	}
	public String toString() {
		
		return "";
		
	}

}
