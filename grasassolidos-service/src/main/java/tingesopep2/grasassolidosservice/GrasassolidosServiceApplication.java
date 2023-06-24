package tingesopep2.grasassolidosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GrasassolidosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrasassolidosServiceApplication.class, args);
	}

}
