package apo.jee.eight.web.cdi;

import apo.jee.eight.web.ejb.ResultSL;
import apo.jee.eight.web.entity.Lottery;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.List;

@ViewScoped
@Named
public class ResultBean implements Serializable {

    private String filePath;

    private Lottery lottery;

    @EJB
    private ResultSL resultSL;

    public void loadResults() {
	if (lottery.getName().contains("PickFour")) {
	    resultSL.loadPickFourResults(Paths.get(filePath));
	}
    }

    public void setFilePath(String filePath) {
	this.filePath = filePath;
    }

    public Lottery getLottery() {
	return lottery;
    }

    public void setLottery(Lottery lottery) {
	this.lottery = lottery;
    }

    public List<Lottery> getLotteries() {
	return resultSL.getLotteries();
    }
}
