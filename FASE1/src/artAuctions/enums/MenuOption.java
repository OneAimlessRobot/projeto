package artAuctions.enums;

public enum MenuOption {
	
	ADDUSER("addUser", "insercao de novo utilizador (coleccionador)"),
	ADDARTIST("addArtist", "insercao de novo artista"),
	REMOVEUSER("removeUser", "remocao de um utilizador"),
	ADDWORK("addWork", "insercao de nova obra de arte"),
	INFOUSER("infoUser", "informacao sobre um utilizador generico"),
	INFOARTIST("infoArtist" ,"informacao sobre um artista"),
	INFOWORK("infoWork" ,"informacao sobre uma obra de arte"),
	CREATEAUCTION("createAuction", "criacao de Leilao"),
	ADDWORKAUCTION("addWorkAuction", "adiciona obra de arte a leilao"),
	BID("bid" ,"submissao de proposta de compra de uma obra num leilao"),
	CLOSEAUCTION("closeAuction", "encerramento de leilao"),
	LISTAUCTIONWORKS("listAuctionWorks", "listagem das obras para venda em leilao"),
	LISTARTISTWORKS("listArtistWorks", "listagem das obras de um artista"),
	LISTBIDSWORK("listBidsWork", "listagem de propostas de compra de obra em leilao"),
	LISTWORKSBYVALUE("ListWorksByValue", "listagem de obras j´a vendidas por valor maximo de venda"),
	PRINTMENU("printmenu","Imprime menu"),
	EMPTYOPTION("",""),
	QUIT("quit", "termina a execucao do programa");

	private String command,description; 

	MenuOption(String command,String description) {
		
		this.command=command;
		this.description=description;
		
	}

	public String getDescription() {
		
		
		return description;
		
		
	}

	public String getCommand() {
		
		
		return command;
		
		
	}
	

}
