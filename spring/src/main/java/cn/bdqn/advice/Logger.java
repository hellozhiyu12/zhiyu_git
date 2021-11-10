package cn.bdqn.advice;

// 定义记录日志的类,这个类就封装了我们所有的公共的代码
public class Logger {

    //  该方法的作用是在切入点方法执行之前执行
    public void beforePrintLog(){
        System.out.println("开始打印日志啦");
    }
}