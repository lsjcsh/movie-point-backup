package movie;

import movie.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceled_(@Payload Canceled canceled){

        if(canceled.isMe()){
            System.out.println("##### listener  : " + canceled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBooked_(@Payload Booked booked){

        if(booked.isMe()){
            System.out.println("##### listener  : " + booked.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPrinted_(@Payload Printed printed){

        if(printed.isMe()){
            System.out.println("##### listener  : " + printed.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaid_(@Payload Paid paid){

        if(paid.isMe()){
            System.out.println("##### listener  : " + paid.toJson());
        }
    }

}
