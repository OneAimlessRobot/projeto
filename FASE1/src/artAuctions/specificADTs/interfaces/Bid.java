package artAuctions.specificADTs.interfaces;
/**
* @author Adriano Antonio Campos Valente (62411) aa.valente@campus.fct.unl.pt
* @author Pedro Miguel Martino Assuncao (68840) pedroassuncao@gmail.com
*/


import java.io.Serializable;

public interface Bid extends Serializable {

	
	User getCollector();
	
	Work getWork();

	int getBidAmmount();
	
}
