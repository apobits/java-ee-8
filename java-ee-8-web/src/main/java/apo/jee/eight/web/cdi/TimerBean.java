package apo.jee.eight.web.cdi;

import apo.jee.eight.web.ejb.TimerExampleSL;

import javax.ejb.EJB;
import javax.inject.Named;

@Named
public class TimerBean {

    @EJB
    private TimerExampleSL timerExampleSL;

    public void startTimer() {
	timerExampleSL.startTimer();
    }

    public void stopTimer() {
	timerExampleSL.stopTimer();
    }
}
