package com.example.wftraining.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.wftraining.domains.Account;
import com.example.wftraining.domains.Customer;
import com.example.wftraining.domains.Profile;
import com.example.wftraining.domains.User;
import com.example.wftraining.services.ProfileService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ProfileControllerIntegrationTest {
	@Mock
    ProfileService profileService;

    
    @InjectMocks
    ProfileController controller;

	@Test
	public void getProfileIntegrationTest() throws Exception{
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
				.acclist(acclist)
				.canEmail('y')
				.phoneNo("8043035342")
				.profileId(1L)
				.user(user)
				.build();
		
		Profile mockProfile = profile;

		
		
		Mockito.when(
                profileService.getProfile(Mockito.anyLong())).thenReturn(profile);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Profile response = controller.getProfile(1l);

        System.out.println(response);
        
        assertThat(response.getProfileId()).isEqualTo(1);
       
	}
}
