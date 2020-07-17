package apo.jee.eight.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "LOTTERY")
public class Lottery {
    @Id
    @SequenceGenerators({ @SequenceGenerator(name = "LOTTERY_SEQ", sequenceName = "LOTTERY_SEQ") })
    private long id;

    private String name;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
