package com.boatrain.string;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/making-file-names-unique/
 */
public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        HashSet<String> existedNames = new HashSet<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String temp = names[i];
            int suffix = 1;
            while (existedNames.contains(temp)) {
                temp = names[i] + "(" + suffix + ")";
                suffix++;
            }
            existedNames.add(temp);
            ans[i] = temp;
        }
        return ans;
    }
}