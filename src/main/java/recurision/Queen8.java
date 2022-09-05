package recurision;

public class Queen8 {
    // 定义最大皇后数量
    int max=8;
    //定义数组array，保存皇后放置位置的数组
    int[] array=new int[max];
    public static void main(String[] args) {
        Queen8 q=new Queen8();
        q.check(0);
    }
    private void print(){
        for(int i=0;i<max;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    //放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n){
        for(int i=0;i<n;i++){
            //判断是否同列 和 是否在对角线上
            if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    //
    private void check(int n){
        if(n==max){  //n =8   8个皇后都放好了
            print();
            return;
        }
        for(int i=0;i<max;i++){
            //先把当前这个皇后n,放到第一列
            array[n]=i;
            if(judge(n)){ //不冲突
                check(n+1); //检查下一个
            }
        }
    }
}
