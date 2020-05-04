package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingappapi.dto.Userdto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userdto, Long> {
}
