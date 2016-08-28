/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _309_BestTimeToBuyAndSellStockWithColldown {
    public int maxProfit(int[] prices){
        int[] bought = new int[prices.length];
        int[] couldbuy = new int[prices.length];
        if(prices.length < 2)
            return 0;
        bought[0] = -prices[0];
        couldbuy[0] = 0;
        bought[1] = Math.max(-prices[1], bought[0]);
        couldbuy[1] = 0;
        for(int i = 2; i < prices.length; ++i){
            bought[i] = Math.max(couldbuy[i - 1] - prices[i], bought[i -1]);
            couldbuy[i] = Math.max(couldbuy[i - 1], bought[i - 2] + prices[i - 1]);
        }
        return Math.max(couldbuy[prices.length - 1], bought[prices.length - 2] + prices[prices.length - 1]);
    }
}
