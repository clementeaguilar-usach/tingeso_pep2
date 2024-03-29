package tingesopep2.acopioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AcopioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcopioServiceApplication.class, args);
	}

}
