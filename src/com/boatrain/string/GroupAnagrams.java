package com.boatrain.string;

import java.util.*;
import java.util.function.BiFunction;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        System.out.println(solution.groupAnagramsBest(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * 本菜鸡的做法，暴力
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Character, Integer>[] array = new HashMap[strs.length];
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : chars) {
                map.merge(c, 1, Integer::sum);
            }
            array[i] = map;
        }
        boolean[] classified = new boolean[strs.length];
        for (int i = 0; i < array.length; i++) {
            if (!classified[i]) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                classified[i] = true;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i].size() == array[j].size()) {
                        HashMap<Character, Integer> map = array[i];
                        boolean isSame = true;
                        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                            if (!entry.getValue().equals(array[j].get(entry.getKey()))) {
                                isSame = false;
                                break;
                            }
                        }
                        if (isSame) {
                            list.add(strs[j]);
                            classified[j] = true;
                        }
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    public List<List<String>> groupAnagramsBest(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            //排序后， eat和tea都变成了aet，都是一个key
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
