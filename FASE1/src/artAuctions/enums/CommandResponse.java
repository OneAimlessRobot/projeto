package artAuctions.enums;

public enum CommandResponse {
	
	TOOYOUNG("Idade inferior a 18 anos."),
	ADDUSERSUCCEESS("Registo de utilizador executado."),
	USEREXISTS("Utilizador existente."),
	
	ADDARTISTSUCCESS("Registo de artista executado."),
	
	REMOVESUCCESS("Remocao de utilizador executada."),
	NOSUCHUSER("Utilizador inexistente."),
	USERBIDDED("Utilizador com propostas submetidas."),
	ARTISTPOSTED("Artista com obras em leilao."),
	
	WORKPOSTED("Registo de obra executado"),
	UNORIGINALPOST("Obra existente."),
	NOSUCHARTIST("Artista inexistente.");
	//TODO adicionar o resto do enunciado
/*
 * Ou nao existe nenhum user 
 * com esse nome,ou existe 
 * e n e artista
*/	
	
	private String response; 

	CommandResponse(String response) {
		
		this.response=response;
		
	}
	
	public String getResponse() {
		
		
		return response;
		
		
	}
	

}