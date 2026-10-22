package com.example.hrmsbackend.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import com.example.hrmsbackend.service.EmployeeTools;



@Service
public class AiService {

    private final ChatClient chatClient;
    private final EmployeeTools employeeTools;

    public AiService(ChatClient.Builder builder, EmployeeTools employeeTools) {
        this.chatClient = builder
                .defaultSystem("""
                    You are an HRMS assistant.
                    Answer clearly and concisely.
                    Do not invent employee records.
                    """)
                .build();

        this.employeeTools = employeeTools;
    }

    public Flux<String> ask(String question) {
        return chatClient.prompt()
                .user(question)
                .tools(employeeTools)
                .stream()
                .content();
    }

}
