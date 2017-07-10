package com.hoo.client;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.hoo.entity.User;
import com.hoo.entity.Users;
import com.hoo.service.IComplexUserService;
 
/**
 * <b>function:</b>调用ComplexUserService客户端
 * @author hoojo
 * @createDate 2011-3-18 上午08:37:11
 * @file ComplexUserServiceClient.java
 * @package com.hoo.client
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
public class ComplexUserServiceClient {
 
    public static void main(String[] args) {
        //调用WebService
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(IComplexUserService.class);
        factory.setAddress("http://localhost:9000/complexUser");
        
        IComplexUserService service = (IComplexUserService) factory.create();
        
        System.out.println("#############Client getUserByName##############");
        User user = service.getUserByName("hoojo");
        System.out.println(user);
        
        user.setAddress("China-Guangzhou");
        service.setUser(user);
        
        System.out.println("#############Client getUsers##############");
        Users users = service.getUsers(4);
        System.out.println(users);
        List<User> tempUsers = new ArrayList<User>();
        for (User u : users.getUsers()) {
            System.out.println(u);
            u.setName("hoojo" + new Random().nextInt(100));
            u.setAddress("Chian-GuangZhou#" + new Random().nextInt(100));
            tempUsers.add(u);
        }
        users.getUsers().clear();
        users.getUsers().addAll(tempUsers);
        service.setUsers(users);
        
        System.out.println("#############Client getUserArray##############");
        users = service.getUserArray(4);
        User[] userArr = new User[4];
        int i = 0;
        for (User u : users.getUserArr()) {
            System.out.println(u);
            u.setName("hoojo" + new Random().nextInt(100));
            u.setAddress("Chian-ShenZhen#" + new Random().nextInt(100));
            userArr[i] = u;
            i ++;
        }
        
        users.setUserArr(userArr);
        service.setUserArray(users);
        
        System.out.println("##################Client getUserMap###############");
        users = service.getUserMap();
        System.out.println(users.getMaps());
        users.getMaps().put("ABA", userArr[0]);
        service.setUserMap(users);
    }
}