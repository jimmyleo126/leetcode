package leetcode.queue.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void recursionInOrderTraversal(TreeNode node, List<Integer> integers) {
        if (node != null) {
            recursionInOrderTraversal(node.left, integers);
            integers.add(node.val);
            recursionInOrderTraversal(node.right, integers);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();

        Stack<TreeNode> treeNodes = new Stack<>();
        //recursionInOrderTraversal(root, integers);
        TreeNode node = root;
        while (node != null || !treeNodes.isEmpty()) {
            while (node != null) {
                treeNodes.push(node);
                node = node.left;
            }
            if (!treeNodes.isEmpty()) {
                node = treeNodes.pop();
                integers.add(node.val);
                node = node.right;
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode riht = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = riht;
        riht.left = left;
        InOrderTree inOrderTree = new InOrderTree();
        System.out.println(inOrderTree.inorderTraversal(root));
    }
}
