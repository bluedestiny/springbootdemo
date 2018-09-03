package com.example.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.User;
@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
	User findByName(String name);
}
