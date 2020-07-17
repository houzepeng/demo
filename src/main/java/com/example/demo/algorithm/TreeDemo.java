package com.example.demo.algorithm;

/**
 * TreeDemo
 */


    // 解题关键：中序遍历
// https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
// 给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第 k 个最小的元素。
// 只要利用二分搜索树的中序遍历，就可以完成。
public class TreeDemo {
    private int count = 0;
    private int res = 0;

    private void dfs(TreeNode node) {
        if (node == null) {
            // 什么都不做
            return;
        }
        dfs(node.left);
        count--;
        if (count == 0) {
            this.res = node.val;
        }
        dfs(node.right);
    }

    // k 如果在方法传递的过程中是值传递，所以把它设置为成员变量，这样就是引用传递
    // 因为我们要用到 k 全局的值，去数出，我是第几个中序遍历到的值
    //二叉树中序遍历之后是有序数组
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        TreeDemo solution = new TreeDemo();
        int kthSmallest = solution.kthSmallest(treeNode2, 2);
        System.out.println(kthSmallest);
    }

}