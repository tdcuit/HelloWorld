package com.hoo.service.deploy;

import javax.xml.ws.Endpoint;

/**
 * <b>function:</b> 发布WebService工具类
 * 
 * @author hoojo
 * @createDate Mar 17, 2011 8:14:05 PM
 * @file DeployUtils.java
 * @package com.hoo.service.deploy
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public final class DeployUtils {
	/**
	 * <b>function:</b>发布WebService
	 * 
	 * @author hoojo
	 */
	public static void deployService(String address, Object service) {
		System.out.println("Server start ……");
		Endpoint.publish(address, service);
	}
}