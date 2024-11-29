package com.example.demo.common.util;

import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static com.example.demo.common.util.PojoUtil.checkObjFieldIsNull;

/**
 * 方法的单测覆盖率
 */
@SpringBootTest
class PojoUtilTest {

    @Test
    void checkObjFieldIsNotNullTest() {
    }

    @Test
    void checkObjFieldIsNullTestIsTrue() {
        User user = new User();
        Assert.isTrue(checkObjFieldIsNull(user));
    }

    @Test
    void checkObjFieldIsNullTestIsFalse() {
        User user = new User();
        user.setUserName("123");
        Assert.isTrue(!checkObjFieldIsNull(user));
    }
}