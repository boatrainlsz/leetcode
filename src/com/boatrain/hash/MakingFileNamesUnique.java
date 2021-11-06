package com.boatrain.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MakingFileNamesUnique {
    public static void main(String[] args) {
        MakingFileNamesUnique soluiton = new MakingFileNamesUnique();
        String[] names = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        System.out.println(Arrays.toString(soluiton.getFolderNames(names)));
    }

    HashMap<String, Integer> map = new HashMap<>();

    public String[] getFolderNames(String[] names) {
        List<String> ans = new ArrayList<>();
        for (String name : names) {
            if (!map.containsKey(name)) {
                map.merge(name, 1, Integer::sum);
                ans.add(name);
            } else {
                for (int i = 1; i < 50000; i++) {
                    Integer cnt = map.get(name);
                    String newName = name + "(" + i + ")";
                    if (!map.containsKey(newName)) {
                        ans.add(newName);
                        map.merge(name, 1, Integer::sum);
                        break;
                    }
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}
