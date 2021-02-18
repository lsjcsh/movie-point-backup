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

    @Autowired
    TicketRepository ticketRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBooked_(@Payload Booked booked){

        if(booked.isMe()){
            System.out.println("======================================");
            System.out.println("##### listener  : " + booked.toJson());
            System.out.println("======================================");
            
            Ticket ticket = new Ticket();
            ticket.setBookingId(booked.getId());
            ticket.setMovieName(booked.getMovieName());
            ticket.setQty(booked.getQty());
            ticket.setSeat(booked.getSeat());
            ticket.setStatus("Waiting");

            ticketRepository.save(ticket);
        }
    }

}
