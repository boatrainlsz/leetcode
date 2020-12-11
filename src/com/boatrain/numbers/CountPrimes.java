package com.boatrain.numbers;

public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        System.out.println(solution.countPrimes(10));
    }

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        //2是质数
        int result = 1;
        for (int i = 3; i < n; i++) {
            boolean isPrime = true;
            if ((i & 1) == 0) {
                //i是2的整数次幂，跳过
                continue;
            }
            for (int j = 3; j * j <= i; j += 2) {
                //j+=2,规避偶数，因为偶数肯定不是质数
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) result++;
        }
        return result;
    }

    /**
     * 厄式筛选
     *
     * @param n
     * @return
     */
    public int countPrimesEeatosthese(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
            for (int j = 2 * i; j < n; j += i) {
                notPrime[j] = true;
            }
        }
        return count;
    }
}
