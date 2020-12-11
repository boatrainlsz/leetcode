package com.boatrain.array;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.doCheck(new int[]{1, 0, 0, 0, 0, 1}));
    }

    /**
     * 检查
     * @param trees
     * @return
     */
    public int doCheck(int[] trees) {
        //可以变为1的个数
        int count = 0;
        //before=1，代表前一个位置种了树
        int before = 0;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] == 1) {
                if (before > 0) {
                    //发现前一个其实不能种，撤回
                    count--;
                }
                before = 1;
                continue;
            }
            if (trees[i] == 0) {
                before--;
                if (before < 0) {
                    count++;
                    before = 1;
                }
            }
        }
        return count;
    }
}