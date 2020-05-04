package com.bridgelabz.greetingappapi.repository;

import com.bridgelabz.greetingappapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
