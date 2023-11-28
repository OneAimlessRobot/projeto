
package artAuctions.enums;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


public enum CommandResponse {
	
	TOOYOUNG("Idade inferior a 18 anos."),
	ADDUSERSUCCEESS("Registo de utilizador executado."),
	USEREXISTS("Utilizador existente."),
	
	
	NOSUCHUSER("Utilizador inexistente."),
	
	ADDARTISTSUCCESS("Registo de artista executado."),
	
	REMOVESUCCESS("Remocao de utilizador executada."),
	USERBIDDED("Utilizador com propostas submetidas."),
	ARTISTPOSTED("Artista com obras em leilao."),

	WORKPOSTED("Registo de obra executado."),
	UNORIGINALPOST("Obra existente."),
	NOSUCHWORK("Obra inexistente."),
	AUCTIONSTARTSUCCESS("Registo de leilao executado."),
	AUCTIONALREADYUP("Leilao existente."),
	WORKPOSTEDTOAUCTION("Obra adicionada ao leilao."),
	NOSUCHAUCTION("Leilao inexistente."),
	BIDMADE("Proposta aceite."),
	ARTISTMADENOTHING("Artista sem obras."),
	AUCTIONOVER("Leilao encerrado."),
	HERENOUSERWANTSTHIS("sem propostas de venda."),
	HERENOUSERWANTSTHIS2("Obra sem propostas."),
	AUCTIONEMPTY("Leilao sem obras."),
	NOSUCHWORKHERE("Obra inexistente no leilao."),
	BIDTOOCHEAP("Valor proposto abaixo do valor minimo."),
	NOSUCHARTIST("Artista inexistente."),
	NOSOLDWORKSINSYSTEM("Nao existem obras ja vendidas em leilao."),
	NOWORKSFROMARTIST("Artista sem obras.");
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