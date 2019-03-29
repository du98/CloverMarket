package com.syc.user_dao;

import com.syc.user_entity.User;

public interface UserDao {
void ins(User user);
void reg(Integer id,String username,String password);
}
