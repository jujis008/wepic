package com.wetuo.wepic.core.dao;

public interface ITransferAccountTransactionalJdbc {
	public void transferAccount(final int fromUserId, final int toUserId, final int num );
	    

}
