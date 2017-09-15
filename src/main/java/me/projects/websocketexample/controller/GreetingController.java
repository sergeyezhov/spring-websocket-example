package me.projects.websocketexample.controller;

import me.projects.websocketexample.model.Greeting;
import me.projects.websocketexample.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) {

        return Greeting.builder()
                .content("Hello, "+ helloMessage.getName() +"!")
                .build();
    }
}
