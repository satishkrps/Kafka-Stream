package com.amrut.prabhu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private StreamBridge streamBridge;

    @Scheduled(cron = "*/2 * * * * *")
    public void sendMessage(){
        streamBridge.send("producer-out-0"," jack from Stream bridge");
    }

    @Scheduled(cron = "*/15 * * * * *")
    public void sendMessageToDLQ(){
        streamBridge.send("producer-out-0","DLQ-MEssages");
    }
}
