package com.boatrain.sword2offer;

import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        return IntStream.range(1, (int) Math.pow(10, n)).toArray();
    }
}