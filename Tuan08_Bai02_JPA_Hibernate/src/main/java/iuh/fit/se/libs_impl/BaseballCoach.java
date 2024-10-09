package iuh.fit.se.libs_impl;

import iuh.fit.se.libs.Coach;
import iuh.fit.se.libs.FortuneService;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	/**
	 * @param fortuneService
	 */
	public BaseballCoach(FortuneService fortuneService) {
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
		return "Spend 30 minutes on batting pratice";
	}
}
