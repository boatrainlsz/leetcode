package com.boatrain.string;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        FindCommonCharacters solution = new FindCommonCharacters();
        String[] arr = new String[]{"cool", "lock", "cook"};
//        String[] arr = new String[]{"bella", "label", "roller"};
        System.out.println(solution.commonChars(arr));
    }

    public List<String> commonChars(String[] A) {
        //存储所有字符串中，字符出现的最小次数
        int[] count = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            //初始为第一个字符串的各字符出现的次数
            count[A[0].charAt(i) - 'a']++;
        }
        for (int j = 1; j < A.length; j++) {
            //从第二个开始比较
            int[] tempCount = new int[26];
            String str = A[j];
            for (int i = 0; i < str.length(); i++) {
                tempCount[str.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                //和count相比
                count[i] = Math.min(tempCount[i], count[i]);
            }
        }
        //最终，得到最小次数的数组，开始构造答案
        String resultStr = "";
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    //根据次数来重复字符
                    resultStr += new String(Character.toChars(i + 'a'));
                }
            }
        }
        System.out.println(resultStr);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < resultStr.length(); i++) {
            result.add(String.valueOf(resultStr.charAt(i)));
        }
        return result;
    }
}
