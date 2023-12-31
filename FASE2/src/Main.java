import dataStructures.*;
import java.util.Scanner;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martinho Assuncao (68840) pedroassuncao@gmail.com
*/


import artAuctions.enums.CommandResponse;
import artAuctions.enums.FilePath;
import artAuctions.enums.MenuOption;
import artAuctions.exceptions.ArtistHasNoWorksException;
import artAuctions.exceptions.ArtistHasWorksInAuctionException;
import artAuctions.exceptions.AuctionEmptyException;
import artAuctions.exceptions.AuctionExistsException;
import artAuctions.exceptions.NoSoldWorksException;
import artAuctions.exceptions.NoSuchArtistException;
import artAuctions.exceptions.NoSuchAuctionException;
import artAuctions.exceptions.NoSuchUserException;
import artAuctions.exceptions.NoSuchWorkException;
import artAuctions.exceptions.NoSuchWorkInAuctionException;
import artAuctions.exceptions.TooYoungException;
import artAuctions.exceptions.UserExistsException;
import artAuctions.exceptions.UserHasBidsException;
import artAuctions.exceptions.WeakBidException;
import artAuctions.exceptions.WorkExistsException;
import artAuctions.exceptions.WorkExistsInAuctionException;
import artAuctions.exceptions.WorkHasNoBidsInAuctionException;
import artAuctions.specificADTs.implem.AuctionManagerClass;
import artAuctions.specificADTs.interfaces.AuctionGeneric;
import artAuctions.specificADTs.interfaces.AuctionManager;
import artAuctions.specificADTs.interfaces.Bid;
import artAuctions.specificADTs.interfaces.Work;
import artAuctions.specificADTs.interfaces.WorkGeneric;
import artAuctions.specificADTs.interfaces.WorkInAuction;

