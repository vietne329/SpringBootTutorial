package com.vietmd.springboot.tight_coupled_and_di;

import org.springframework.stereotype.Component;

@Component
public class BubbleSortAlgorithm implements SortAlgorithm{

    @Override
    public int[] sort(int[] numbers) {
        System.out.println("Sorted by quick bubble sort algorithm");
        return numbers;
    }
}
