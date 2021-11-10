package cn.bdqn.helloworld;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogTest {

    @Test
    public void testDogServiceImpl() throws Exception{
        // 1、读取主配置文件信息，获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        DogServiceImpl dogService = (DogServiceImpl) ac.getBean("dogServiceImpl");

        System.out.println(dogService);
    }

    private class DogServiceImpl {
    }
}