import java.io.*;
/**
 * 
 * 
 * SE QUISERES TRANSFORMAR NEWLINES DE UNIX EM NEWLINES DE DOS, podes seguir isto:
 * 
 * https://stackoverflow.com/questions/20368781/anything-like-dos2unix-for-windows
 * 
 * Eu tenho ferramentas para converter para Unix
 * 
 * 
 * 
 * 
 */
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
	//Se começar a dar ClassNotFoundException ou wtvr, descomenta esta linha. Vai reiniciar os dados do disco
		initFiles();
		Scanner input= new Scanner(System.in);
		String option=null;
		ObjectSaverLoader<AuctionManager> sysloader=new ObjectSaverLoader<>(FilePath.SYSTEMSTATE.getValue());
		AuctionManager mgr;
		MenuReturnPOJO helper=new MenuReturnPOJO(null,"");
		if((mgr=sysloader.load())==null) {
			mgr=new AuctionManagerClass();
			//System.out.println("Default manager loaded. No previous version exists");
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
			listArtistWorks(input,mgr);
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
			printMenu();
			break;
		case QUIT:
			System.out.println("\nObrigado. Ate a proxima.");
			testSave(mgr);
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
			removeUser(input,mgr);
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
		String login= input.next(),name=input.nextLine().trim();
		int age= input.nextInt();
		String email=input.next();
		input.nextLine();
		try {
			mgr.addUser(login, name, age, email);
			System.out.println("\n"+CommandResponse.ADDUSERSUCCEESS.getResponse()+"\n");
			
		} 
		catch (TooYoungException e) {
			
			System.out.println("\n"+CommandResponse.TOOYOUNG.getResponse()+"\n");
			
		}
		catch(UserExistsException e) {
			
			System.out.println("\n"+CommandResponse.USEREXISTS.getResponse()+"\n");
			
			
		}
	}
	private static void addArtist(Scanner input,AuctionManager mgr) {
		String login= input.next(),name=input.nextLine().trim();
		String artsyName= input.nextLine().trim();
		int age= input.nextInt();
		String email=input.next();
		input.nextLine();
		try {
			mgr.addArtist(login, name,artsyName, age, email);
			System.out.println("\n"+CommandResponse.ADDARTISTSUCCESS.getResponse()+"\n");
			
		} 
		catch (TooYoungException e) {
			
			System.out.println("\n"+CommandResponse.TOOYOUNG.getResponse()+"\n");
			
		}
		catch(UserExistsException e) {
			
			System.out.println("\n"+CommandResponse.USEREXISTS.getResponse()+"\n");
			
			
		}
		
	}
	private static void addWork(Scanner input,AuctionManager mgr) {
		String id=input.next(),
				login= input.next();
		int year=input.nextInt();
		String workName=input.nextLine().trim();
		try {
			mgr.addWork(id, login, year, workName);
			System.out.println("\n"+CommandResponse.WORKPOSTED.getResponse()+"\n");
			
		} 
		catch (WorkExistsException e) {
			
			System.out.println("\n"+CommandResponse.UNORIGINALPOST.getResponse()+"\n");
			
		}
		catch(NoSuchUserException e) {

			System.out.println("\n"+CommandResponse.NOSUCHUSER.getResponse()+"\n");
			
			
		} 
		catch (NoSuchArtistException e) {

			System.out.println("\n"+CommandResponse.NOSUCHARTIST.getResponse()+"\n");
			
		}
		
	}
	private static void infoArtist(Scanner input,AuctionManager mgr) {
		String userLogin=input.next();
		input.nextLine();
		try {
			System.out.println("\n"+mgr.getArtistInfo(userLogin)+"\n");
		} catch (NoSuchUserException e) {
			
			System.out.println("\n"+CommandResponse.NOSUCHUSER.getResponse()+"\n");
			} catch (NoSuchArtistException e) {
				System.out.println("\n"+CommandResponse.NOSUCHARTIST.getResponse()+"\n");
					
			}
		
		
	}
	private static void infoUser(Scanner input,AuctionManager mgr) {
		String userLogin=input.next();
		input.nextLine();
		try {
			System.out.println("\n"+mgr.getUserInfo(userLogin)+"\n");
		} catch (NoSuchUserException e) {
			
			System.out.println("\n"+CommandResponse.NOSUCHUSER.getResponse()+"\n");
		}
		
		
	}
	private static void infoWork(Scanner input,AuctionManager mgr) {
		String id=input.next();
		input.nextLine();
		try {
			
			System.out.println("\n"+mgr.getWorkInfo(id)+"\n");
		} 
		catch(NoSuchWorkException e) {
			
			System.out.println("\n"+CommandResponse.NOSUCHWORK.getResponse()+"\n");
			}
		
		
	}
	private static void addWorkAuction(Scanner input,AuctionManager mgr) {
		String auctionid=input.next(),
				workid=input.next();
				int value=input.nextInt();
		input.nextLine();
		try {
			mgr.addWorkToAuction(auctionid, workid, value);	
			System.out.println("\n"+CommandResponse.WORKPOSTEDTOAUCTION.getResponse()+"\n");
			
		}catch (NoSuchAuctionException e) {
			System.out.println("\n"+CommandResponse.NOSUCHAUCTION.getResponse()+"\n");
		}catch (NoSuchWorkException e) {
			System.out.println("\n"+CommandResponse.NOSUCHWORK.getResponse()+"\n");
			
		}  catch (WorkExistsInAuctionException e) {
			System.out.println("\n"+CommandResponse.WORKPOSTEDTOAUCTION.getResponse()+"\n");
		
		} 
		}
	private static void bid(Scanner input,AuctionManager mgr) {

				String auctionid= input.next(),
						workid=input.next(),
						login= input.next();
				int value= input.nextInt();
				input.nextLine();
			try {
				mgr.addBidToWork(auctionid, workid, login, value);
				System.out.println("\n"+CommandResponse.BIDMADE.getResponse()+"\n");
				
			} catch (NoSuchUserException e) {
				System.out.println("\n"+CommandResponse.NOSUCHUSER.getResponse()+"\n");
			} catch (NoSuchWorkInAuctionException e) {
				System.out.println("\n"+CommandResponse.NOSUCHWORKHERE.getResponse()+"\n");
			} catch (NoSuchWorkException e) {
				System.out.println("\n"+CommandResponse.NOSUCHWORK.getResponse()+"\n");	
			} catch (NoSuchAuctionException e) {
				System.out.println("\n"+CommandResponse.NOSUCHAUCTION.getResponse()+"\n");
			} catch (WeakBidException e) {
				System.out.println("\n"+CommandResponse.BIDTOOCHEAP.getResponse()+"\n");
			}
		
	}
	private static void removeUser(Scanner input,AuctionManager mgr) {
		String login=input.next();
		input.nextLine();
		try {
			mgr.removeUser(login);
			System.out.println("\n"+CommandResponse.REMOVESUCCESS.getResponse()+"\n");
		} catch (NoSuchUserException e) {
			System.out.println("\n"+CommandResponse.NOSUCHUSER.getResponse()+"\n");
		} catch (UserHasBidsException e) {
			System.out.println("\n"+CommandResponse.USERBIDDED.getResponse()+"\n");
		} catch (ArtistHasWorksInAuctionException e) {
			System.out.println("\n"+CommandResponse.ARTISTPOSTED.getResponse()+"\n");
		}
	}
	private static void closeAuction(Scanner input,AuctionManager mgr) {
		String auctionid= input.next();
		input.nextLine();
		try {
		
			AuctionGeneric defunct=mgr.closeAuction(auctionid);
			System.out.println("\n"+CommandResponse.AUCTIONOVER.getResponse());
			Iterator<WorkInAuction> workIt= defunct.listWorks();
			while(workIt.hasNext()) {
				WorkInAuction currWork= workIt.next();
				Work actualWork= (Work) currWork.getWork();
				if(currWork.getNumOfBids()==0) {
					
					System.out.println(actualWork.getId()+" "+ actualWork.getName()+" "+CommandResponse.HERENOUSERWANTSTHIS.getResponse());
					
				}
				else {
					mgr.sellAuctionWork(actualWork, auctionid);
					System.out.print(actualWork.getId());
					System.out.print(" ");
					System.out.print(actualWork.getName());
					System.out.print(" ");
					System.out.print(currWork.getMaxBid().getCollector().getLogin());
					System.out.print(" ");
					System.out.print(currWork.getMaxBid().getCollector().getName());
					System.out.print(" ");
					System.out.print(currWork.getMaxBid().getBidAmmount());
					System.out.print("\n");
					//System.out.println(actualWork.getId()+" "+actualWork.getName()+" "+actualWork.getMaxBid().getBidAmmount());
					
				}
				
			}
			System.out.println();
		} catch (NoSuchAuctionException e) {

			System.out.println("\n"+CommandResponse.NOSUCHAUCTION.getResponse()+"\n");
		}
		
	}

	private static void createAuction(Scanner input,AuctionManager mgr){
		
				String auctionid=input.next();
				input.nextLine();
				try {
					mgr.addAuction(auctionid);	
					System.out.println("\n"+CommandResponse.AUCTIONSTARTSUCCESS.getResponse()+"\n");
					
				} catch (AuctionExistsException e) {
					System.out.println("\n"+CommandResponse.AUCTIONALREADYUP.getResponse()+"\n");
				}
				
			
	}
	private static void printSystem(AuctionManager mgr) {
		
		System.out.println(mgr);
		
	}
	private static void listArtistWorks(Scanner input,AuctionManager mgr){
		String artistid= input.next();
		input.nextLine();
		try {
			IteratorEntries<WorkGeneric,WorkGeneric> it= mgr.getArtistWorks(artistid);
			while(it.hasNext()) {
				Entry<WorkGeneric,WorkGeneric> curr= it.next();
				WorkGeneric currWork= curr.getValue();
				System.out.println(currWork.getId()+" "+currWork.getName()+" "+currWork.getYear()+ " "+currWork.getMaxBid().getBidAmmount());
				
			}
			System.out.println();
		} catch (NoSuchUserException e) {
			System.out.println(CommandResponse.NOSUCHUSER.getResponse()+"\n");
		} catch (NoSuchArtistException e) {
			System.out.println(CommandResponse.NOSUCHARTIST.getResponse()+"\n");
		} catch (ArtistHasNoWorksException e) {
			System.out.println(CommandResponse.NOWORKSFROMARTIST.getResponse()+"\n");
		}
			
			
		}
	private static void listAuctionWorks(Scanner input,AuctionManager mgr) {
		String auctionid= input.next();
		input.nextLine();
		try {
			Iterator<WorkInAuction> workIt= mgr.getAuctionWorks(auctionid);

			System.out.println();
				while(workIt.hasNext()) {

				WorkInAuction curr= workIt.next();
				System.out.println(curr.getWork());
				
			}
		System.out.println();
		} catch (NoSuchAuctionException e) {
			System.out.println("\n"+CommandResponse.NOSUCHAUCTION.getResponse()+"\n");
		} catch (AuctionEmptyException e) {	
			
			System.out.println("\n"+CommandResponse.AUCTIONEMPTY.getResponse()+"\n");
		
		}
	}
	private static void listBidsWork(Scanner input,AuctionManager mgr) {
		String auctionid=input.next(),workid=input.next();
		input.nextLine();
		try {
//			IteratorEntries<Bid,Bid> workBids=mgr.getBidsFromWork(auctionid, workid);
			Iterator<Bid> workBids=mgr.getBidsFromWork(auctionid, workid);
			System.out.printf("\n");
			while(workBids.hasNext()) {
				Bid curr= workBids.next();
				System.out.println(curr);
				
			}
			System.out.printf("\n");
		} catch (NoSuchAuctionException e) {
			System.out.println("\n"+CommandResponse.NOSUCHAUCTION.getResponse()+"\n");
		} catch (NoSuchWorkInAuctionException e) {
			System.out.println("\n"+CommandResponse.NOSUCHWORKHERE.getResponse()+"\n");
		} catch (NoSuchWorkException e) {
			System.out.println("\n"+CommandResponse.NOSUCHWORK.getResponse()+"\n");
		}  catch (WorkHasNoBidsInAuctionException e) {
			System.out.println("\n"+CommandResponse.HERENOUSERWANTSTHIS2.getResponse()+"\n");
		}
		
		
	}
	private static void testSave(AuctionManager mgr) {
		
		ObjectSaverLoader<AuctionManager> loader= new ObjectSaverLoader<>(FilePath.SYSTEMSTATE.getValue());
		loader.save(mgr);
	}
	private static AuctionManager testLoad() {
		ObjectSaverLoader<AuctionManager> loader= new ObjectSaverLoader<AuctionManager>(FilePath.SYSTEMSTATE.getValue());
			return loader.load();
			
		
	}
		private static void listWorksByValue(Scanner input,AuctionManager mgr) {
			
			try {
				IteratorEntries<WorkGeneric, WorkGeneric> it= mgr.listWorksByValue();
				while(it.hasNext()) {
					Entry<WorkGeneric,WorkGeneric> curr= it.next();
					WorkGeneric currWork=curr.getValue();
					
					System.out.println(currWork.getId()+ " "+currWork.getName()+ " "+currWork.getYear()+" "+currWork.getMaxBid().getBidAmmount()+" "+currWork.getAuthor().getLogin()+" "+currWork.getAuthor().getName());
					
				}
				System.out.println();
			} catch (NoSoldWorksException e) {
				System.out.println(CommandResponse.NOSOLDWORKSINSYSTEM.getResponse()+"\n");
			}
			
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
