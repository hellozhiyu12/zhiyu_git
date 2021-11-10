package cn.bdqn.mapper;

import cn.bdqn.domain.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

// Employee的Mapper接口
public interface EmployeeMapper {

    // 根据员工名和性别查询员工
    //public Employee queryByNameAndSex(String empName, String sex);
    //public Employee queryByNameAndSex(@Param("empName") String empName, @Param("sex") String sex);
    //public Employee queryByNameAndSex(Employee employee);使用JavaBean方式传参
    //public Employee queryByNameAndSex(Map<String,Object> params);使用Map方式传参
    public Employee queryByNameAndSex(EmployeeTO employeeTO);//使用TO方式传参

    // 根据id查询员工
    // public Employee queryById(Integer id);
    //public Employee queryByIds(List<Integer> ids);使用List方式传参
    //public Employee queryByIds(Integer[] ids);//使用数组方式传参
    // 根据员工id查询员工信息，返回值是一个Map
    public Employee queryById(Integer id);
    //public Employee queryById(Integer id);自定义高级映射
    // 添加员工
    public void save(Employee employee);

    // 根据员工姓名查询所有员工
    public List<Employee> queryEmployeesByName(String empName);
    // 根据姓名模糊查询员工列表，返回的值是一个List<Map<String,Object>>
    //public List<Map<String,Object>> queryByName(String empName);

    // 根据姓名模糊查询员工列表，返回的值是一个Map<Integer,Employee>
    // Map的key是这条记录的主键，值是记录封装后的Employee对象
    // @MapKey:告诉mybatis封装这个map的时候使用哪个属性作为map的key
    @MapKey("id")
    public Map<Integer,Employee> queryByName(String empName);


    // 根据员工姓名、邮箱、家庭住址、性别模糊查询员工信息
    public List<Employee> queryByCondition(Employee employee);

    // 根据员工id更新员工信息【可能更新全部字段或者更新部分字段】
    public void updateById(Employee employee);

    // 根据员工id列表查询员工信息
    public List<Employee> queryByIds(Integer[] ids);

    // 批量保存员工
    public void insertBatch(@Param("employees") List<Employee> employees);

}