package com.scaler.notificationservice.service;

import com.scaler.notificationservice.model.NotificationMessageRequest;
import com.scaler.notificationservice.model.UsersEntity;
import com.scaler.notificationservice.repository.NotificationUpdateRepository;
import com.scaler.notificationservice.repository.UserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SMSService {

   private final NotificationUpdateRepository notificationUpdateRepository;

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;
    private final UserRepository userRepository;
    @Autowired
    public SMSService(NotificationUpdateRepository notificationUpdateRepository, UserRepository userRepository) {
        this.notificationUpdateRepository = notificationUpdateRepository;
        this.userRepository = userRepository;
    }

    public void sendSMS(String recipient, String phoneNo,String message) {
        Twilio.init(accountSid, authToken);

        Message.creator(
            new PhoneNumber(recipient),
            new PhoneNumber(phoneNo),
            message
        ).create();
        System.out.println("working");
    }

    public void fetchNumberFromDbAndSend(NotificationMessageRequest message) {
        String userName = message.getNotifiedUser();
        UsersEntity user = userRepository.findByUsername(userName);
        String phNo="";
        if(Objects.nonNull(user)) {
            phNo = user.getPhone_number();
        }

       String body= "PrevState:" + message.getPrevState() + "NewState:" +message.getNewState() + "UpdatedBy:" + message.getUpdatedBy();
        sendSMS("+919872876671",twilioPhoneNumber,body);
    }
}
