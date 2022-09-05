package LeetCode.hashtable;

public class IslandPerimeter463 {
    public int islandPerimeter(int[][] grid) {
        int perimeter=0;
        int[][] newMap=new int[grid.length+2][grid[0].length+2];
        for (int i=1;i< newMap.length-1;i++){
            if (newMap[0].length - 2>= 0)
                System.arraycopy(grid[i - 1], 0, newMap[i], 1, newMap[0].length - 2);
        }
        for(int i=1;i<newMap.length-1;i++){
            for(int j=1;j<newMap[0].length-1;j++){
                if(newMap[i][j]==1) perimeter+=(newMap[i-1][j]^1)+(newMap[i+1][j]^1)+(newMap[i][j-1]^1)+(newMap[i][j+1]^1);
            }
        }
        return perimeter;
    }
    public int mathSolution(int[][] grid){
        int islands=0;
        int neighbours=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    islands++;
                    if(i<grid.length-1&&grid[i+1][j]==1)neighbours++;
                    if(j<grid[0].length-1&&grid[i][j+1]==1)neighbours++;
                }
            }
        }
        return 4*islands-2*neighbours;
    }
}
