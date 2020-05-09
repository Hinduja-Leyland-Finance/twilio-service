package com.pixels.texchange.twilioservice.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:twilio.properties")
@ConfigurationProperties(prefix = "sms.acc")
@Data
public class TwilioConfig {
    String authtoken;
    String id;
    String trialno;
}
