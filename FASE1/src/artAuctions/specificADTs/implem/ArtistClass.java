package artAuctions.specificADTs.implem;

import java.io.Serializable;
public class ArtistClass extends UserClass implements Serializable {

	private static final long serialVersionUID = 1L;

	public ArtistClass(String login,String email) {
		
		super(login,email);
		
	}

}
