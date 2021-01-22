package com.boatrain.interview.microsoft;

/**
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class CompareVersion {
    public static void main(String[] args) {
        CompareVersion solution = new CompareVersion();
        System.out.println(solution.compareVersion("1.0", "1.0.0"));
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int index1 = 0, index2 = 0;
        while (index1 < len1 || index2 < len2) {
            int num1 = index1 < len1 ? Integer.parseInt(arr1[index1]) : 0;
            int num2 = index2 < len2 ? Integer.parseInt(arr2[index2]) : 0;
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            } else {
                index1++;
                index2++;
            }
        }
        return 0;
    }
}
