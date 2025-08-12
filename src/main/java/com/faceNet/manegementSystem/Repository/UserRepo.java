package com.faceNet.manegementSystem.Repository;

import com.faceNet.manegementSystem.Entity.User;

import java.util.List;

/**
 * @author Leo Nguyen
 */
public interface UserRepo {
    List<User> getUser();
}
