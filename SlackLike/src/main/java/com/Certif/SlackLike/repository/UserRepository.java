package com.Certif.SlackLike.repository;

import com.Certif.SlackLike.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
