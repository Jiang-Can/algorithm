package LeetCode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LuckyNumbersInMatrix1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] cache = new int[matrix[0].length];
        Arrays.fill(cache,-1);
        int row, col;
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i<matrix.length; i++){
            col = findMinCol(matrix[i]);
            row = findMaxRow(matrix,col, cache);
            if(row == i){
                res.add(matrix[i][col]);
            }
        }
        return res;
    }
    private int findMinCol(int[] row){
        int minCol = 0;
        for(int i = 1; i<row.length; i++) {
            minCol = row[i]<row[minCol]? i : minCol;
        }
        return minCol;
    }

    private int findMaxRow(int[][] matrix, int col, int[] cache) {
        if( cache[col] != -1){
            return cache[col];
        }
        int maxRow = 0;
        for(int i = 1; i<matrix.length; i++){
            maxRow = matrix[i][col]>matrix[maxRow][col]? i:maxRow;
        }
        cache[col] = maxRow;
        return maxRow;
    }

}
