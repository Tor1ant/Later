package com.github.tor1ant.later.user;

import java.util.List;

interface UserRepository {
    List<User> findAll();
    User save(User user);
}