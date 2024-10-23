package com.sms.twilio.TwilioSMSDemo.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    @Value("${twilio.account-sid}")
    private String SID;
    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String senderNumber;

    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() {

        Twilio.init(this.SID, this.authToken);
        Message.creator(new PhoneNumber("To number"),
                new PhoneNumber(senderNumber), "I love you baby!!!").create();
        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }

}
