

package com.tongfu.user.mapper;

import java.util.List;

import com.tongfu.user.entity.User;

public interface UserMapper {

    public User getUser(User user);

    public List<User> getUserList(User user);

    public void saveUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

}
