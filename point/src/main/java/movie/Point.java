package movie;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Point_table")
public class Point {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long bookingId;
    private Integer score;
    private String contents;
    private String status;

    @PostPersist
    public void onPostPersist(){
        WaitedPoint waitedPoint = new WaitedPoint();
        BeanUtils.copyProperties(this, waitedPoint);
        waitedPoint.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        WrittenPoint writtenPoint = new WrittenPoint();
        BeanUtils.copyProperties(this, writtenPoint);
        writtenPoint.setStatus("Updated Point");
        writtenPoint.publishAfterCommit();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
