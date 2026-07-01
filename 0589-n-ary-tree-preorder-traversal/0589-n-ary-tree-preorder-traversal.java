class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return ans;
    }

    private void dfs(Node node) {
        if (node == null) return;

        ans.add(node.val);

        if (node.children != null) {
            for (Node child : node.children) {
                dfs(child);
            }
        }
    }
}