package com.tools;



import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

public class CommandExec {
	/**
	 * 用来执行外部命令的实现
	 */
	private ProcessBuilder processBuilder;
	/**
	 * 默认确认timeout的时间间隔，单位：毫秒
	 */
	private static final int DEFAULT_TIMEOUT_INTERVAL = 500;
	/**
	 * 默认timeout
	 */
	private static final int DEFAULT_TIMEOUT=60 * 1000;
	/**
	 * timeout时间，单位毫秒
	 */
	private long timeout=-1;
	/**
	 * 确认timeout的间隔时间，单位毫秒
	 */
	private long interval;
	public ProcessBuilder getProcessBuilder() {
		return processBuilder;
	}
	public void setProcessBuilder(ProcessBuilder processBuilder) {
		this.processBuilder = processBuilder;
	}
	public long getTimeout() {
		return timeout;
	}
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	public long getInterval() {
		return interval;
	}
	public void setInterval(long interval) {
		this.interval = interval;
	}
	/**
	 * 
	 * @param processBuilder	用来执行外部命令的实现
	 * @param timeout	timeout时间
	 * @param interval	换算timeout的间隔时间
	 */
	public CommandExec(ProcessBuilder processBuilder,long timeout,long interval){
		this.processBuilder=processBuilder;
		this.timeout=timeout;
		this.interval=interval;
	}
	/**
	 * 执行外部命令
	 * @param command
	 * @return
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public Process command(List command) throws InterruptedException, IOException {
		if(command==null){
			throw new NullPointerException();
		}
		processBuilder.command(command);
		Process process=processBuilder.start();
		long limitTime=timeout+System.currentTimeMillis();
		Integer status=null;
		do{
			try {
				status=process.exitValue();
				break;
			} catch (IllegalThreadStateException e) {
				// TODO Auto-generated catch block
				try {
					Thread.sleep(getInterval());
				} catch (InterruptedException we) {
					// TODO: handle exception
					return null;
				}
			}
			
		}while(limitTime>System.currentTimeMillis());
		if (status == null) {
            process.destroy();
            try {
                status = process.waitFor();
            } catch (InterruptedException e) {
                throw e;
            }
        }
		return process;
	}
	
}
