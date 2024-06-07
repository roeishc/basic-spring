package com.handson.basic.controller;

import com.handson.basic.model.EmailIn;
import com.handson.basic.util.EmailServiceSendGrid;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/email")
public class EmailController {

    @Autowired
    private EmailServiceSendGrid emailServiceSendGrid;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> email(@RequestBody EmailIn emailIn){
        Response response = emailServiceSendGrid.send(emailIn.getSubject(), emailIn.getToAddress(),
                emailIn.getContent());
        return new ResponseEntity<>(
                "Sending email... It may take a short while to arrive :)\n" + response.getBody(),
                HttpStatus.OK);
    }

}
