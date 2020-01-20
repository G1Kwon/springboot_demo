package com.acompany.restapp.dao;

import com.acompany.restapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    public static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(100, "kim"));
        users.add(new User(200, "lee"));
        users.add(new User(300, "choi"));
        users.add(new User(400, "park"));
        users.add(new User(500, "kwon"));
        users.add(new User(600, "hwang"));

        System.out.println(users);
    }

    public Map<String, String> getMessage() {
        Map<String, String> res = new HashMap<>();
        res.put("greet", "Hello world..");

        return res;
    }

    //사용자 전체보기
    public List<User> getAllUsers() {
        System.out.println("사용자 전체보기::Repository..");

        return users;
    }

    //사용자 상세보기
    public User getUserByUserid(Integer userid) {
        System.out.println("사용자 상세보기::Repository.." + userid);

        return users.stream()
                .filter(user -> user.getUserid().equals(userid))
                .findAny()
                .orElse(new User(0, "no user"));
    }

    //사용자 등록
    public User insertUser(User user) {
        System.out.println("사용자 등록::Repository..");

        users.add(user);
        return user;
    }

    //사용자 수정
    public void updateUser(User user) {
        System.out.println("사용자 수정::Repository..");

        users.stream()
                .filter(item -> item.getUserid().equals(user.getUserid()))
                .findAny()
                .orElse(new User(0, "no user"))
                .setUsername(user.getUsername());
    }

    //사용자 삭제
    public void deleteUser(Integer userid) {
        System.out.println("사용자 삭제::Repository..");

        users.removeIf(user -> user.getUserid().equals(userid));
    }

}
