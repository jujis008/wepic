package com.wetuo.wepic.common.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountRecharge;

public class DbUtil {
	
	public Connection getConn(String strDbDialect,String strDbip,String strDbport,String strDbname,String strUsername,String strPassword){
		Connection con = null;
		
		if(strDbDialect.indexOf("MySQLDialect")>-1){
			con = geMySqlConn(strDbDialect,strDbip,strDbport,strDbname,strUsername,strPassword);
		}
		if(strDbDialect.indexOf("Oracle9Dialect")>-1){
			con = getOracle9Conn(strDbDialect,strDbip,strDbport,strDbname,strUsername,strPassword);
		}		
		return con;		
	}//
		
	public Connection geMySqlConn(String strDbDialect,String strDbip,String strDbport,String strDbname,String strUsername,String strPassword){	
		Connection con = null;
		//
		try{
			if(strDbDialect.indexOf("MySQLDialect")>-1){
				Class.forName("com.mysql.jdbc.Driver");				
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());			
				//String dbUrl =  "jdbc:mysql://localhost:3306/ssh2demo ?useUnicode=true&characterEncoding=GB2312";
				String dbUrl =    "jdbc:mysql://"+strDbip+":"+strDbport+"/"+strDbname+"?useUnicode=true&characterEncoding=utf8";
				String dbUser=strUsername;
				String dbPwd=strPassword;								
				con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);	
			} 
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{			
		}
		System.out.println(con);
		return con;
	}//
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		System.out.println(dbUtil.geMySqlConn("MySQLDialect", "localhost", "3306", "photography", "root", ""));
		
		
	}
	
	public Connection  getMySqlConnect(String strIp,String strPort,String strDBName,String strUserName,String strPassWord) {   
        Connection conn = null;
        try {		            
       	 Class.forName("com.mysql.jdbc.Driver");
       	 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
       	 String strConnUrl = "jdbc:mysql://"+strIp+":"+strPort+"/"+strDBName+"?autoReconnect=true";
       	 System.out.println(strConnUrl);
       	 conn = java.sql.DriverManager.getConnection(strConnUrl, strUserName, strPassWord);
       	 
        } catch (SQLException e) {   
            e.printStackTrace();   
        } catch (Exception e) {   
            e.printStackTrace();   
        }
        return conn ;
}//end getOracleConnect()
	
	public Connection getOracle9Conn(String strDbDialect,String strDbip,String strDbport,String strDbname,String strUsername,String strPassword){	
		
		Connection con = null;
		//
		try{
			if(strDbDialect.indexOf("Oracle9Dialect")>-1){
				
				//MySQL
				Class.forName("oracle.jdbc.driver.OracleDriver");//oracle.jdbc.driver.OracleDriver
				//
				//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				//dbc:oracle:thin:@localhost:1521:ora9
				//String dbUrl =  "jdbc:mysql://localhost:3306/ssh2demo ?useUnicode=true&characterEncoding=GB2312";
				//String dbUrl =    "jdbc:oracle:thin:@"+strDbip+":"+strDbport+":"+strDbname+"?useUnicode=true&characterEncoding=utf8";
				String dbUrl =    "jdbc:oracle:thin:@"+strDbip+":"+strDbport+":"+strDbname;
				//String dbUrl =  "jdbc:oracle:thin:@"+strDbip+":1521:"+strDbname;
				String dbUser=strUsername;
				String dbPwd=strPassword;
				
				//
				con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);			  
				
			}
			  
			  
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{			
		}
		System.out.println(con);
		return con;
	}//
	
	public long getmaxid(String sth){
		 long i=1;
		  try{
			    ResultSet rs = null;
				PreparedStatement stmt = null;
		 	    Connection conn = new DbUtil().getConn();
			    String sth1="select * from "+sth+" where DBID_=(select max(DBID_) from "+sth+")";
			    stmt = conn.prepareStatement(sth1);	
			 	rs = stmt.executeQuery(); 
			 	while(rs.next()){
			 	i=rs.getLong("DBID_")+1;
			 	return i;
			 	}
			 	return i;
			    	}
		   catch(Exception e){
			   return i;
			    	}
	    }
	
	public Connection getConn(){
		return getMySqlConnect("localhost","3306","photography","root","");		
		//return getOracle9Conn("Oracle9Dialect","localhost","1521","orclzw","system","larry");		
		
	}
	
	public Account getAccountCharge(int Id,String dbIP,String dbPort,String dbName,String username,String password,String accountTableName){
		Account account=null;
		Connection connection = getMySqlConnect(dbIP,dbPort,dbName,username,password);
		try{
		Statement statement=connection.createStatement();
		
		String sql="SELECT * FROM `"+accountTableName+"` WHERE user_ ="+Id;
//		String sql="SELECT * FROM `Account` WHERE user_ ="+Id;
		ResultSet set=statement.executeQuery(sql);
		
		if(!set.wasNull()){
			
			if(set.next()){
				account=new Account();
				int i=1;
				account.setId(set.getInt(i++));
				account.setUserId(set.getInt(i++));
				account.setAccountID(set.getString(i++));
				account.setTotalMoney(set.getBigDecimal(i++));
//				account.setId(set.getInt(i++));
//				account.setId(set.getInt(i++));
//				account.setId(set.getInt(i++));
				
				}
			
		}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			
		}
		return account;
	}
	
	
	public Account getAccountCharge(int Id){
		Account account=null;
		Connection connection=getConn();
		try{
		Statement statement=connection.createStatement();
		String sql="SELECT * FROM `Account` WHERE user_ ="+Id;
		ResultSet set=statement.executeQuery(sql);
		
		if(!set.wasNull()){
			
			if(set.next()){
				account=new Account();
				int i=1;
				account.setId(set.getInt(i++));
				account.setUserId(set.getInt(i++));
				account.setAccountID(set.getString(i++));
				account.setTotalMoney(set.getBigDecimal(i++));
//				account.setId(set.getInt(i++));
//				account.setId(set.getInt(i++));
//				account.setId(set.getInt(i++));
				
				}
			
		}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			
		}
		return account;
	}
	
	public boolean updateAccount(int id,float rechageMoney,String dbIP,String dbPort,String dbName,String username,String password,String accountTableName){
		Account account=getAccountCharge(id);
		Connection connection= getMySqlConnect(dbIP,dbPort,dbName,username,password);
        try{
		if(account!=null){
			Statement statement=connection.createStatement();
			String sql="update Account set totalMoney=+"+rechageMoney+"  where user_="+id;
			System.out.println(sql+"update=======================================");
			boolean boo=statement.execute(sql);
			return boo;
		}
		
        }catch (Exception e) {
        	return false;
			
		}
        return false;
		
	}
	public boolean insertAccountCharge(int id,BigDecimal rechageMoney){
		Account account=getAccountCharge(id);
		AccountRecharge recharge=new AccountRecharge();
		recharge.setAccountID(account.getAccountID());
		recharge.setUserId(id);
		recharge.setRechargeMoney(rechageMoney);
		recharge.setIfConfirmed(0);
		recharge.setRechargeTime(new Timestamp(new Date().getTime()));
		String sql="insert into accountrecharge (`user_`,`accountID`,`rechargeTime`,`rechargeMoney`,`ifConfirmed`)" +
				"value("+recharge.getUserId()+",'"+recharge.getAccountID()+"'," +
						"'"+recharge.getRechargeTime()+"',"+recharge.getRechargeMoney()+"," +
								""+recharge.getIfConfirmed()+")";
		Connection connection=getConn();
		try{
			System.out.println(sql+"insert=======================================");
		Statement statement=connection.createStatement();
		boolean boo=statement.execute(sql);
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
