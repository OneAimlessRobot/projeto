package artAuctions.enums;

public enum FilePath {

	QUEUEFILE("ola.res"),
	QUEUEFILETWO("bomDia.res");
	
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
