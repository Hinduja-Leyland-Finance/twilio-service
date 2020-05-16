package com.pixels.texchange.twilioservice.controller;

import com.pixels.texchange.twilioservice.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/twilio/v1")
@CrossOrigin
public class TwilioSmsController {
    @Autowired
    TwilioService twilioService;

    @PostMapping(value = "/send",consumes="application/json")
    public Flux sendSms(@RequestBody String messageJson){
        return twilioService.sendSms(messageJson);
    }

    @PostMapping(value = "/sendAll",consumes="application/json")
    public Mono sendSmsAll(@RequestBody String messageJson){
        return twilioService.sendSmstoAll(messageJson);
    }
}
