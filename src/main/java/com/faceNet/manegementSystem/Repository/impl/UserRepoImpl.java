package com.faceNet.manegementSystem.Repository.impl;

import com.faceNet.manegementSystem.Entity.User;
import com.faceNet.manegementSystem.Repository.UserRepo;
import com.faceNet.manegementSystem.Repository.jpa.UserJpa;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Leo Nguyen
 */
@Component
public class UserRepoImpl implements UserRepo {
    private final UserJpa userJpa;

    public UserRepoImpl(UserJpa userJpa) {
        this.userJpa = userJpa;
    }

    @Override
    public List<User> getUser() {
        return userJpa.findAll();
    }
}
