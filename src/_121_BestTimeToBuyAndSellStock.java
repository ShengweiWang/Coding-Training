/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int ans = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; ++i)
            if(prices[i] > min){
                ans = Math.max(prices[i] - min, ans);
            } else
                min = prices[i];
        return ans;
    }
}
