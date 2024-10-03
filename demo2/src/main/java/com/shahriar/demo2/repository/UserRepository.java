package com.shahriar.demo2.repository;

import com.shahriar.demo2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
