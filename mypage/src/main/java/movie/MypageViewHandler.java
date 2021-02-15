package movie;

import movie.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {


    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBooked_then_CREATE_1 (@Payload Booked booked) {
        try {
            if (booked.isMe()) {
                // view 객체 생성
                  = new ();
                // view 객체에 이벤트의 Value 를 set 함
                .setId(.getId());
                .setQty(.getQty());
                .setMovieName(.getMovieName());
                .setSeat(.getSeat());
                .setPrice(.getTotalPrice());
                // view 레파지 토리에 save
                Repository.save();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_1(@Payload Canceled canceled) {
        try {
            if (canceled.isMe()) {
                // view 객체 조회
                Optional<> Optional = Repository.findById(.getId());
                if( Optional.isPresent()) {
                      = Optional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaid_then_UPDATE_2(@Payload Paid paid) {
        try {
            if (paid.isMe()) {
                // view 객체 조회
                Optional<> Optional = Repository.findById(.getBookingId());
                if( Optional.isPresent()) {
                      = Optional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_3(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (paymentCanceled.isMe()) {
                // view 객체 조회
                Optional<> Optional = Repository.findById(.getBookingId());
                if( Optional.isPresent()) {
                      = Optional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCreated_then_UPDATE_4(@Payload Created created) {
        try {
            if (created.isMe()) {
                // view 객체 조회
                Optional<> Optional = Repository.findById(.getBookingId());
                if( Optional.isPresent()) {
                      = Optional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    // view 레파지 토리에 save
                    Repository.save();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPrinted_then_DELETE_1(@Payload Printed printed) {
        try {
            if (printed.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                Repository.deleteById(.getBookingId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}