package com.aplication.controller;

import com.aplication.controller.dto.MessageRequestDTO;
import com.aplication.controller.dto.MessageResponseDTO;
import com.aplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public Long createMessage(@RequestBody MessageRequestDTO messageRequestDTO) {
        return messageService.save(
                messageRequestDTO.getDate(),
                messageRequestDTO.getMessage(),
                messageRequestDTO.getAccountId(),
                messageRequestDTO.getAccountFullName()
        );
    }

    @GetMapping("/messages/{messageId}")
    public MessageResponseDTO getMessageById(@PathVariable Long messageId) {
        return new MessageResponseDTO(messageService.getById(messageId));
    }

    @DeleteMapping("/messages/{messageId}")
    public void deleteMessage(@PathVariable Long messageId) {
        messageService.deleteById(messageId);
    }
}
