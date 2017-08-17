import com.sun.glass.ui.Robot;

// This is essentially the maximum subarray problem (#53)! Remember
// to use Kadane's algorithm for contiguous array problems like this.

public class Solution {
    public int maxProfit(int[] prices) {
        int currentMaxProfit = 0, globalMaxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            currentMaxProfit += prices[i] - prices[i - 1];
            currentMaxProfit = Math.max(0, currentMaxProfit);
            globalMaxProfit = Math.max(globalMaxProfit, currentMaxProfit);
        }

        return globalMaxProfit;
    }
}