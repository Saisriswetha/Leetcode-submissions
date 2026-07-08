class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waiting = 0;
        int profit = 0;
        int maxProfit = 0;
        int answer = -1;
        int rotation = 0;
        int i = 0;

        while (i < customers.length || waiting > 0) {
            if (i < customers.length) {
                waiting += customers[i];
                i++;
            }

            int boarded = Math.min(4, waiting);
            waiting -= boarded;

            profit += boarded * boardingCost - runningCost;
            rotation++;

            if (profit > maxProfit) {
                maxProfit = profit;
                answer = rotation;
            }
        }

        return answer;
    }
}