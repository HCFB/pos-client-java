package ru.homecredit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableEntityLinks
public class PosOnlineClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosOnlineClientApplication.class, args);
	}
}
