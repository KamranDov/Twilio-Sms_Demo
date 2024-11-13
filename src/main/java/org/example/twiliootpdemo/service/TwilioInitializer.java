package org.example.twiliootpdemo.service;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.twiliootpdemo.config.TwilioConfig;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TwilioInitializer {

    private final TwilioConfig twilioConfig;

        @PostConstruct
    public void initTwilio() {
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
        log.info("Twilio initialized... with accountSid {} ", twilioConfig.getAccountSid());
    }
}
