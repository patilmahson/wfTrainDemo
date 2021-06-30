package com.example.wftraining.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;

import com.example.wftraining.domains.Customer;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EmbeddedKafka(topics = {"user-registrations"}, partitions = 3)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
"spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})
public class CustomerControllerIntegrationTest {
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void newUserIntegrationTestShouldReturn201() throws Exception{
		Customer cust = Customer.builder()
				.cID(123)
				.firstName("Dilip")
				.age(27)
				.build();
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", MediaType.APPLICATION_JSON.toString());
		HttpEntity<Customer> request = new HttpEntity<>(cust);
		
		//when
		ResponseEntity<Customer> responseEntity = restTemplate.exchange("/customers", HttpMethod.POST, request, Customer.class);
		//then
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
}
