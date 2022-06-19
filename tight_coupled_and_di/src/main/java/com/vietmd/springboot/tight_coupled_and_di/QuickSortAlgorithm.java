package com.vietmd.springboot.tight_coupled_and_di;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm{
    @Override
    public int[] sort(int[] numbers) {
        System.out.println("Sorted by quick sort algorithm");
        return numbers;
    }
}
