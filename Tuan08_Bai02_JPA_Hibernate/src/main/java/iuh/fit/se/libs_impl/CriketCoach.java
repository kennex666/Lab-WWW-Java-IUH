package iuh.fit.se.libs_impl;

import iuh.fit.se.libs.Coach;
import iuh.fit.se.libs.FortuneService;

public class CriketCoach implements Coach{
	
	private String email;
	
	private String team;

	private FortuneService fs; 
	
	
	public FortuneService getFs() {
		return fs;
	}

	
	public void setFs(FortuneService fs) {
		this.fs = fs;
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fs.getFortune();
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Let's workout for Criket@!";
	}


	/**
	 * 
	 */
	public CriketCoach() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
