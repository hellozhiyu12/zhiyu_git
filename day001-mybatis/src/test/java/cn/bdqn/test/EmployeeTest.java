package cn.bdqn.test;

import cn.bdqn.domain.Employee;
import cn.bdqn.mapper.EmployeeMapper;
import cn.bdqn.mapper.EmployeeTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class EmployeeTest {

    // 根据id查询单个员工
    @Test
    public void testQueryById() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryById(2);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 添加员工
    @Test
    public void testSave() throws Exception {
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 5、保存
        Employee employee = new Employee();
        employee.setEmpName("刘泰阳");
        employee.setAddress("山西煤窑山");
        employee.setBirthday(new Date());
        employee.setEmail("taiyang@126.com");
        employee.setSex("女");

        employeeMapper.save(employee);

        // 6、事务提交
        session.commit();

        // 7、关闭SqlSession
        session.close();

        // 8、关闭流
        is.close();
    }

    // 根据员工姓名和性别查询员工
    @Test
    public void testQueryByNameAndSex() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        EmployeeTO employeeTO = new EmployeeTO();
        employeeTO.setEmpName("刘志宇");
        employeeTO.setSex("男");
        Employee employee = employeeMapper.queryByNameAndSex(employeeTO);

        // 5、打印
        System.out.println(employee);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 根据id查询员工信息
    @Test
    public void testQueryEmployeesByName() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> employees = employeeMapper.queryEmployeesByName("%刘%");

        // 5、打印
        if (employees != null){
            for (Employee employee:employees) {
                System.out.println(employee);
            }
        }

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }

    // 根据姓名模糊查询员工信息
    @Test
    public void testQueryByName() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<Integer,Employee> map = employeeMapper.queryByName("%宇%");

        // 5、打印
        System.out.println(map);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }


    @Test
    public void testQueryByCondition() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        // 3、用SqlSessionFactory工厂去创建SqlSession
        SqlSession session = factory.openSession();

        // 4、通过Mapper接口代理的方式去调用Mapper接口中的方法。
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        // 5、查询并输出结果
        Employee employee = new Employee();
        employee.setEmpName("刘");
        employee.setAddress("郑州");
        employee.setSex("男");
        employee.setEmail("liu");
        List<Employee> employees = employeeMapper.queryByCondition(employee);

        // 仅仅是打印部门信息
        System.out.println(employees);

        // 6、关闭SqlSession
        session.close();

        // 7、关闭流
        is.close();
    }
}