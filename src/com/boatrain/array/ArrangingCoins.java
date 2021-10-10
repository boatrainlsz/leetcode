package com.boatrain.array;

public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins solution = new ArrangingCoins();
        System.out.println(solution.arrangeCoins(5));
    }

    public int arrangeCoins(int n) {
        int row = 0;
        int remain = n;
        while (true) {
            row++;
            remain = remain - row;
            if (remain < row + 1) {
                break;
            }
        }
        return row;
    }
}