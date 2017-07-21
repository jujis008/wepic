package com.wetuo.wepic.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import com.wetuo.wepic.common.util.DbUtil;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TransferAccountTransactionalRealJdbcImpl implements ITransferAccountTransactionalJdbc {
	    private DataSource dataSource;
	    private DbUtil DbUtil = new DbUtil();
	    
	    public Connection getConnection(){
	    	try {
	    		//return dataSource.getConnection();
	    		return DbUtil.getMySqlConnect("localhost", "3319", "photography", "root", "");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	    }
	    

	    public DataSource getDataSource() {
			return dataSource;
		}
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}
		
		public void transferAccount(int fromUserId, int toUserId, int num) {
			Connection conn = this.getConnection() ;
			Statement sm = null;
			ResultSet rs = null;
			int remainNum = -1;
			try {
				conn.setAutoCommit(false);
				sm = conn.createStatement() ;
				
				sm.executeUpdate( "update account set totalMoney = totalMoney - " + num + " WHERE user_ = " + fromUserId )  ;
				//sm.executeUpdate( "update account set totalMoney2 = totalMoney - " + num + " WHERE user_ = " + fromUserId )  ;
				sm.executeUpdate( "update account set totalMoney = totalMoney + " + num + " WHERE user_ = " + toUserId )  ;
				
				//
				rs = sm.executeQuery( "select totalMoney from account where user_ = " + fromUserId) ;
				rs.next();
				remainNum = rs.getInt(1);
				System.out.println("#######################remainNum####################################" + remainNum);
				if(remainNum >= 0){
					conn.commit();
				}else{
					System.out.println("#######################rollback####################################" + remainNum);
					conn.rollback();
				}
				/////
				System.out.println("#######################close####################################" );
				
				sm.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("#######################exception####################################" );
				
				try{
					conn.rollback();
				}catch(SQLException ex){
					ex.printStackTrace();
				}
				e.printStackTrace();
			}finally{
				System.out.println("#######################finally####################################" );
				
				sm = null;
				conn = null;
			}
			
		}


//		protected void doInTransactionWithoutResult(int fromUserId,int toUserId,int num) {
//        	//UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing' 	WHERE LastName = 'Wilson'
//        	int update1 = getJdbcTemplate().update(
//                    "update account set totalMoney = totalMoney - " + num + " WHERE user_ = ?",
//                    new Object[] { fromUserId });
//        	int update3 = getJdbcTemplate().update(
//            		"update account set totalMoney2 = totalMoney + " + num + " WHERE user_ = ?",
//                    new Object[] { toUserId });
//        	int update2 = getJdbcTemplate().update(
//            		"update account set totalMoney = totalMoney + " + num + " WHERE user_ = ?",
//                    new Object[] { toUserId });
//            
//        }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TransferAccountTransactionalRealJdbcImpl transfer = new TransferAccountTransactionalRealJdbcImpl();
		transfer.transferAccount(7, 9, 50);
	}


	

}
