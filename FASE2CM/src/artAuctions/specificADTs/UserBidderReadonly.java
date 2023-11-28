package artAuctions.specificADTs;

import java.io.Serializable;

public interface UserBidderReadonly extends Serializable{

	
	int getNumOfBids();
	
	String getUserId();
}
