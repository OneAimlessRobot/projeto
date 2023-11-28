/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/

package artAuctions.specificADTs;


import java.io.Serializable;

/**
* Implements interface User. Describes a User (Utilizador\coleccionador).
*/
class UserClass implements User, Serializable {

	private static final long serialVersionUID = 1L;
	protected String login,email,name;
	protected int age;
	protected int numOfBids;
	public UserClass(String login,String name,int age,String email) {
		this.login=login;
		this.email=email;
		this.age=age;
		this.name=name;
		numOfBids=0;
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
	public void addBid() {
		numOfBids++;
	}
	@Override
	public void removeBid() {
		numOfBids--;
	}
	@Override
	public int getAge() {
		
		
		return age;
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

	@Override
	public int numOfBids() {
		return numOfBids;
	}




}
