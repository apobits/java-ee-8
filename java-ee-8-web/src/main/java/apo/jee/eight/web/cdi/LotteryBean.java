package apo.jee.eight.web.cdi;

import apo.jee.eight.web.ejb.CRUDSL;
import apo.jee.eight.web.entity.Lottery;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Named
public class LotteryBean implements Serializable {

    private final String title = "Lottery Page";

    @EJB
    private CRUDSL<Lottery> crudsl;

    private Lottery lottery;

    private List<Lottery> lotteryList;

    @PostConstruct
    private void initialize() {
	lottery = new Lottery();
	lotteryList = new ArrayList<>();
    }

    public void save() {
	crudsl.save(lottery);
    }

    public Lottery getLottery() {
	return lottery;
    }

    public void setLottery(Lottery lottery) {
	this.lottery = lottery;
    }

    public List<Lottery> getLotteryList() {
	return lotteryList;
    }

    public void setLotteryList(List<Lottery> lotteryList) {
	this.lotteryList = lotteryList;
    }

    public String getTitle() {
	return title;
    }
}
