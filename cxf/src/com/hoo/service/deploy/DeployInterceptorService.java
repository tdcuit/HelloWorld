package com.hoo.service.deploy;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.phase.Phase;
import com.hoo.interceptor.MessageInterceptor;
import com.hoo.service.HelloWorldService;

/**
 * <b>function:</b>在服务器发布自定义的Interceptor
 * 
 * @author hoojo
 * @createDate 2011-3-18 上午07:38:28
 * @file DeployInterceptorService.java
 * @package com.hoo.service.deploy
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DeployInterceptorService {

	public static void main(String[] args) throws InterruptedException {
		// 发布WebService
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		// 设置Service Class
		factory.setServiceClass(HelloWorldService.class);
		factory.setAddress("http://localhost:9000/helloWorld");
		// 设置ServiceBean对象
		factory.setServiceBean(new HelloWorldService());

		// 添加请求和响应的拦截器，Phase.RECEIVE只对In有效，Phase.SEND只对Out有效
		factory.getInInterceptors().add(new MessageInterceptor(Phase.RECEIVE));
		factory.getOutInterceptors().add(new MessageInterceptor(Phase.SEND));

		factory.create();

		System.out.println("Server start ......");
		Thread.sleep(1000 * 60);
		System.exit(0);
		System.out.println("Server exit ");
	}
}