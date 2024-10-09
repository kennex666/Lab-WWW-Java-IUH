package app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.libs_impl.BaseballCoach;
import iuh.fit.se.libs_impl.CriketCoach;
import iuh.fit.se.libs_impl.HappyFortuneService;
import iuh.fit.se.libs_impl.TennisCoach;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BaseballCoach bc = context.getBean("basecoach", BaseballCoach.class);
		
		System.out.println("Baseball: ");
		System.out.println("Baseball Workout: " + bc.getDailyWorkout());
		System.out.println("Baseball Fortune: " + bc.getDailyFortune());
		
		CriketCoach cc = context.getBean("criketCoach", CriketCoach.class);

		System.out.println("Criket: ");
		System.out.println("Criket Workout: " + cc.getDailyWorkout());
		System.out.println("Criket Fortune: " + cc.getDailyFortune());
		
		TennisCoach tc = context.getBean("tennisCoach", TennisCoach.class);
		
		System.out.println("Tennis:");
		System.out.println("Tennis workout: " + tc.getDailyWorkout());
		System.out.println("Tennis fortune: " + tc.getDailyFortune());
		
		
	}

}
