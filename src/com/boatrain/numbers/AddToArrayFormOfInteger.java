package com.boatrain.numbers;
/**
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * 和这题一样的思路 {@link com.boatrain.interview.microsoft.AddTwoNumbers}
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
//    public static void main(String[] args) {
//        AddToArrayFormOfInteger solution = new AddToArrayFormOfInteger();
//        System.out.println(solution.addToArrayForm(new int[]{9,9,9,9}, 1));
//    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        while (K != 0) {
            list.add(K % 10);
            K = K / 10;
        }
//        Collections.reverse(list);
        int carry = 0;
        int index1 = A.length - 1;
        int index2 = 0;
        while (index1 >= 0 || index2 <= list.size() - 1) {
            int adder1 = 0;
            if (index1 >= 0) {
                adder1 = A[index1];
            }
            int adder2 = 0;
            if (index2 <= list.size() - 1) {
                adder2 = list.get(index2);
            }
            int sum = adder1 + adder2 + carry;
            carry = sum / 10;
            ans.add(sum % 10);
            index1--;
            index2++;
            System.out.println(index2);
        }
        if (carry != 0) ans.add(carry);
        Collections.reverse(ans);
        return ans;
    }
}
