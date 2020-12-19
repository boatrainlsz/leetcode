package com.boatrain.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    int data[] = {1, 2, 3};
    int num = 0;
    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Permutation().Perm(0, 2));
    }

    public List<List<Integer>> permute(int[] nums) {
        data = nums;
        Perm(0, nums.length - 1);
        System.out.println(res);
        return res;
    }

    void Swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    int Perm(int begin, int end) {
        if (begin == end) {
            System.out.println(Arrays.toString(data));
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < data.length; j++) {
                list.add(data[j]);
            }
            res.add(list);
            num++;
        } else {
            for (int i = begin; i <= end; i++) {
                Swap(begin, i);
                Perm(begin + 1, end);
                Swap(begin, i);
            }

        }
        return num;
    }
}
