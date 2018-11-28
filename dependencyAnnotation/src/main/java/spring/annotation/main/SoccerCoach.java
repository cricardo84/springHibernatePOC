package spring.annotation.main;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

	public String getDailyWorkout() {
		return "Practice offensive ABP...!!!";
	}

}
