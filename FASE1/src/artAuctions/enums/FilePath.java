package artAuctions.enums;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/


public enum FilePath {

	SYSTEMSTATE("systemstate.res");
	
//Usa a adequada

private String resourcesPath=System.getProperty("user.dir")+"/resources/"; //Linux Path
	
	
//private String resourcesPath=System.getProperty("user.dir")+"\resources\"; //Windows path
	
	private String value; 

	FilePath(String filename) {
		
		value=resourcesPath+filename;
		
	}
	
	public String getValue() {
		
		
		return value;
		
		
	}
	

}
