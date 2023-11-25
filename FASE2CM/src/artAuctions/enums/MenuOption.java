package artAuctions.enums;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


public enum MenuOption {
	
	ADDUSER("addUser", "insercao de novo utilizador (coleccionador)","addUser login nome\n"
			+ "idade email"),
	ADDARTIST("addArtist", "insercao de novo artista","addArtist login nome\n"
			+ "nomeArtistico\n"
			+ "idade email"),
	REMOVEUSER("removeUser", "remocao de um utilizador","removeUser login"),
	ADDWORK("addWork", "insercao de nova obra de arte","addWork idObra loginAutor ano nome"),//
	INFOUSER("infoUser", "informacao sobre um utilizador generico","infoUser login"),
	INFOARTIST("infoArtist" ,"informacao sobre um artista","infoArtist login"),
	INFOWORK("infoWork" ,"informacao sobre uma obra de arte","infoWork id"),
	CREATEAUCTION("createAuction", "criacao de Leilao","createAuction id"),
	ADDWORKAUCTION("addWorkAuction", "adiciona obra de arte a leilao","addWorkAuction idLeilao idObra valorMinimo"),
	BID("bid" ,"submissao de proposta de compra de uma obra num leilao","bid idLeilao idObra login valor"),
	CLOSEAUCTION("closeAuction", "encerramento de leilao","closeAuction idLeilao"),
	LISTAUCTIONWORKS("listAuctionWorks", "listagem das obras para venda em leilao","listAuctionWorks idLeilao"),
	LISTARTISTWORKS("listArtistWorks", "listagem das obras de um artista",""),
	LISTBIDSWORK("listBidsWork", "listagem de propostas de compra de obra em leilao","listBidsWork idLeilao idObra"),
	LISTWORKSBYVALUE("ListWorksByValue", "listagem de obras ja vendidas por valor maximo de venda",""),
	PRINTMENU("printmenu","Imprime menu",""),
	EMPTYOPTION("","",""),
	QUIT("quit", "termina a execucao do programa",""),
	TESTSAVE("save", "termina a execucao do programa e salva o programa",""),
	TESTLOAD("load", "carrega o estado anterior",""),
	PRINTSYSTEM("printsystem", "mostra a informaçao sobre o sistema atual","");

	private String command,description,params; 

	MenuOption(String command,String description,String params) {
		
		this.command=command;
		this.description=description;
		this.params=params;
	}

	public String getDescription() {
		
		
		return description;
		
		
	}

	public String getCommand() {
		
		
		return command;
		
		
	}
	public String getParams() {
		
		return params;
	}
	

}
