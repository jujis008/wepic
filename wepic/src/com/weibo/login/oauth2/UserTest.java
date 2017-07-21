package com.weibo.login.oauth2;

import com.weibo.login.weibo4j.Users;
import com.weibo.login.weibo4j.model.User;
import com.weibo.login.weibo4j.model.WeiboException;

public class UserTest {
	 public static void main(String[] args) {
         String access_token = args[0];
         String uid =args[1];
         Users um = new Users();
         um.client.setToken(access_token);
         try {
                 User user = um.showUserById(uid);
                 Log.logInfo(user.toString());
         } catch (WeiboException e) {
                 e.printStackTrace();
         }
 }

}
