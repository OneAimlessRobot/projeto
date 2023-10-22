package artAuctions.enums;

public enum TestFilePath {

	QUEUEFILE("ola.res"),
	QUEUEFILETWO("bomDia.res"),
	VECTORFILE("vetor1.res"),
	VECTORFILETWO("vetor2.res");
	
//Usa a adequada

private String resourcesPath=System.getProperty("user.dir")+"/resources/"; //Linux Path
	
	
//private String resourcesPath=System.getProperty("user.dir")+"\resources\"; //Windows path
	
	private String value; 

	TestFilePath(String filename) {
		
		value=resourcesPath+filename;
		
	}
	
	public String getValue() {
		
		
		return value;
		
		
	}
	

}
