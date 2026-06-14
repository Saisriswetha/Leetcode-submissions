class Solution {
    private int totalTilt = 0;
    
    public int findTilt(TreeNode root) {
        postorder(root);
        return totalTilt;
    }
    
    private long postorder(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        long leftSum = postorder(node.left);
        long rightSum = postorder(node.right);
        
        totalTilt += Math.abs(leftSum - rightSum);
        
        return leftSum + node.val + rightSum;
    }
}