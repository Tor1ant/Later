package com.github.tor1ant.later.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmailContainingIgnoreCase(String emailSearch);

    List<UserShort> findAllByEmailContainingIgnoreCase(String emailSearch);
}