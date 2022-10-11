package LeetCode.array.DP;

import java.util.Arrays;

public class KnightDialer935 {

    public static void main(String[] args) {
        System.out.println(knightDialer(2));
    }

    public static int knightDialer(int n) {
        int mod = 1000000007;
        int[][] moves = new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        int[][] last = new int[4][3];
        for(int[] arr: last){
            Arrays.fill(arr,1);
        }
        last[3][0] = 0;
        last[3][2] = 0;
        for(int step = 1; step < n ; step++) {
            int[][] cur = new int[4][3];
            for(int row = 0; row < 4; row ++) {
                for(int col = 0; col < 3; col ++) {
                    if(last[row][col] == 0) {
                        continue;
                    }
                    for(int[] move: moves) {
                        int newRow = row + move[0];
                        int newCol = col + move[1];
                        if(newRow >= 0 && newRow < 4 && newCol >= 0 && newCol < 3 &&
                        !((newRow==3 && newCol==0) || (newRow==3 && newCol==2))) {
                            cur[newRow][newCol] = (cur[newRow][newCol] + last[row][col]) % mod;
                        }
                    }
                }
            }
            last = cur;
        }
        int res = 0;
        for(int row = 0; row < 4; row ++) {
            for (int col = 0; col < 3; col++) {
                res = (res + last[row][col])%mod;
            }
        }
        return res;
    }
}
