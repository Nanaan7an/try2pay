package com.example.demo;

import com.example.demo.pojo.Order;
import com.example.demo.pojo.Pay;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    Order order;

    @Autowired
    Pay pay;

    @Autowired
    User user;


    //    注入数据库配置
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
//        获得数据库连接，方可执行后续操作；详见Connection中的方法；最后需要关闭连接
        Connection connection = dataSource.getConnection();
//获取数据源信息
        dataSource.getClass();
        connection.close();

    }

}
