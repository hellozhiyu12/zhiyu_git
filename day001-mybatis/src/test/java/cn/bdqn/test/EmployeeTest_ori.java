package cn.bdqn.test;

import cn.bdqn.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class EmployeeTest_ori {
    // 测试1： 查询全部的员工
    @Test
    public void testSelectAllEmployees() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("selectAllEmployees");

        // 5、循环遍历
        if (employees != null && employees.size() > 0){
            for (Employee emp:employees) {
                System.out.println(emp);
            }
        }

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testSelectById() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        Employee employee = session.selectOne("cn.bdqn.mapper.selectById",1);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }


    // 根据姓名模糊查询员工信息
    @Test
    public void testSelectByName() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("cn.bdqn.mapper.selectByName","%阳%");

        // 5、循环遍历
        if (employees != null && employees.size() > 0){
            for (Employee emp:employees) {
                System.out.println(emp);
            }
        }

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testSelectByName_2() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("cn.bdqn.mapper.selectByName_2","刘");

        // 5、循环遍历
        if (employees != null && employees.size() > 0){
            for (Employee emp:employees) {
                System.out.println(emp);
            }
        }

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }


    @Test
    public void testSelectByName_3() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("cn.bdqn.mapper.selectByName_3","刘");

        // 5、循环遍历
        if (employees != null && employees.size() > 0){
            for (Employee emp:employees) {
                System.out.println(emp);
            }
        }

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testSelectByName_4() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法查询数据[参数是一个查询id,组成: namespace+id]
        List<Employee> employees = session.selectList("cn.bdqn.mapper.selectByName_4","阳");

        // 5、循环遍历
        if (employees != null && employees.size() > 0){
            for (Employee emp:employees) {
                System.out.println(emp);
            }
        }
        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 插入员工信息
    @Test
    public void testInsert() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法添加员工
        Employee employee = new Employee();
        employee.setEmpName("王浩");
        employee.setAddress("东北葫芦岛");
        employee.setBirthday(new Date());
        employee.setEmail("wanghao@126.com");
        employee.setSex("男");

        session.insert("cn.bdqn.mapper.insert",employee);

        // 5、提交
        session.commit();

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    @Test
    public void testInsertReturnPrimaryKey_1() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法添加员工
        Employee employee = new Employee();
        employee.setEmpName("崔灿");
        employee.setAddress("信阳妖怪府");
        employee.setBirthday(new Date());
        employee.setEmail("cuican@126.com");
        employee.setSex("女");

        session.insert("cn.bdqn.mapper.insertReturnPrimaryKey_1",employee);

        System.out.println("返回的主键id是:   " + employee.getId());

        // 5、提交
        session.commit();

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
    // 插入员工信息
    @Test
    public void testInsertReturnPrimaryKey_2() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法添加员工
        Employee employee = new Employee();
        employee.setEmpName("周安康");
        employee.setAddress("南阳鬼门关");
        employee.setBirthday(new Date());
        employee.setEmail("ankang@126.com");
        employee.setSex("男");

        session.insert("cn.bdqn.mapper.insertReturnPrimaryKey_2",employee);

        System.out.println("返回的主键id是:   " + employee.getId());

        // 5、提交
        session.commit();

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
    // 删除员工
    @Test
    public void testDeleteById() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法删除员工
        session.delete("cn.bdqn.mapper.deleteById",5);

        // 5、提交
        session.commit();

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 更新员工
    @Test
    public void testUpdateById() throws Exception{

        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过SqlSession提供的方法更新员工
        Employee employee = new Employee();
        employee.setId(4);
        employee.setEmpName("王梦瑶");
        employee.setAddress("商丘王家寨");

        session.update("cn.bdqn.mapper.updateById",employee);

        // 5、提交
        session.commit();

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
}