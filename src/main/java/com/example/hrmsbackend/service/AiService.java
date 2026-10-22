package com.example.hrmsbackend.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class AiService {

    private final ChatClient chatClient;

    public AiService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                    You are an HRMS assistant.
                    Answer clearly and concisely.
                    Do not invent employee records.
                    """)
                .build();
    }

    public Flux<String> ask(String question) {
        return chatClient.prompt()
                .user(question)
                .stream()
                .content();
    }

}
