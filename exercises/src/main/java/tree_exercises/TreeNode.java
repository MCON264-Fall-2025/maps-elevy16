package tree_exercises;

// Recursive solution
// Time complexity: O(n) because traversing both trees once
// Space complexity: O(n) because of recursion


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode mergeTrees(TreeNode root1, TreeNode rooroot2) {

        return merge(root1, rooroot2);

    }

    public TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null && root2 != null) {
            return root2;
        }

        if (root1 != null && root2 == null) {
            return root1;
        }

        // if above conditions are not true, then we have valid nodes with values
        // create node that is the sum of root1 and root2
        TreeNode sum = new TreeNode(root1.val + root2.val);

        sum.left = merge(root1.left, root2.left);
        sum.right = merge(root1.right, root2.right);

        return sum;
    }
}