package com.example.demo.controllers;

import com.example.demo.payload.response.MessageResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
public class MainController {

    @GetMapping("/all")
    public MessageResponse allAccess() {
        return new MessageResponse("Public Content!");
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public MessageResponse userAccess() {
        return new MessageResponse("User Content!");
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public MessageResponse moderatorAccess() {
        return new MessageResponse("Moderator Board!");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public MessageResponse adminAccess() {
        return new MessageResponse("Admin Board!");
    }
}