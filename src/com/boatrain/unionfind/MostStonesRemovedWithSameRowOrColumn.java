package com.boatrain.unionfind;

/**
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn solution = new MostStonesRemovedWithSameRowOrColumn();
        int[][] stones = {{0, 1}, {1, 2}, {1, 3}, {3, 3}, {2, 3}, {0, 2}};
        System.out.println(solution.removeStones(stones));
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    unionFind.unionElements(i, j);
                }
            }
        }
        return n - unionFind.getConnectedComponentSize();
    }


    static class UnionFind {

        /**
         * i是元素，parent[i]是元素的父节点
         * i:        0,1,2,3,4,5,6,7,8,9
         * parent[i]:1,1,1,8,3,0,5,1,8,8
         */
        private final int[] parent;
        /**
         * rank[i]：以i为根节点的树的层数
         */
        private final int[] rank;
        /**
         * 连通分量个数
         */
        private int connectedComponentSize;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            connectedComponentSize = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int getConnectedComponentSize() {
            return connectedComponentSize;
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
                connectedComponentSize--;
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
            //路径压缩算法2：孩子变祖先，这个更狠
            //https://www.runoob.com/data-structures/union-find-compress.html
            if (parent[p] != p) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public int remove(int p, boolean[] removed) {
            int cnt = 0;
            while (p != parent[p]) {
                if (!removed[p]) {
                    removed[p] = true;
                    cnt++;
                }
                p = parent[p];
            }
            return cnt;
        }
    }
}