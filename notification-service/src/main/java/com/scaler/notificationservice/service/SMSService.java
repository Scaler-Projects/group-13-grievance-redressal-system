package com.scaler.notificationservice.service;

import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.repository.NotificationUpdateRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSService {
    @Autowired
    NotificationUpdateRepository notificationUpdateRepository;

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    public void sendSMS(String recipient, String message,String phoneNo) {
        Twilio.init(accountSid, authToken);

        Message.creator(
            new PhoneNumber(recipient),
            new PhoneNumber(phoneNo),
            message
        ).create();
    }

    public void fetchNumberFromDbAndSend() {
        // TODO Call Grievence Service to fetch current grivence_id using Rest or Feing
        NotificationMessageRequest message = new NotificationMessageRequest();
        int grievanceId = message.getGrievance_id();
        String email=notificationUpdateRepository.findEmailByGrievanceId(grievanceId);
        String prev_state = null;
        String new_state = null;
        String updated_by=null;

        Object[] result=notificationUpdateRepository.findFieldsByGrievanceId(grievanceId);
        if (result != null && result.length == 3) {
            prev_state = (String) result[0];
            new_state = (String) result[1];
            updated_by = (String) result[2];
        }
        String messageBody=prev_state + " " +new_state +" "+ updated_by;
        sendSMS(email,messageBody,twilioPhoneNumber);
    }
}
