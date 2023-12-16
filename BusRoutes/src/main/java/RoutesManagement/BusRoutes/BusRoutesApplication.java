package RoutesManagement.BusRoutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "RoutesManagement.BusRoutes.*")
public class BusRoutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusRoutesApplication.class, args);
	}

}
