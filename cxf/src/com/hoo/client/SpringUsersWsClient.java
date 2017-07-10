package com.hoo.client;
 
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hoo.entity.User;
import com.hoo.service.IComplexUserService;
 
/**
 * <b>function:</b>����Spring����CXF��WebService�ͻ���
 * @author hoojo
 * @createDate 2011-3-28 ����03:20:35
 * @file SpringUsersWsClient.java
 * @package com.hoo.client
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class SpringUsersWsClient {
 
    public static void main(String[] args) {
        //����WebService
//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//        factory.setServiceClass(IComplexUserService.class);
//        factory.setAddress("http://localhost:8080/HelloCXF/Users");
//        
//        IComplexUserService service = (IComplexUserService) factory.create();
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-client.xml");
        IComplexUserService service = ctx.getBean("userWsClient", IComplexUserService.class);
        
        System.out.println("#############Client getUserByName##############");
        User user = service.getUserByName("hoojo");
        System.out.println(user.getEmail()+user.getId());
        
        user.setAddress("China-Guangzhou");
        service.setUser(user);
    }
}