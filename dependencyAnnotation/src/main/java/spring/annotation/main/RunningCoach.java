package spring.annotation.main;

import org.springframework.stereotype.Component;

@Component("myRunningCoach")
public class RunningCoach implements Coach {

	public String getDailyWorkout() {
		return "Run 5k...!!!";
	}

}
