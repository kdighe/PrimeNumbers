package com.example.demo.dto;

import java.util.List;

public class PrimeResponseDto {
	private int initial;
	private List<Integer> primes;

	public int getInitial() {
		return initial;
	}

	public void setInitial(int initial) {
		this.initial = initial;
	}

	public List<Integer> getPrimes() {
		return primes;
	}

	public void setPrimes(List<Integer> primes) {
		this.primes = primes;
	}

}
