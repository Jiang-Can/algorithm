package SparseArray;

public class SparseArray {
    public static void main(String[] args) {
        //创建原始二维数组
        //0表示无子 1表示黑子 2表示白子
        int[][] chessArr1 =new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;

        printArray(chessArr1);
        //将二维数组转为稀疏数组
        //1. 先遍历二维数组 得到非0数据的个数
        int sum=0;
        for (int[] ints : chessArr1) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
        int[][] sparseArr =new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1[0].length;
        sparseArr[0][2]=sum;
        //遍历chessArr,将非0的值放在sparsArr里
        int s=0;

            for(int i=0;i<chessArr1.length;i++)
            {
                for(int j=0;j<chessArr1[0].length;j++)
                {
                    if(chessArr1[i][j]!=0)
                    {
                        sparseArr[s+1][0]=i;
                        sparseArr[s+1][1]=j;
                        sparseArr[s++ +1][2]=chessArr1[i][j];
                    }
                    if(s==sum)
                        break;
                }
            }
       printArray(sparseArr);
    //将sparseArr恢复成chessArr
        int[][] chessArr =new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i=1;i<sparseArr.length;i++)
        {
            chessArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        printArray(chessArr);
    }
    public static void printArray(int[][] arr)
    {
        for(int[] row:arr)
        {
            for(int data:row)
                System.out.print(data+"\t");
            System.out.println();
        }

    }
}
