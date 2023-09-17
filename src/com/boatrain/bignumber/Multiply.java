package com.boatrain.bignumber;

/**
 * <a href="https://leetcode.cn/problems/multiply-strings/submissions/">...</a>
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        String ans = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            //num1整体和num2的每位逐位相乘
            String mul = multiply0(num1, num2.charAt(i));
            //相乘的结果再乘以10^i，如个位乘以1，十位乘以10
            mul += "0".repeat(num2.length() - i - 1);
            //然后再把每位相乘的结果相加
            ans = add(ans.toCharArray(), mul.toCharArray());
        }
        StringBuilder result = new StringBuilder();
        if (ans.length() > 1) {
            //去掉前导0
            int i = 0;
            while (ans.charAt(i) == '0') {
                if (i == ans.length() - 1) {
                    break;
                }
                i++;
            }
            result.append(ans.substring(i));
        } else {
            return ans;
        }
        return result.toString();
    }

    /**
     * 大数乘一个小数，如 1234568987654321234567897654321 * 6
     * @param num1 大数
     * @param b 小数
     * @return
     */
    private String multiply0(String num1, char b) {
        int num2 = char2Int(b);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length();
        while (i > 0) {
            i--;
            int mul = char2Int(num1.charAt(i)) * num2;
            sb.insert(0, (carry + mul) % 10);
            carry = (carry + mul) / 10;
        }
        if (carry != 0) sb.insert(0, carry);
        return sb.toString();
    }

    /**
     * 两个大数的加法，如：1234567898765432123456789 + 1234567898765432123456789
     * @param a 大数
     * @param b 大数
     * @return
     */
    public String add(char[] a, char[] b) {
        if (a.length == 0) return new String(b);
        if (b.length == 0) return new String(a);
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = a.length, j = b.length;
        while (i > 0 || j > 0) {
            i--;
            j--;
            int sum = (i < 0 ? 0 : char2Int(a[i]))
                    + (j < 0 ? 0 : char2Int(b[j])) + carry;
            ans.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) ans.insert(0, carry);
        return ans.toString();
    }

    private static int char2Int(char c) {
        return c - '0';
    }
}
