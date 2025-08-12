package com.faceNet.manegementSystem.Repository.jpa;

import com.faceNet.manegementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Leo Nguyen
 */
@Repository
public interface UserJpa extends JpaRepository<User, Long> {
}
