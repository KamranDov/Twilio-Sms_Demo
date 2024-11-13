package org.example.twiliootpdemo.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.twiliootpdemo.config.TwilioConfig;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class OtpService {

    private final TwilioConfig twilioConfig;
    private final Random random = new Random();

    public String generateOTP() {
        return new DecimalFormat("0000").format(random.nextInt(9999));
    }

    public void sendOtpForPhoneNumber(String phoneNumber) {
        log.info("Sending otp to phone number {}", phoneNumber);
        PhoneNumber to = new PhoneNumber(phoneNumber);
        PhoneNumber from = new PhoneNumber(twilioConfig.getTrailNumber());

        String otp = generateOTP();
        MessageCreator creator = Message.creator(to, from, "Your OTP is " + otp);
        creator.create();
        log.info("OTP sent to phone number {}", phoneNumber);


    }

}
