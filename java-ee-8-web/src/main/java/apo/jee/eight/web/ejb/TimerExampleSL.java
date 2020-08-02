package apo.jee.eight.web.ejb;

import javax.annotation.Resource;
import javax.ejb.*;

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

    @Schedule(hour = "*", minute = "*", second = "*")
    public void timer() {
        System.out.println("Timer executed");
    }
}
