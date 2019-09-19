package org.janchi.tests.hibernate.batchfetching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAutoConfiguration
@Component
public class BatchFetchingTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchFetchingTestApplication.class, args);
	}

}
