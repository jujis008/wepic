package com.prograssbar;

import java.util.ArrayList;
import java.util.List;

public class State {

	private static List state = new ArrayList();

	// 从State状态类中取得状态的字符串
	// 用字符串的形式拼成XML文件内容
	public synchronized String getStateString() {
		String returnString = "<info><uploadByte>";
		returnString = returnString + state.get(0) + "</uploadByte>";
		returnString = returnString + "<fileSizeByte>" + state.get(1)
				+ "</fileSizeByte>";
		returnString = returnString + "<fileIndex>" + state.get(2)
				+ "</fileIndex>";
		returnString = returnString + "<percent>" + state.get(3)
				+ "</percent></info>";
		return returnString;
	}

	// 设置状态文本中的信息
	// 暂时放到List中，后期将List中的数据取出来拼成XML文本内容
	public synchronized void setStateString(String uploadByte,
			String fileSizeByte, String fileIndex) {
		state.add(0, uploadByte);
		state.add(1, fileSizeByte);
		state.add(2, fileIndex);
		// 生成当前上传进度的公式
		if ((Long.valueOf(uploadByte) * 100 / Long.valueOf(fileSizeByte) < 100)) {
			state.add(3, Long.valueOf(uploadByte) * 100
					/ Long.valueOf(fileSizeByte));
		}
	}
}
