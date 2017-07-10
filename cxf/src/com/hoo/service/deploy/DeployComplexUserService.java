package com.hoo.service.deploy;

import com.hoo.service.ComplexUserService;

/**
 * <b>function:</b> 发布ComplexUserService服务
 * 
 * @author hoojo
 * @createDate 2011-3-18 上午08:28:57
 * @file DeployComplexUserService.java
 * @package com.hoo.service.deploy
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DeployComplexUserService {

	public static void main(String[] args) throws InterruptedException {
		String address = "http://localhost:9000/complexUser";
		DeployUtils.deployService(address, new ComplexUserService());
		Thread.sleep(1000 * 60 * 20);
		System.exit(0);
		System.out.println("Server exit ");
	}
}