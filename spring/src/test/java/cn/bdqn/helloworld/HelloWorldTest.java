package cn.bdqn.helloworld;

import cn.bdqn.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");//立即加载
        HelloWorld helloWorld = (HelloWorld) ac.getBean("helloWorld");
        helloWorld.info();
    }

    @Test
    public void testUserServiceImpl() throws Exception{

        // 加载配置文件创建容器并不会导致bean的立即初始化
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory bf = new XmlBeanFactory(resource);

        // 只有再去真正要使用的某个bean的时候才会初始化
        UserServiceImpl userService = (UserServiceImpl) bf.getBean("userService");
        System.out.println(userService);
    }


    @Test
    public void testUserService() throws Exception{
        // 1、读取主配置文件信息，获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        ac.close();
    }
// 结果：什么都不输出，说明容器启动的时候，对于多例对象来说并不会创建
}
