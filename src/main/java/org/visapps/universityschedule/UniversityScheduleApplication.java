package org.visapps.universityschedule;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UniversityScheduleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new
				SpringApplicationBuilder(UniversityScheduleApplication.class)
				.properties("spring.config.name:application,local")
				.build()
				.run(args);
	}

}
