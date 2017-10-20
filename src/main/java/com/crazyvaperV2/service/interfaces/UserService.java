package com.crazyvaperV2.service.interfaces;

import com.crazyvaperV2.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends IService<User>, UserDetailsService {

    User getByName(String name);
}
