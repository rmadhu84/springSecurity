package com.madhu.springsecurityjpa.repository;

import java.util.Optional;

import com.madhu.springsecurityjpa.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String user);
}
