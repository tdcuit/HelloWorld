package com.hoo.client;
 
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hoo.entity.User;
import com.hoo.service.IComplexUserService;
 
/**
 * <b>function:</b>请求Spring整合CXF的WebService客户端
 * @author hoojo
 * @createDate 2011-3-28 下午03:20:35
 * @file SpringUsersWsClient.java
 * @package com.hoo.client
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class SpringUsersWsClient {
 
    public static void main(String[] args) {
        //调用WebService
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