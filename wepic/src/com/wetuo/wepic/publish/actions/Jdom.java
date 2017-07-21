package com.wetuo.wepic.publish.actions;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Jdom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   SAXBuilder builder=new SAXBuilder();	//解析器
			try {		
				Document docment=builder.build("c:\\city.xml");//xml文本对象
				Element root=docment.getRootElement();	//根节点	
				List<Element> names=root.getChildren("province");//得到txtbook节点列表
				for(Element element:names){	
					String province=element.getAttributeValue("name");
					
					if(province.equals("山东省")){
						List<Element> cityElement=element.getChildren("city");
						for (Element element2 : cityElement) {
							String city=element2.getAttributeValue("name");
							System.out.println(city);
						}
					}					
				}
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
