package com.weibo.login.oauth2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.weibo.login.weibo4j.*;
import com.weibo.login.weibo4j.model.*;
import com.weibo.login.weibo4j.util.*;

public class OAuth4Code {
	public static void main(String [] args) throws WeiboException, IOException{
		
	//	BareBonesBrowserLaunch.openURL(oauth.authorize("code","1","2"));
		/*System.out.println(oauth.authorize("code","1","2"));
		System.out.print("Hit enter when it's done.[Enter]:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		Log.logInfo("code: " + code);
		try{
			System.out.println(oauth.getAccessTokenByCode(code));
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
				Log.logInfo("Unable to get the access token.");
			}else{
				e.printStackTrace();
			}
		}*/
	}
	}


