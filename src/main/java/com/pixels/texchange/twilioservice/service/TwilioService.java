package com.pixels.texchange.twilioservice.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pixels.texchange.twilioservice.config.TwilioConfig;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import reactor.core.publisher.FluxSink;

import java.util.Random;

@Service
@Slf4j
public class TwilioService {

    @Autowired
    TwilioConfig twilioConfig;

    public Flux sendSms(String json) {
            log.info("message recieved {}"+json);
            JSONObject jsonObject = new JSONObject(json);
            Twilio.init(twilioConfig.getId(),
                    twilioConfig.getAuthtoken());

            MessageCreator message = Message.creator(
                    new PhoneNumber(jsonObject.getString("toNumber")),
                    new PhoneNumber(twilioConfig.getTrialno()), "Hi "
                            + "Neeraj"
                            + " your OTP to activate account : " +generateOTP() );

        return Flux.just(message.create());

        }

        private String generateOTP() {
            return String.valueOf(new Random().nextInt(95509));
        }

}
