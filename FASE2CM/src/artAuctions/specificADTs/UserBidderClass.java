package artAuctions.specificADTs;

import java.io.Serializable;

class UserBidderClass implements UserBidder, Serializable, Comparable<UserBidder> {

	private static final long serialVersionUID = 1L;
	
	private UserReadonly user;
	private int numOfBids;
	
	public UserBidderClass(UserReadonly user) {
		this.user=user;
		this.numOfBids=0;
		
	}
	@Override
	public int compareTo(UserBidder arg0) {
		return getUserId().compareTo(arg0.getUserId());
	}

	@Override
	public int getNumOfBids() {
		return numOfBids;
	}

	@Override
	public String getUserId() {
		return user.getLogin();
	}
	@Override
	public void incBids() {
		numOfBids++;
	}
	@Override
	public void decBids() {

		numOfBids--;
	}

}
