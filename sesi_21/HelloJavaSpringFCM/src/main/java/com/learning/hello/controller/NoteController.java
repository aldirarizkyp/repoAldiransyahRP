package com.learning.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.learning.hello.pojo.Note;
import com.learning.hello.service.FirebaseMessagingService;

@Controller
public class NoteController {

    private final FirebaseMessagingService firebaseService;

    public NoteController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody Note note,
                                   @RequestParam String topic) throws FirebaseMessagingException {
        return firebaseService.sendNotification(note, topic);
    }
}