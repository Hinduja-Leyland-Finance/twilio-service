package com.pixels.texchange.twilioservice.controller;

import com.pixels.texchange.twilioservice.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/twilio/v1")
public class TwilioSmsController {
    @Autowired
    TwilioService twilioService;

    @PostMapping(value = "/send",consumes="application/json")
    public Flux sendSms(@RequestBody String messageJson){
        return twilioService.sendSms(messageJson);
    }
}
