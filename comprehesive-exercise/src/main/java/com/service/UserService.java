package com.service;


import com.entity.User;
import com.mapper.UserMapper;
import com.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @Author 沈永康
 * @Date 2022/2/28 16:09
 * @Version 1.0
 */


public class UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户对象
     */
    public User login(String username, String password) {
        // 2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 3. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4. 调用方法
        User user = mapper.findUser(username, password);
        // 5. 释放资源
        sqlSession.close();
        return user;
    }


    /**
     * 注册方法
     *
     * @param user 注册用户对象
     * @return 是否成功
     */

    public boolean register(User user) {
        //1. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //2. 获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3. 判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if (u == null) {
            // 用户名不存在，注册
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return u == null;
    }
}