package com.hoo.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * <b>function:</b> �ͻ��˵���WebService����Ҫ�Ľӿ�
 * 
 * @author hoojo
 * @createDate 2011-3-17 ����09:00:00
 * @file IHelloWorldService.java
 * @package com.hoo.service
 * @project CXFWebService
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@WebService
public interface IHelloWorldService {
	public String sayHello(@WebParam(name = "name") String name);
}