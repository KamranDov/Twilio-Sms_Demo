package org.example.twiliootpdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.twiliootpdemo.service.OtpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;

    @PostMapping(path = "/send/{phoneNumber}")
    public ResponseEntity<String> sendOtp(@PathVariable String phoneNumber) {
        otpService.sendOtpForPhoneNumber(phoneNumber);
        return ResponseEntity.accepted().body("OTP sent to phone number " + phoneNumber);
    }
}
