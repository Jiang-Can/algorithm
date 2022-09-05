package LeetCode.array.DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KnapsackSample {
    int V; // left volume of bag
    int N; // number of items
    int[] weight;
    int[] value;

    public static void main(String[] args) {
        KnapsackSample k=new KnapsackSample();
        k.weight=new int[]{2,2,6,5,4};
        k.value=new int[]{6,3,5,4,6};
        k.V=10;
        k.N=5;
        k.ZeroOneBag2();

        k.maxSubArray(new int[]{-1});

        List<Integer> test1 = new LinkedList<>(Arrays.asList(1,2,3));
        List<Integer> test2 = test1;
        test2.add(4);
        System.out.println(test1);
        System.out.println(test2);

    }

    //01 bag  有N件物品和一个容量为V的背包，第i件物品消耗的容量为weight[i]，价值为value[i]，求解放入哪些物品可以使得背包中总价值最大

    private void ZeroOneBag(){
        int[][] dp=new int[N+1][V+1]; //for recording value in each stage
        //int[0][j]=0 they are 0 value when there is no item  ,  int[i][0]=0 they are 0 value when capacity if 0
        for(int i=1;i<=N;i++){
            for(int j=1;j<=V;j++){ //j--different capacity
                if(weight[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        int max=dp[N][V];
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        /*
          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          [0, 0, 6, 6, 6, 6, 6, 6, 6, 6, 6]
          [0, 0, 6, 6, 9, 9, 9, 9, 9, 9, 9]
          [0, 0, 6, 6, 9, 9, 9, 9, 11, 11, 14]
          [0, 0, 6, 6, 9, 9, 9, 10, 11, 13, 14]
          [0, 0, 6, 6, 9, 9, 12, 12, 15, 15, 15]
          */
    }
    //less space solution
    private void ZeroOneBag2(){
        int[] dp=new int[V+1];
        for(int i=0;i<N;i++){
            for(int j=V;j>=weight[i];j--){
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        /*
        [0, 0, 6, 6, 9, 9, 12, 12, 15, 15, 15]
        * */
    }
    private void MultiBag(){
        int[] dp=new int[V+1];
        for(int i=0;i<N;i++){
            for(int k=1;k<N+1;k++){
                for(int j=V;j>=k*weight[i];j--){
                    dp[j]=Math.max(dp[j],dp[j-weight[i]*k]+value[i]*k);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }

    public int maxSubArray(int[] nums) {
        int max = -1000000,sum = 0;

        for (int num : nums) {

        }
        for(int i = 0;i<nums.length;i++){
            sum = sum>0?sum+nums[i]:nums[i];
            max = Math.max(max,sum);
        }
        return max;
    }


    // record path , problem in
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.
        Res[] dp = new Res[capacity+1];
        for(Res res: dp){
        }
        for(int i =0;i<items.length;i++){
            for(int j = capacity;j>=items[i][1];j--){
                if(dp[j-items[i][1]].value+items[i][0]>dp[j].value){
                    dp[j].value=dp[j-items[i][1]].value+items[i][0];
                    dp[j].records.clear();
                    dp[j].records = new LinkedList<>(dp[j-items[i][1]].records);
                    dp[j].records.add(i);
                }
            }
        }
        return buildRes(dp[capacity]);
    }
    private static List<List<Integer>> buildRes(Res res){
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(List.of(res.value));
        ans.add(res.records);
        return ans;
    }
}

class Res{
    int value=0;
    List<Integer> records = new LinkedList<>();
}