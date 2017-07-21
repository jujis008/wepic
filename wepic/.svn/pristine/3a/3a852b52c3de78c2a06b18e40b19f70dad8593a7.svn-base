package com.wetuo.wepic.core.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TransferAccountTransactionalJdbcImpl extends JdbcDaoSupport implements ITransferAccountTransactionalJdbc {
	    private TransactionTemplate transactionTemplate;
	    public void setTransactionTemplate(
	            TransactionTemplate transactionTemplate) {
	        this.transactionTemplate = transactionTemplate;
	    }

	    @Transactional 
	    public void transferAccount(final int fromUserId, final int toUserId, final int num ) {
	        transactionTemplate.execute(
	        	new TransactionCallbackWithoutResult() {
		            protected void doInTransactionWithoutResult(TransactionStatus status) {
		            	//UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing' 	WHERE LastName = 'Wilson'
		            	int update1 = getJdbcTemplate().update(
			                    "update account set totalMoney = totalMoney - " + num + " WHERE user_ = ?",
			                    new Object[] { fromUserId });
		            	
		            	int update3 = getJdbcTemplate().update(
			            		"update account set totalMoney2 = totalMoney + " + num + " WHERE user_ = ?",
			                    new Object[] { toUserId });
			            
		            	
		            	int update2 = getJdbcTemplate().update(
			            		"update account set totalMoney = totalMoney + " + num + " WHERE user_ = ?",
			                    new Object[] { toUserId });
		            	
//            getJdbcTemplate().update(
//	                    "UPDATE BOOK_STOCK SET STOCK = STOCK - 1 " +
//	                    "WHERE ISBN = ?", new Object[] { isbn });
			            
	                }
	        	}
	       );
	    }

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
