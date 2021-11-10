package cn.bdqn.factory;

import cn.bdqn.service.UserServiceImpl;

// UserService的工厂，作用是创建UserServiceBean对象
public class UserServiceImplFactory {

    public static UserServiceImpl createUserService(){
        return new UserServiceImpl();
    }
}
