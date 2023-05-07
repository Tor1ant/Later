package com.github.tor1ant.later.user;

import java.util.List;

interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
}