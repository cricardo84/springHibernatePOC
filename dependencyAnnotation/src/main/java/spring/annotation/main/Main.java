package spring.annotation.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		System.out.println(context.getBeanDefinitionNames()[0]);
		System.out.println(context.getBeanDefinitionNames()[1]);
		Coach myCurrentCoach = context.getBean("myRunningCoach", Coach.class);
		
		System.out.println("My current workout is: " + myCurrentCoach.getDailyWorkout());
		
		System.out.println("1");
		
		System.out.println("2");
		
		System.out.println("3");
		
		System.out.println("4");
		
		

		context.close();
	}

}
