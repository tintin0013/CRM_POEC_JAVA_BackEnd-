package com.Certif.SlackLike.repository;

import com.Certif.SlackLike.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {


}
