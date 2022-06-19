package com.vietmd.springboot.tight_coupled_and_di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TightCoupledAndDiApplication {
	public static void main(String[] args) {
		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		int result = binarySearch.BinarySearch(new int[] {12,4},3);
		System.out.println(result);

		SpringApplication.run(TightCoupledAndDiApplication.class, args);
	}

}
