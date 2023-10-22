package artAuctions.specificADTs.implem;

import java.io.Serializable;

import artAuctions.specificADTs.interfaces.Artist;
public class ArtistClass extends UserClass implements Serializable,Artist {

	private static final long serialVersionUID = 1L;
	private String artsyName;
	public ArtistClass(String login,String name,String artsyName,int age,String email) {
		
		super(login,name,age,email);
		this.artsyName=artsyName;
	}
	@Override
	public String getArtsyName() {
		
		
		return artsyName;
	}

	public boolean equals(Artist artist) {
		boolean result=false;
		if(login==null) {
			if(artist.getLogin()==null) {
				result=!result;
			}
			return result;
		}
		return artist.getLogin().equals(this.getLogin());
		
		
	}
}
