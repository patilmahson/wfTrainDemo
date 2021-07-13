package com.example.wftraining.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.example.wftraining.domains.Account;
import com.example.wftraining.domains.Profile;
import com.example.wftraining.domains.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@EmbeddedKafka(topics = {"user-registrations"}, partitions = 3)
//@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
//"spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})
public class ProfileControllerUnitTest {

	@Autowired
	private ProfileController controller;
	
	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	
	@Test
    void postProfileEventReturnOk() throws Exception {
		Account acc1 = Account.builder()
				.accNo("12345")
				.accType("saving")
				.balance(10.5)
				.expDate(new Date())
				.build();
		
		Account acc2 = Account.builder()
				.accNo("123456")
				.accType("checking")
				.balance(11.5)
				.expDate(new Date())
				.build();
		
		User  user = User.builder()
				.email("1@1.com")
				.firstName("john")
				.lastName("doe")
				.password("xyz")
				.build();
		
		List<Account> acclist = new ArrayList<>();
		acclist.add(acc1);
		acclist.add(acc2);
		
		Profile profile = Profile.builder()
				.user(user)
				.acclist(acclist)
				.canEmail('y')
				.phoneNo("8043035342")
				.profileId(1L)
				.build();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", MediaType.APPLICATION_JSON.toString());
		HttpEntity<Profile> request = new HttpEntity<>(profile);

        String json = objectMapper.writeValueAsString(profile);

        //when
        mockMvc.perform(post("/Profiles")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

       
    }
	
	
}
