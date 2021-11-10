package cn.bdqn.service;

import cn.bdqn.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{

    // 保存用户
    public void save(User user){

    }

    // 根据id查询用户
    public User queryById(Integer id){
        return new User();
    }

    // 查询全部用户
    public List<User> queryAll(){
        return new ArrayList<User>();
    }
}