package artAuctions.specificADTs.interfaces;

import java.io.Serializable;

public interface Bid extends Serializable {

	
	Collector getCollector();
	
	Work getWork();

	int getBidAmmount();
}
