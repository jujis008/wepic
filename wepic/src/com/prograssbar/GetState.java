package com.prograssbar;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;



public class GetState {

	public String execute() throws IOException {
		// 从session中取得名称为uploadState的State对象
		// 这个对象里面存储的信息是当前上传的基本信息
		State tempState = (State) ServletActionContext.getRequest()
				.getSession().getAttribute("uploadState");
		// 调试：在控制台输出当前取得状态字符串的内容
		System.out.println("取得的XML文件的内容为：" + tempState.getStateString());
		// 设置编码为utf-8
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		// 设置响应的格式为XML
		ServletActionContext.getResponse().setContentType("text/xml");
		// 用out对象输出xml代码头
		ServletActionContext.getResponse().getWriter().print(
				"<?xml version='1.0' encoding='" + "utf-8" + "' ?>");
		// 用out对象输出xml代码体
		ServletActionContext.getResponse().getWriter().print(
				tempState.getStateString());
		return null;
	}
}
