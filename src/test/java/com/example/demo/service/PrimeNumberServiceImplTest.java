package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class PrimeNumberServiceImplTest {

	@Test
	void testPrime() {
		Supplier<PrimeNumberServiceImpl> supplier=PrimeNumberServiceImpl::new;
		List<Integer> expectedList=Arrays.asList(2,3,5,7);
		List<Integer> actualList=supplier.get().getPrimeNumberList(10);
		assertArrayEquals(expectedList.toArray(), actualList.toArray(), "Prime Number Series Contains non-prime numbers");
	}
	
	@Test
	void testIsPrime() {
		assertTrue(PrimeNumberServiceImpl.isPrime(31),"Number is not prime");
	
	}
	
}
