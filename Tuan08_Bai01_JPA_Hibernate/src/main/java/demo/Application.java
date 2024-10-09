package demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Employee;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Employee emp = context.getBean("emp1", Employee.class);
		
		emp.show();
		
	}

}
