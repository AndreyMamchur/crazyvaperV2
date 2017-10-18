package com.crazyvaperV2.service.interfaces;

import com.crazyvaperV2.entity.User;

public interface UserService extends IService<User> {

    User getByName(String name);
}
