import dataStructures.*;
import java.util.Scanner;

import artAuctions.enums.CommandResponse;
import artAuctions.enums.FilePath;
import artAuctions.enums.MenuOption;
import artAuctions.enums.TestFilePath;
import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.exceptions.NoSuchUserException;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.TooYoungException;
import artAuctions.exceptions.UserExistsException;
import artAuctions.exceptions.WorkExistsException;
import artAuctions.specificADTs.implem.AuctionManagerClass;
import artAuctions.specificADTs.interfaces.AuctionManager;

import java.io.*;

public class Main {

	private static class MenuReturnPOJO{
		
		private AuctionManager mgr;
		private String option;
		public MenuReturnPOJO(AuctionManager mgr,String option) {
			this.mgr=mgr;
			this.option=option;
			
		}
		public AuctionManager getMgr() {
			return mgr;
		}
		public String getOption() {
			return option;
		}
		
	}
	public static void main(String[] args) {
		//deleteFiles(); 
				//Se começar a dar ClassNotFoundException ou wtvr, descomenta esta linha. Vai reiniciar os dados do disco
		initFiles();
		Scanner input= new Scanner(System.in);
		String option=null;
		ObjectSaverLoader<AuctionManager> sysloader=new ObjectSaverLoader<>(FilePath.SYSTEMSTATE.getValue());
		AuctionManager mgr;
		MenuReturnPOJO helper=new MenuReturnPOJO(null,"");
		if((mgr=sysloader.load())==null) {
			mgr=new AuctionManagerClass();
			System.out.println("Default manager loaded. No previous version exists");
		}
		do {
			helper=menuFunction(input,mgr,sysloader);
			mgr=helper.getMgr();
			option=helper.getOption();
			
		}while(!option.equalsIgnoreCase(MenuOption.QUIT.getCommand()));
		
		input.close();
	}
	
	
	private static MenuReturnPOJO menuFunction(Scanner input,AuctionManager mgr,ObjectSaverLoader<AuctionManager> loader) {
		AuctionManager mgr2 = new AuctionManagerClass();
		String request=input.next();
		MenuOption option = MenuOption.EMPTYOPTION;
		for(MenuOption selector: MenuOption.values()) {
			
			if(selector.getCommand().equalsIgnoreCase(request)) {	
				
				option=selector;
				break;
			}
		}
		
		switch(option) {
		case ADDUSER:
			addUser(input,mgr);
			break;
		case ADDARTIST:
			addArtist(input,mgr);
			break;
		case ADDWORK:
			addWork(input,mgr);
			break;
		case ADDWORKAUCTION:
			addWorkAuction(input,mgr);
			break;
		case BID:
			bid(input,mgr);
			break;
		case CLOSEAUCTION:
			closeAuction(input,mgr);
			break;
		case CREATEAUCTION:
			createAuction(input,mgr);
			break;
		case INFOARTIST:
			infoArtist(input,mgr);
			break;
		case INFOUSER:
			infoUser(input,mgr);
			break;
		case INFOWORK:
			infoWork(input,mgr);
			break;
		case LISTARTISTWORKS:
			addUser(input,mgr);
			break;
		case LISTAUCTIONWORKS:
			listAuctionWorks(input,mgr);
			break;
		case LISTBIDSWORK:
			listBidsWork(input,mgr);
			break;
		case LISTWORKSBYVALUE:
			listWorksByValue(input,mgr);
			break;
		case PRINTMENU:
			input.nextLine();
			printMenu();
			break;
		case QUIT:
			input.nextLine();
			input.nextLine();
			System.out.println("Goodnight world.");
			break;
		case TESTSAVE:
			testSave(mgr);
			break;
		case TESTLOAD:
			mgr2=testLoad();
			break;
		case PRINTSYSTEM:
			printSystem(mgr);
			break;
		case REMOVEUSER:
			break;
		default:
			break;
		
		
		
		
		}
		if(option.getCommand().equalsIgnoreCase(MenuOption.TESTLOAD.getCommand())) {
			
			return new MenuReturnPOJO(mgr2,option.getCommand());
			
		}
		return new MenuReturnPOJO(mgr,option.getCommand());

		
	}
	private static void addUser(Scanner input,AuctionManager mgr) {
		String login= input.next(),name=input.next();
		input.nextLine();
		int age= input.nextInt();
		String email=input.next();
		input.nextLine();
		input.nextLine();
		try {
			mgr.addUser(login, name, age, email);
			System.out.println(CommandResponse.ADDUSERSUCCEESS.getResponse());
			
		} 
		catch(UserExistsException e) {
			
			System.out.println(CommandResponse.USEREXISTS.getResponse());
			
			
		}
		catch (TooYoungException e) {
			
			System.out.println(CommandResponse.TOOYOUNG.getResponse());
			
		}
	}
	private static void addArtist(Scanner input,AuctionManager mgr) {
		String login= input.next(),name=input.next();
		input.nextLine();
		String artsyName= input.nextLine();
		int age= input.nextInt();
		String email=input.next();
		input.nextLine();
		input.nextLine();
		try {
			mgr.addArtist(login, name,artsyName, age, email);
			System.out.println(CommandResponse.ADDUSERSUCCEESS.getResponse());
			
		} 
		catch(UserExistsException e) {
			
			System.out.println(CommandResponse.USEREXISTS.getResponse());
			
			
		}
		catch (TooYoungException e) {
			
			System.out.println(CommandResponse.TOOYOUNG.getResponse());
			
		}
		
	}
	private static void addWork(Scanner input,AuctionManager mgr) {
		int id=input.nextInt();
		String login= input.next();
		int year=input.nextInt();
		String workName=input.next();
		input.nextLine();
		input.nextLine();
		try {
			mgr.addWork(id, login, year, workName);
			System.out.println(CommandResponse.WORKPOSTED.getResponse());
			
		} 
		catch(NoSuchUserException e) {

			System.out.println(CommandResponse.NOSUCHUSER.getResponse());
			
			
		} 
		catch (NoSuchArtistException e) {

			System.out.println(CommandResponse.NOSUCHUSER.getResponse());
			
		}
		catch (WorkExistsException e) {
			
			System.out.println(CommandResponse.UNORIGINALPOST.getResponse());
			
		}
		
	}
	private static void infoArtist(Scanner input,AuctionManager mgr) {
		String userLogin=input.next();
		input.nextLine();
		input.nextLine();
		try {
			System.out.println(mgr.getArtistInfo(userLogin));
		} catch (NoSuchUserException e) {
			
			System.out.println(CommandResponse.NOSUCHUSER.getResponse());
			} catch (NoSuchArtistException e) {
				System.out.println(CommandResponse.NOSUCHUSER.getResponse());
				
			}
		
		
	}
	private static void infoUser(Scanner input,AuctionManager mgr) {
		String userLogin=input.next();
		input.nextLine();
		input.nextLine();
		try {
			System.out.println(mgr.getUserInfo(userLogin));
		} catch (NoSuchUserException e) {
			
			System.out.println(CommandResponse.NOSUCHUSER.getResponse());
		}
		
		
	}
	private static void infoWork(Scanner input,AuctionManager mgr) {
		int id=input.nextInt();
		input.nextLine();
		input.nextLine();
		try {
			System.out.println(mgr.getWorkInfo(id));
		} 
		catch(NoSuchWorkException e) {
			
			System.out.println(CommandResponse.NOSUCHWORK.getResponse());
		}
		
		
	}
	private static void addWorkAuction(Scanner input,AuctionManager mgr) {
		
		//TODO
		
	}
	private static void bid(Scanner input,AuctionManager mgr) {
		//TODO
		
		
	}
	private static void closeAuction(Scanner input,AuctionManager mgr) {
		
		//TODO
		
	}

