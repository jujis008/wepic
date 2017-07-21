package com.tools;

import java.awt.Color;

import java.awt.Graphics;

import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JApplet;



public class ImageUtil extends JApplet{
	 String addrs="F:\\images\\mm.bmp";//改成自己的图片路径
	 
	 BufferedImage mm,child;
	 
	 CutImage ci;
	 public ImageUtil(){
	 	  try {
	 	   mm=ImageIO.read(new File(addrs));
	 	  } catch (IOException e) {
		   System.out.println("图片读取失败！");
	 	   e.printStackTrace();
		  }
	 	  ci=new CutImage(mm);
		  child=ci.getChildImage(50, 0, 150, 220);
	 }
	 public void init(){		 }
	 public void paint(Graphics g){
	     g.setColor(Color.red);
	     g.drawString("原图：",0,10);
	     g.drawImage(mm, 20,10,this);
	     g.drawString("ci.getChildImage(50, 0, 150, 220)截取后的图片",mm.getWidth()+30,10);
	     g.drawImage(child, mm.getWidth()+50,20,this);
	 }

		    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
