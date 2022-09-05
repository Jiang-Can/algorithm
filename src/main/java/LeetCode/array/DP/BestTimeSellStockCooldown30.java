package LeetCode.array.DP;

public class BestTimeSellStockCooldown30 {
    public static void main(String[] args) {
        System.out.println(new BestTimeSellStockCooldown30().maxProfit(new int[]{1,2,3,0,2}));
    }
    public int maxProfit(int[] prices) {
        if(prices.length<1)return 0;
        int[] buy=new int[prices.length+1];
        buy[1]=-prices[0];
        int[] sell=new int[prices.length+1];
        for(int i=2;i<sell.length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i-1]);
            sell[i]=Math.max(buy[i-1]+prices[i-1],sell[i-1]);
        }
        return sell[prices.length];
    }
}
