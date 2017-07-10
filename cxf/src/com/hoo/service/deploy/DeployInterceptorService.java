package com.hoo.service.deploy;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.phase.Phase;
import com.hoo.interceptor.MessageInterceptor;
import com.hoo.service.HelloWorldService;

/**
 * <b>function:</b>�ڷ����������Զ����Interceptor
 * 
 * @author hoojo
 * @createDate 2011-3-18 ����07:38:28
 * @file DeployInterceptorService.java
 * @package com.hoo.service.deploy
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class DeployInterceptorService {

	public static void main(String[] args) throws InterruptedException {
		// ����WebService
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		// ����Service Class
		factory.setServiceClass(HelloWorldService.class);
		factory.setAddress("http://localhost:9000/helloWorld");
		// ����ServiceBean����
		factory.setServiceBean(new HelloWorldService());

		// ����������Ӧ����������Phase.RECEIVEֻ��In��Ч��Phase.SENDֻ��Out��Ч
		factory.getInInterceptors().add(new MessageInterceptor(Phase.RECEIVE));
		factory.getOutInterceptors().add(new MessageInterceptor(Phase.SEND));

		factory.create();

		System.out.println("Server start ......");
		Thread.sleep(1000 * 60);
		System.exit(0);
		System.out.println("Server exit ");
	}
}