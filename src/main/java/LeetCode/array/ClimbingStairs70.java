package LeetCode.array;

public class ClimbingStairs70 {

    public int climbStairs(int n) {
        return bruteForce(0,n);
    }
    private int bruteForce(int steps,int n){
        if(steps>n)return 0;
        if(steps==n) return 1;
        return bruteForce(steps+1, n)+bruteForce(steps+2,n);
    }

    public int memoSolution(int n){
        int[] memo=new int[n+1];
        return memoRecur(memo,0,n);
    }
    private int memoRecur(int[] memo,int steps,int n){
        if(steps>n)return 0;
        if(steps==n) return 1;
        if(memo[steps]>0)return memo[steps];
        memo[steps]=memoRecur(memo, steps+1, n)+memoRecur(memo, steps+2, n);
        return memo[steps];
    }


    //fib solution
    /*Let dp[i] denotes the number of ways to reach on i^{th}i th step:
        dp[i]=dp[i-1]+dp[i-2]*/
    public int fibSolution(int n){
        if(n==1) return 1;
        int[] dp =new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }


    //fib solution use pure math
    //因为f0=0 f1=1 f2=1, 所以n需要加一以满足 此题中f1=1 f2=2
    public int fibSolution2(int n){
        double sqrt5=Math.sqrt(5.0);
        double fn=1/sqrt5*Math.pow((1+sqrt5)/2,n)-1/sqrt5*Math.pow(((1-sqrt5)/2),n);
        int res=(int)fn;
        if(fn-res>res+1-fn){
            return res+1;
        }else {
            return res;
        }

    }
}
