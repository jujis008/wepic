package com.wetuo.wepic.common.util;


public class UserTools {
	public static void main(String[] args) throws Exception {
		MD5Code des = new MD5Code("leemenz");
		String a=des.decrypt("e33d4b34066fa28f04661c1b74625fd8");//解密
		System.out.println(a+"........");
//		 Thumbnails.of("D:\\Java\\apache-tomcat-6.0.26\\webapps\\photography\\userInfoImg\\20130830162954.jpg")
//	    	.sourceRegion(130,54,117, 70)
//	        .size(250,250)
//	            .keepAspectRatio(true) //默认是true,按比例缩小
//	            .outputFormat("JPEG")
//	            .toFile("d:\\hhxabaa.jpg");
	}
}
