package LeetCode.array.DP;

public class KnightProbabilityInChessboard688 {
    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
    }

    public static double knightProbability(int n, int k, int row, int column) {
        int[][] moves = new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        double[][] last = new double[n][n];
        last[row][column] = 1.0;
        double res = 0.0;
        for(int step = 0; step < k; step++) {
            double[][] next = new double[n][n];
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    if(last[r][c] != 0) {
                        // run 8 moves
                        for (int[] move : moves) {
                            int newRow = r + move[0];
                            int newCol = c + move[1];
                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                                next[newRow][newCol] +=  last[r][c]/8;
                            }
                        }
                    }
                }
            }
            last = next;
        }
        // get result
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                res += last[r][c];
            }
        }
        return res;
    }
}
