package com.wetuo.wepic.core.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.publish.beans.PublishCat;

public class ChatAction {
	private List msgList = new ArrayList();
	private Map<String, List> map=new HashMap();
	private ServletContext application;
	private String rand;
	private String content;
	private String tid;
	private List keyList = new ArrayList();
	private String flag;
	public String init() {
		rand = getRand();
		ActionContext.getContext().getSession().put("rand", rand);
		return "travel";
	}

	public String Traveller() {
	String flag="";
	ActionContext context = ActionContext.getContext();  
    HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
	if (request.getParameter("flag")==null) {
	}else {
		flag=request.getParameter("flag");
		System.out.println(flag);
	}
	ActionContext.getContext().getSession().put("flag",flag);
		content = this.getContent();//发送消息
		rand = this.getRand();//访客的唯一标识
		if (ActionContext.getContext().getApplication().get("map") == null) {
			msgList = new ArrayList();
			msgList.add(content);
			if (map == null) {
				map = new HashMap();
				map.put(rand, msgList);
			} else {
				map.put(rand, msgList);
			}
			ActionContext.getContext().getApplication().put("map", map);
		} else {
			Map map1 = (Map) ActionContext.getContext().getApplication().get(
					"map");
			
			if (map1.containsKey(rand)) {
				Iterator iterator = map1.keySet().iterator(); //获得Map里的所有的Key值
				while(iterator.hasNext()) {
					String tempKey=(String)iterator.next();//循环得到每一个key
					List tempList=(List)map1.get(tempKey);
					if (rand.equals(tempKey)) {
						tempList.add(content);
						msgList.add(tempList);
					}
					}
				map1.put(rand,msgList);
			}else {
				msgList=new ArrayList();
				msgList.add(content);
				map1.put(rand,msgList);
			}
			map1.put(rand,msgList);
			ActionContext.getContext().getApplication().put("map",map1);
		}
		Map map2=(Map)ActionContext.getContext().getApplication().get("map");
		return "traveler";
	}

	@JSON(serialize = false)
	public String allTravelKey() {
		Map map1 = (Map) ActionContext.getContext().getApplication().get("map");
		for (Iterator iterator = map1.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String key = entry.getKey().toString();
			keyList.add(key);
		}
		return "allTravelKey";
	}
	@JSON(serialize = false)
	public String closeAll() {
		Map map1 = (Map) ActionContext.getContext().getApplication().get("map");
		map1.clear();
		map=map1;
		return "closeAll";
	}
	@JSON(serialize = false)
	public String close() {
		Map map1 = (Map) ActionContext.getContext().getApplication().get("map");
		if (map1.containsKey(getRand())) {
			Iterator iterator = map1.keySet().iterator(); //获得Map里的所有的Key值
			while(iterator.hasNext()) {
				String tempKey=(String)iterator.next();//循环得到每一个key
				List tempList=(List)map1.get(tempKey);
				if (getRand().equals(tempKey)) {
					map1.remove(tempKey);
				}
				}
		}
		map=map1;
		return "close";
	}
	
	@JSON(serialize = false)
	public String GetByTravel() {
		Map map1 = (Map) ActionContext.getContext().getApplication().get("map");
		if (map1.containsKey(getTid())) {
			Iterator iterator = map1.keySet().iterator(); //获得Map里的所有的Key值
			while(iterator.hasNext()) {
				String tempKey=(String)iterator.next();//循环得到每一个key
				List tempList=(List)map1.get(tempKey);
				if (tid.equals(tempKey)) {
					msgList.add(tempList);
				}
				}
			map1.put(tid,msgList);
		}
		map=map1;
		ActionContext.getContext().getApplication().put("map",map);
		return "GetByTravel";
	}
	
	@JSON(serialize = false)
	public String GetTravel() {
		Map map1 = (Map) ActionContext.getContext().getApplication().get("map");
		//flag=0 访客发送消息标记 flag=1客服发送消息的标记
		if (map1==null) {
				msgList.add(getContent());
				map1=new HashMap();
				map1.put(getRand(),msgList);
		}else {
				if (map1.containsKey(getRand())) {
					Iterator iterator = map1.keySet().iterator(); //获得Map里的所有的Key值
					while(iterator.hasNext()) {
						String tempKey=(String)iterator.next();//循环得到每一个key
						List tempList=(List)map1.get(tempKey);
						if (getRand().equals(tempKey)) {
							tempList.add(getContent());
							msgList.add(tempList);
						}
						}
					map1.put(getRand(),msgList);
				}else {
					msgList=new ArrayList();
					msgList.add(content);
					map1.put(getRand(),msgList);
				}
		}
		map=map1;
		ActionContext.getContext().getApplication().put("map",map);
		return "GetTravel";
	}
	
	
	@JSON(serialize = false)
	public String travel() {
		Map map1 = (Map) ActionContext.getContext().getApplication().get("map");
		for (Iterator iterator = map1.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String key = entry.getKey().toString();
			keyList.add(key);
		}
		return "allTravelKey";
	}
	@JSON(serialize = false)
	public String customer() {
		Map map1 = (Map) ActionContext.getContext().getApplication().get("map");
		for (Iterator iterator = map1.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String key = entry.getKey().toString();
			keyList.add(key);
		}
		return "allTravelKey";
	}
	@JSON(serialize = false)
	public String getTravelList() {
		Map map1 = (Map) ActionContext.getContext().getApplication().get("map");
		for (Iterator iterator = map1.entrySet().iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String key = entry.getKey().toString();
			List temp=(List)map1.get(key);
			if (getRand().equalsIgnoreCase(key)) {
				msgList.add(temp);
				map1.put(getRand(),msgList);
			}
		}
		map=map1;
		ActionContext.getContext().getApplication().put("map",map);
		return "getTravelList";
	}
	public String Service() {
		content = this.getContent();
		rand = this.getRand();
		if (msgList == null) {
			msgList = new ArrayList();
			msgList.add(content);
		} else {
			msgList.add(content);
		}
		ActionContext.getContext().getSession().put("msg", msgList);
		if (map == null) {
			map = new HashMap<String, List>();
			map.put(rand, msgList);
			ActionContext.getContext().getApplication().put("map", map);
		} else {
			if (map.containsKey(rand)) {
				ActionContext.getContext().getApplication().put("map", map);
			} else {
				map.put(rand, msgList);
				ActionContext.getContext().getApplication().put("map", map);
			}
		}
		return "service";
	}

	public List getMsgList() {
		return msgList;
	}

	public void setMsgList(List msgList) {
		this.msgList = msgList;
	}

	public Map<String, List> getMap() {
		return map;
	}

	public void setMap(Map<String, List> map) {
		this.map = map;
	}

	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}
	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List getKeyList() {
		return keyList;
	}

	public void setKeyList(List keyList) {
		this.keyList = keyList;
	}
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRandomStr(){
		Random random = new Random();
		String baseStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<10;i++){
			int num = random.nextInt(baseStr.length());
			buffer.append(baseStr.charAt(num));
		}
		return buffer.toString();
	}
	public static void main(String[] args) {
		String[] arr={"a123","a456","a789"};
		for (int i = 0; i < arr.length; i++) {
			String str=arr[i].substring(1);
			System.out.println(str);
		}
		System.out.println(arr.length);
	}

}