	private static void createAuction(Scanner input,AuctionManager mgr){
		
		//TODO	
			
		}
	private static void printSystem(AuctionManager mgr) {
		
		System.out.println(mgr);
		
	}
	private static void listArtistWorks(Scanner input,AuctionManager mgr){
		/*NOT THIS VERSION*/
		//TODO	
			
		}
	private static void listAuctionWorks(Scanner input,AuctionManager mgr) {
		
	//TODO	
		
	}
	private static void listBidsWork(Scanner input,AuctionManager mgr) {
		
		//TODO
		
		
	}
	private static void testSave(AuctionManager mgr) {
		
		ObjectSaverLoader<AuctionManager> loader= new ObjectSaverLoader<>(FilePath.SYSTEMSTATE.getValue());	//TODO	
		loader.save(mgr);
	}
	private static AuctionManager testLoad() {
		ObjectSaverLoader<AuctionManager> loader= new ObjectSaverLoader<AuctionManager>(FilePath.SYSTEMSTATE.getValue());
			return loader.load();
			
		
	}
		private static void listWorksByValue(Scanner input,AuctionManager mgr) {
			/*NOT THIS VERSION*/
			//TODO
			
			
		}
	private static void printMenu() {
		for(MenuOption option: MenuOption.values()) {
			
			System.out.println(option.getCommand()+" - "+option.getDescription()+"\nParams:\n\n"+option.getParams()+"\n");
			
			
		}
		
	}

	
	private static void initFiles() {
		
		for(FilePath filepath: FilePath.values()) {
			
			File file= new File(filepath.getValue());
			try {
				if(!file.exists()) {
				file.createNewFile();
				}
			} catch (IOException e) {
				System.out.println("Problemas em criar ficheiros novos!!!");
			}
			
		}
		
		
		
	}

	private static void deleteFiles() {
		
		for(FilePath filepath: FilePath.values()) {
			
			File file= new File(filepath.getValue());

	        if (!file.delete()) {
	            System.out.println("Problemas ao apagar este ficheiro (talvez já não exista?):\n"+filepath.getValue()+"\n");
		        
	        }
		}
		
		
		
	}
	

}
