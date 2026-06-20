class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;

        int right = -1;
        int maxSeen = nums[0];

        for (int i = 1; i < n; i++) {
            maxSeen = Math.max(maxSeen, nums[i]);

            if (nums[i] < maxSeen) {
                right = i;
            }
        }

        if (right == -1) {
            return 0; // already sorted
        }

        int left = -1;
        int minSeen = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            minSeen = Math.min(minSeen, nums[i]);

            if (nums[i] > minSeen) {
                left = i;
            }
        }

        return right - left + 1;
    }
}