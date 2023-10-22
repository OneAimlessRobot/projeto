package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.User;

public abstract class UserClass implements User, Serializable {

	private static final long serialVersionUID = 1L;
	protected String login,email,name;
	protected int age;
	public UserClass(String login,String name,int age,String email) {
		this.login=login;
		this.email=email;
		this.age=age;
		this.name=name;
		
		
	}
	@Override

	public String getName() {
		
		return name;
		
	}
	@Override

	public String getLogin() {
		
		return login;
		
	}
	@Override
	public String getEmail() {
		
		return email;
		
	}
	@Override
	public int getAge() {
		
		
		return age;
	}
	public String toString() {
		
		return getLogin()+" "+ getName()+ " "+ getAge()+" "+getEmail();
		
		
	
	}
	public boolean equals(Object user) {
		boolean result=false;

		if(!(user instanceof User)) {

			return false;
			
		}
		if(login==null) {
			if(((User)user).getLogin()==null) {

				result=true;
			}
		}
		else if(((User)user).getLogin()==null) {
			
			result=false;
			
		}
		else {
		result= ((User)user).getLogin().equals(this.getLogin());
		}
		return result;
		
		
	}

}
