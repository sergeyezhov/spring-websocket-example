package me.projects.websocketexample.repository;

import me.projects.websocketexample.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}
