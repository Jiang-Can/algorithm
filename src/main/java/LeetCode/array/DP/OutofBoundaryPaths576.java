package LeetCode.array.DP;

import java.util.*;

public class OutofBoundaryPaths576 {

    // use array to store steps
    public int findPaths1(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] last = new int[m][n];
        final int mod = 1000000007;
        last[startRow][startColumn] = 1;
        int res = 0;
        int[][] operations = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int move = 0; move < maxMove; move++) {
            int[][] cur = new int[m][n];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    for(int[] operation:operations) {
                        int newRow = row + operation[0];
                        int newCol = col + operation[1];
                        if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n ) {
                            res =  (res + last[row][col]) % mod ;
                        } else {
                            cur[newRow][newCol] = (cur[newRow][newCol] + last[row][col]) % mod;
                        }
                    }
                }
            }
            last = cur;
        }
        return res;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int res = 0;
        Queue<Coordinater> pre = new LinkedList<>();
        Coordinater init = new Coordinater(startRow,startColumn,1);
        pre.offer(init);
        Map<Coordinater,Integer> next = new HashMap<>();

        for(int i = 1; i<=maxMove; i++) {
            while (!pre.isEmpty()) {
                Coordinater temp = pre.poll();
                // up
                res = move(temp,0,temp.row-1,temp.column,res,true,next);
                // down
                res = move(temp,m-1,temp.row+1,temp.column,res,true,next);
                // left
                res = move(temp,0,temp.row,temp.column - 1,res,false,next);
                // right
                res = move(temp,n-1,temp.row,temp.column + 1,res,false,next);
            }
            updateCache(pre,next);
        }
        return res;

    }

    private int move(Coordinater coordinater, int boundary, int newRow, int newColumn, int res,boolean isRowMoved, Map<Coordinater,Integer> next) {
        if((isRowMoved? coordinater.row:coordinater.column) == boundary) {
            res = (res+coordinater.value)% 1000000007;
        } else {
            Coordinater newCoordinater = new Coordinater(newRow,newColumn);
            Integer value = next.get(newCoordinater);
            next.put(newCoordinater,value == null? coordinater.value : (coordinater.value + value)%1000000007);
        }
        return res;
    }

    private void updateCache(Queue<Coordinater> pre, Map<Coordinater,Integer> next) {
        pre.clear();
        for (Map.Entry<Coordinater, Integer> entry : next.entrySet()) {
            Coordinater coordinater = entry.getKey();
            coordinater.value = entry.getValue();
            pre.offer(coordinater);
        }
        next.clear();
    }

    class Coordinater {
        int row;
        int column;
        int value;

        public Coordinater(int m, int n, int value) {
            this.row = m;
            this.column = n;
            this.value = value;
        }
        public Coordinater(int m, int n) {
            this.row = m;
            this.column = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinater that = (Coordinater) o;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }

    public static void main(String[] args) {
        OutofBoundaryPaths576 o = new OutofBoundaryPaths576();
        System.out.println(o.findPaths(8, 50, 23, 5, 26));
    }

}
