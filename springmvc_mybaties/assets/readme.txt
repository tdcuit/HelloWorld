http://blog.csdn.net/sushengmiyan/article/details/40142771-- [maven学习笔记]第一节，认识maven,搭建maven开发环境,写第一个HelloWorld
http://blog.csdn.net/gebitan505/article/details/44455235  --  SSM框架——详细整合教程（Spring+SpringMVC+MyBatis）

-------------------------------------------------------配置mvn-------------------------
发现一个国内牛逼的maven仓库，速度真的太快了
修改F:\apache-maven-3.3.9\conf\settings.xml文件
添加如下镜像配置：
 <mirrors>
    <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
    </mirror>
  </mirrors>
去掉并修改localRepository注释：  
<localRepository>E:/mavenworkspace</localRepository>

-------------------------------------------------------配置工程-------------------------
E:\mavenworkspace\HelloSpringMVC_MyBatis>mvn archetype:generate -DgroupId=com.tdcuit -DartifactId=HelloSpringMVC_MyBatis -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DarchetypeCatalog=local
{
	generating project in batch mode 卡住   archetype-catalog.xml --> C:\Users\Administrator\.m2\repository\org\apache\maven\archetype\archetype-catalog\2.4
}

修改pom.xml,参考工程assets目录下pom.xml的dependencies,引入jar包
E:\mavenworkspace\HelloSpringMVC_MyBatis>mvn package

导出pom.xml中的所有dependencies依赖jar包到lib目录(E:\mavenworkspace\HelloSpringMVC_MyBatis\lib)：
E:\mavenworkspace\HelloSpringMVC_MyBatis>mvn dependency:copy-dependencies dependency:sources -DoutputDirectory=lib 

------------------------------------------------------数据库----------------------
C:\Program Files\mysql-5.6.24-win32\bin>mysql -u root -p
mysql> use test
Database changed

DROP TABLE IF EXISTS `user_t`;  
  
CREATE TABLE `user_t` (  
  `id` int(11) NOT NULL AUTO_INCREMENT,  
  `user_name` varchar(40) NOT NULL,  
  `password` varchar(255) NOT NULL,  
  `age` int(4) NOT NULL,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;  
  
/*Data for the table `user_t` */  
  
insert  into `user_t`(`id`,`user_name`,`password`,`age`) values (1,'测试','sfasgfaf',24); 


-------------------------------------------------访问-------------------------------------
http://localhost:8080/HelloSpringMVC_MyBatis/user/showUser?id=1


-----------------------------------------Mybatis 逆向生成工具mybatis-generator-core-1.3.2.jar------
E:\workspace\j2ee\activemq\HelloSpringMVC_MyBatis\WebContent\WEB-INF\lib>java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite

----------------------------------------------------其它------------------------------------
log4j.appender.Console使用ConsoleAppender类
org.apache.log4j.ConsoleAppender.activateOptions()
{
	setWriter(createWriter(System.out));//然后在父类中调用方法subAppend(LoggingEvent event)实际输出信息
相当于如下输出日志
//OutputStreamWriter w = new OutputStreamWriter(System.out);
//w.write("xxxx");
//w.flush();
}

