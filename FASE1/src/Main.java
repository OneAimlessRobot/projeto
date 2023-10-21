import dataStructures.*;
import java.util.Scanner;

import artAuctions.enums.MenuOption;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String option=null;
		do {
			option=menuFunction(input);
			
			
		}while(!option.equalsIgnoreCase(MenuOption.QUIT.getCommand()));
		
		input.close();
	}
	
	
	private static String menuFunction(Scanner input) {
		
		String request=input.nextLine();
		input.nextLine();
		String[] commandArgs=request.split(" ");
		MenuOption option = MenuOption.EMPTYOPTION;
		for(MenuOption selector: MenuOption.values()) {
			
			if(selector.getCommand().equalsIgnoreCase(commandArgs[0])) {	
				
				option=selector;
				break;
			}
		}
		
		switch(option) {
		case ADDUSER:
			break;
		case ADDARTIST:
			break;
		case ADDWORK:
			break;
		case ADDWORKAUCTION:
			break;
		case BID:
			break;
		case CLOSEAUCTION:
			break;
		case CREATEAUCTION:
			break;
		case INFOARTIST:
			break;
		case INFOUSER:
			break;
		case INFOWORK:
			break;
		case LISTARTISTWORKS:
			break;
		case LISTAUCTIONWORKS:
			break;
		case LISTBIDSWORK:
			break;
		case LISTWORKSBYVALUE:
			break;
		case PRINTMENU:
			printMenu();
			break;
		case QUIT:
			break;
		case REMOVEUSER:
			break;
		default:
			break;
		
		
		
		
		}
		
		return option.getCommand();
		
	}
	private static void printMenu() {
		for(MenuOption option: MenuOption.values()) {
			
			System.out.println(option.getCommand()+" - "+option.getDescription());
			
			
		}
		
	}
	
	

}
