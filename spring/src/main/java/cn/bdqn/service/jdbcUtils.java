package cn.bdqn.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("jdbcUtils")
class JdbcUtils {

    @Value("${driverClass}")
    private String driverClass;

    @Value("${port}")
    private Integer port;
}
