package com.acompany.restapp.dao;

import com.acompany.restapp.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    //모든 테스트 케이스는 void로 작성한다.
    public void testGetAllUsers() {

        List<User> res = userRepository.getAllUsers();

        //사이즈가 0보다 크면 통과시키겠다.
        Assert.assertTrue(res.size() > 0);
    }

    @Test
    public void testGetUserByUserid() {

        Integer userid = 100;
        User res = userRepository.getUserByUserid(userid);

        //리턴된 값이 Null이 아니면 통과시키겠다.
        Assert.assertNotNull(res);
    }



}
