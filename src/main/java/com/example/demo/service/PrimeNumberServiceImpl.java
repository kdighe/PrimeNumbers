package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	@Override
	public List<Integer> getPrimeNumberList(int number) {
		return IntStream.rangeClosed(2, number)
				.filter(PrimeNumberServiceImpl::isPrime)
				.boxed()
				.collect(Collectors.toList());
	}
	
	public static boolean isPrime(int n) {
		int sqrt=Double.valueOf(Math.sqrt(n)).intValue();
		return  IntStream.rangeClosed(2, sqrt).noneMatch(i -> n % i == 0);
	}

}
