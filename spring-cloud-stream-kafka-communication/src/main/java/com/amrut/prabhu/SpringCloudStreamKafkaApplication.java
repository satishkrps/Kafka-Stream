package com.amrut.prabhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
@EnableScheduling
public class SpringCloudStreamKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamKafkaApplication.class, args);
    }

    @Bean
    public Consumer<String> consumer() {
        return (message)->{
            if(message.equals("DLQ-MEssages")){
                try {
                    throw new Exception("Exception occurred");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Consumed :::: "+message);
            }
        };
    }

    @Bean
    public Supplier<String> producer() {
        return () -> " jack from Streams";
    }
}
