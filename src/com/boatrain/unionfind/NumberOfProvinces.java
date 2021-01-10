package com.boatrain.unionfind;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] isConnected = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
//        int[][] isConnected = new int[][]{
//                {1, 1, 0},
//                {1, 1, 0},
//                {0, 0, 1}
//        };
        System.out.println(solution.findCircleNum(isConnected));
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFindVersionIV uf = new UnionFindVersionIV(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.unionElements(i, j);
                }
            }
        }
        int ans = 0;
        int[] parent = uf.parent;

        for (int i = 0; i < parent.length; i++) {
            if (i == parent[i]) {
                ans++;
            }
        }
        return ans;
    }

    static class UnionFindVersionIV {

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

        public UnionFindVersionIV(int size) {
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
        private int find(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }
    }

}
