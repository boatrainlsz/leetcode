package com.boatrain.lookuptable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        System.out.println(solution.isHappy(12));
    }

    /**
     * 用hashset
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            System.out.println(set);
            if (!set.add(n)) {
                return false;
            }
            n = square(n);
        }
        return true;
    }

    /**
     * 用快慢指针法
     *
     * @param n
     * @return
     */
//    public boolean isHappy(int n) {
//        int fast = n;
//        int slow = n;
//        do {
//            //快指针转换两次
//            //慢指针转换一次
//            fast = square(square(fast));
//            System.out.println(fast);
//            slow = square(slow);
//            System.out.println(slow);
//        } while (fast != slow);
//        //最后在1相遇，则是快乐数，否则不是快乐数
//        return slow == 1;
//    }

    /**
     * 计算n各位数字的平方和
     *
     * @param n
     * @return
     */
    private int square(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
