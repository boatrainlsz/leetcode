package com.boatrain.numbers;

public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4));
        System.out.println((4)>>1);
        System.out.println(Integer.toBinaryString((4)>>1));
        System.out.println((4)>>>1);
        System.out.println(Integer.toBinaryString((4)>>>1));
        FirstBadVersion firstBadVersion = new FirstBadVersion();
//        System.out.println(firstBadVersion.firstBadVersion(2));
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return mid == 2;
    }

}
