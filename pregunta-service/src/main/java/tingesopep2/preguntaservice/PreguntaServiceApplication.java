package tingesopep2.preguntaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PreguntaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreguntaServiceApplication.class, args);
	}

}
