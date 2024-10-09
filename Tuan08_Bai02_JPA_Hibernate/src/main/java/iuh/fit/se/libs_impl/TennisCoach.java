package iuh.fit.se.libs_impl;

import iuh.fit.se.libs.Coach;
import iuh.fit.se.libs.FortuneService;

public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;

	
	
	/**
	 * @param fortuneService
	 */
	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "TennisCoach: Run a hard 10k";
	}
}
