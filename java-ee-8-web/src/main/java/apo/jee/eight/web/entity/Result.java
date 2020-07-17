package apo.jee.eight.web.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Result")
public class Result {
    @Id
    @SequenceGenerators({ @SequenceGenerator(name = "RESULT_SEQ", sequenceName = "RESULT_SEQ") })
    private long id;

    @Column(name = "DRAW_NUMBER")
    private String drawNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "DRAW_DATE")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "LOTTERY_ID")
    private Lottery lottery;

    public Result(){

    }

    public Result(String drawNumber, Date date, Lottery lottery){

    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getDrawNumber() {
	return drawNumber;
    }

    public void setDrawNumber(String drawNumber) {
	this.drawNumber = drawNumber;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public Lottery getLottery() {
	return lottery;
    }

    public void setLottery(Lottery lottery) {
	this.lottery = lottery;
    }
}
