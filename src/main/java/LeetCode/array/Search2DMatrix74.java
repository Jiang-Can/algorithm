package LeetCode.array;

public class Search2DMatrix74 {
    public static void main(String[] args) {
        Search2DMatrix74 search2DMatrix74 = new Search2DMatrix74();
        search2DMatrix74.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix,0,matrix.length-1,target);
        return findTarget(matrix[row],0,matrix[row].length-1,target);
    }
    private int findRow(int[][] matrix,int left, int right, int target){
        if(left == right){
            return left;
        }
        int mid = (left + right)/2;
        if(matrix[mid][0]<target){
            if(right-mid == 1){
                return target>=matrix[right][0]?right:mid;
            }
            return findRow(matrix,mid,right,target);
        }else if(matrix[mid][0]>target){
            return findRow(matrix,left,mid-1,target);
        }
        return mid;
    }
    private boolean findTarget(int[] arr,int left, int right, int target){
        if(left>right){
            return false;
        }
        int mid = (left + right)/2;
        if(arr[mid]>target){
            return findTarget(arr,left,mid-1,target);
        }else if(arr[mid]<target){
            return findTarget(arr,mid+1,right,target);
        }
        return true;
    }

    //直接二分法
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int right = n*m-1, left = 0,mid;
        while (left<=right){
            mid = (right+left)>>1;
            if(matrix[mid/n][mid%n] == target){
                return true;
            }
            if(matrix[mid/n][mid%n] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
