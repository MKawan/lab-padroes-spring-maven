package one.digitalinovation.labpadroesspringmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LabPadroesSpringMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesSpringMavenApplication.class, args);
	}
	
}
