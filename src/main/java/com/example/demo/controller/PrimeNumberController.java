package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PrimeResponseDto;
import com.example.demo.service.PrimeNumberService;

@RestController
public class PrimeNumberController {
	@Autowired
	PrimeNumberService primeNumberService;

	@GetMapping("/primes/{number}")
	public PrimeResponseDto getPrimeNumbers(@PathVariable(name = "number") int number) {
		System.out.println("Controller layer::");
		PrimeResponseDto responseDto = new PrimeResponseDto();
		List<Integer> list = primeNumberService.getPrimeNumberList(number);
		responseDto.setInitial(number);
		responseDto.setPrimes(list);
		return responseDto;

	}

}
