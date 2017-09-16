package me.projects.websocketexample.controller;

import lombok.RequiredArgsConstructor;
import me.projects.websocketexample.entity.MessageEntity;
import me.projects.websocketexample.repository.MessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

    @MessageMapping("/incoming")
    @SendTo("/topic/outgoing")
    public MessageEntity handle(MessageEntity message) {
        messageRepository.save(message);
        return message;
    }
}
