class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int len = 0;
                int current = i;
                
                while (!visited[current]) {
                    visited[current] = true;
                    current = nums[current];
                    len++;
                }
                
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}