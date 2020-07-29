package apo.jee.eight.web.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class TimerExampleSL {

    @Resource
    TimerService timerService;

    public void startTimer() {
	timerService.createTimer(5000, "TimerOne");
    }

    public void stopTimer() {
	timerService.getAllTimers().forEach(t -> t.cancel());
    }

    @Timeout
    public void timeout(Timer timer) {
	System.out.println("\n*******************************************************************************\n" + timer
			.getInfo()
			+ "\n*******************************************************************************\n");
    }
}
