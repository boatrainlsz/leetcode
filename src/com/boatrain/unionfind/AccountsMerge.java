package com.boatrain.unionfind;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/accounts-merge/
 * 垃圾题目
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        int size = accounts.size();
        HashSet<String>[] sets = new HashSet[size];
        for (int i = 0; i < size; i++) {
            List<String> list = accounts.get(i);
            HashSet<String> temp = new HashSet<>();
            for (int j = 1; j < list.size(); j++) {
                temp.add(list.get(j));
            }
            sets[i] = temp;
        }
        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            List<String> accountI = accounts.get(i);
            for (int j = i + 1; j < size; j++) {
                for (int k = 1; k < accountI.size(); k++) {
                    if (sets[j].contains(accountI.get(k))) {
                        unionFind.unionElements(i, j);
                        break;
                    }
                }
            }
        }
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int rootI = unionFind.find(i);
            if (!map.containsKey(rootI)) {
                HashSet<String> set = new HashSet<>();
                for (int k = 1; k < accounts.get(i).size(); k++) {
                    set.add(accounts.get(i).get(k));
                }
                map.put(rootI, set);
            } else {
                for (int k = 1; k < accounts.get(i).size(); k++) {
                    map.get(rootI).add(accounts.get(i).get(k));
                }
            }
            for (int j = i + 1; j < size; j++) {
                int rootJ = unionFind.find(j);
                if (rootI == rootJ) {
                    if (!map.containsKey(rootI)) {
                        HashSet<String> set = new HashSet<>();
                        for (int k = 1; k < accounts.get(i).size(); k++) {
                            set.add(accounts.get(i).get(k));
                        }
                        for (int k = 1; k < accounts.get(j).size(); k++) {
                            set.add(accounts.get(j).get(k));
                        }
                        map.put(rootI, set);
                    } else {
                        for (int k = 1; k < accounts.get(i).size(); k++) {
                            map.get(rootI).add(accounts.get(i).get(k));
                        }
                        for (int k = 1; k < accounts.get(j).size(); k++) {
                            map.get(rootJ).add(accounts.get(j).get(k));
                        }
                    }
                }
            }
        }
        for (Map.Entry<Integer, HashSet<String>> entry : map.entrySet()) {
            HashSet<String> value = entry.getValue();
            LinkedList<String> list = new LinkedList<>(value);
            Collections.sort(list);
            list.addFirst(accounts.get(entry.getKey()).get(0));
            ans.add(list);
        }
        return ans;
    }

    class UnionFind {

        /**
         * i是元素，parent[i]是元素的父节点
         * i:        0,1,2,3,4,5,6,7,8,9
         * parent[i]:1,1,1,8,3,0,5,1,8,8
         */
        private int[] parent;

        /**
         * rank[i]：以i为根节点的树的层数
         */
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean isConnected(int p, int q) {
            //O(H),H为树的高度
            return find(p) == find(q);
        }

        public int getSize() {
            return parent.length;
        }

        public void unionElements(int p, int q) {
            //O(H)
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                //优化，要考虑pRoot和qRoot这两棵树谁的层数大，小的加到大的上，避免树瘸腿
                if (rank[pRoot] < rank[qRoot]) {
                    //q树更深，注意这里qRoot的层数无需更新！
                    parent[pRoot] = qRoot;
                } else if (rank[pRoot] > rank[qRoot]) {
                    //p树更深
                    parent[qRoot] = pRoot;
                } else {
                    //层数相等
                    parent[qRoot] = pRoot;
                    //注意这里pRoot的层数需要加1
                    rank[pRoot] += 1;
                }
            }
        }

        //查找元素p所在树的顶层根节点，也就是元素p的的集合编号
        //O(H),H为树的高度
        public int find(int p) {
            //路径压缩算法2：孩子变祖先，这个更狠
            //https://www.runoob.com/data-structures/union-find-compress.html
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }
    }
}


