// This problem is as simple as buying/selling whenever there is a "dip" in the price.
// Try not to overthink problems like this and ask questions where necessary, because
// it does seem a little vague/tricky at first.

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) total += prices[i] - prices[i - 1];
        }
        return total;
    }
}