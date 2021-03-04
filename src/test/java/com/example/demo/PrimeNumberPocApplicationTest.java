package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=PrimeNumberPocApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PrimeNumberPocApplicationTest {
	TestRestTemplate restTemplate=new TestRestTemplate();
	
	@LocalServerPort
	private int port;

	@Test
	void testGetPrimeNumbers() {
		String expected="{initial: 10,primes: [2,3,5,7]}";
		ResponseEntity<String> response=restTemplate.exchange(createUrl("/primes/10"), HttpMethod.GET, null, String.class);
		try {
			JSONAssert.assertEquals(expected, response.getBody(), false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private URI createUrl(String api) {
		try {
			return new URI("http://localhost:"+port+api);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

}
