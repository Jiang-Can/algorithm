package LeetCode.array;

public class RotateImage48 {
    public void rotate(int[][] matrix) {
        int temp;
        int n=matrix.length-1;
        for(int i=0;i<(n+1)/2;i++){
            for(int j=i;j<n-i;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[n-j][i];
                matrix[n-j][i]=matrix[n-i][n-j];
                matrix[n-i][n-j]=matrix[j][n-i];
                matrix[j][n-i]=temp;
            }
        }
    }

    public void rotateSolution2(int[][] matrix){
        int temp;
        int n=matrix.length;
        for(int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
    }
}
