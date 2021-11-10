package cn.bdqn.factory;

public class UserServiceImpl {

    public UserServiceImpl(){
        System.out.println("对象的构造方法执行了");
    }

    public void init(){
        System.out.println("对象初始化了");
    }

    public void destroy(){
        System.out.println("对象销毁了");
    }
}
