package com.shmily.apiuser.service;

import com.poi.domain.ShyUser;
import com.poi.mapper.ShyUserMapper;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShyUserServiceTest {

    @MockBean
    private ShyUserMapper userMapper;

    @MockBean
    private ShyUserService userService;

    @Test
    void login() {
        ShyUser user = new ShyUser();
        user.setEmail("390157664@qq.com");
        user.setPassword("wangye666");

        ShyUser user2 = userService.login(user);
//        OngoingStubbing<ShyUser> when = Mockito.when(userMapper.login(user));
//        when.thenReturn()
        System.out.println("123");
//        Assert.assertEquals("用户名错误",);
    }

    @Test
    void register() {
    }
}