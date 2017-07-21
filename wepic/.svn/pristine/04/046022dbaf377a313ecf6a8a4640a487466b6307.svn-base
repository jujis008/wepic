package com.prograssbar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class FileUploadListener implements ProgressListener {
	// 声明一个HttpSession
	// 目的是把State对象入到这个HttpSession中
	private HttpSession session;

	// 构造方法
	// 参数request来源于GhyJakartaMultiPartRequest.java类中的75行
	public FileUploadListener(HttpServletRequest request) {
		super();
		session = request.getSession();
	}

	public void update(long uploadByte, long fileSizeByte, int fileIndex) {
		if (fileSizeByte == -1) {
			// 如果上传的大小为-1则上传已经完成
			System.out.println("完成了");
		} else {
			if (session.getAttribute("uploadState") == null) {
				// 每次执行时从session中取出uploadState对象
				// 如果为空就new一个State对象并设置里面的XML状态文本内容
				// 并且再次放入session中
				State state = new State();
				state.setStateString("" + uploadByte, "" + fileSizeByte, ""
						+ (fileIndex - 1));
				session.setAttribute("uploadState", state);
			} else {
				// 如果session中有uploadState对象
				// 就取出来，然后设置里面的XML状态文本内容
				// 并且再次放入session中
				State state = (State) session.getAttribute("uploadState");
				state.setStateString("" + uploadByte, "" + fileSizeByte, ""
						+ (fileIndex - 1));
				session.setAttribute("uploadState", state);
			}
		}

	}
}
