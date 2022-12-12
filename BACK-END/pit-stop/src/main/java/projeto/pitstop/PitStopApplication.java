package projeto.pitstop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

					 //ABRE OS ENDPOINTS
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PitStopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PitStopApplication.class, args);
	}

}