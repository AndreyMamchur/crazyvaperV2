package com.crazyvaperV2.dao;

import com.crazyvaperV2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findById(long id);

    User findByName(String name);

    User findByEmail(String login);
}
