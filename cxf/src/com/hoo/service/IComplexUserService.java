package com.hoo.service;
 
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import com.hoo.entity.User;
import com.hoo.entity.Users;
 
/**
 * function:定制客户端请求WebService所需要的接口
 * @author hoojo
 * @createDate 2011-3-18 上午08:22:55
 * @file ComplexUserService.java
 * @package com.hoo.service
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface IComplexUserService {
    
    public User getUserByName(@WebParam(name = "name") String name);
    
    public void setUser(User user);
    
    public Users getUsers(int i);
    
    public void setUsers(Users users);
    
    public Users getUserArray(int i);
    
    public void setUserArray(Users users);
    
    public void setUserMap(Users maps);
    
    public Users getUserMap();
}