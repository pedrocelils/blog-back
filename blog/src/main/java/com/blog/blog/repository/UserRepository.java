package com.blog.blog.repository;

import com.blog.blog.entities.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Id> {
}
