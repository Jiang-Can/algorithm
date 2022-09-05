package recurision;

import java.util.Arrays;

public class MiGong {
    public static void main(String[] args) {
        //二维数组，模拟迷宫
        int[][] map=new int[8][7];
        //使用1表示墙；
        //上下全部 置为1
        for(int i=0;i<map[0].length;i++){
            map[0][i]=1;
            map[map.length-1][i]=1;
        }
        //左右全部置1
        for(int i=0;i<map.length;i++){
            map[i][0]=1;
            map[i][map[0].length-1]=1;
        }
        //设置挡板，用1
        map[2][1]=1;
        map[2][2]=1;
        map[3][2]=1;
        map[3][3]=1;
        map[3][4]=1;
        map[2][4]=1;
        drawMap(map);
        String strategy="bcad";
        setWay(map,1,1,strategy);
        System.out.println("after search");
        drawMap(map);
        System.out.print("count of 2: ");
        System.out.println(count(map));
    }
    //数2的个数以检验那种策略更优
    public static int count(int[][] map){
        int count=0;
        for(int[] i:map){
            for(int j:i){
                if(j==2)
                    ++count;
            }
        }
        return count;
    }
    public static void drawMap(int[][] map){
        for(int[] i:map){
            for(int j:i){
                System.out.print((int)j +" ");
            }
            System.out.println();
        }
    }
    //找路
    /*
    * i，j 出发点
    * 如果找到路返回true，否则返回false
    * 0表示没走过 1表示墙 2表示通路已走 3表示改点已走过，走不通
    * 增加策略 下a 右b 上c 左d
    * */
    public static boolean setWay(int[][]map,int i,int j,String s){
        //如果到达终点返回true
        if(map[6][5]==2){
            return true;
        }
        else{
            //判断点是否可走
            if(map[i][j]==0){
                map[i][j]=2;
                //遍历操作顺序
                int[][] oper=new int[4][2];
                for(int k=0;k<4;k++){
                    if(s.charAt(k)=='a'){//像下走
                        oper[k][0]=i+1;
                        oper[k][1]=j;
                    }else if(s.charAt(k)=='b'){//像右走
                        oper[k][0]=i;
                        oper[k][1]=j+1;
                    }else if(s.charAt(k)=='c'){//像上走
                        oper[k][0]=i-1;
                        oper[k][1]=j;
                    }else if(s.charAt(k)=='d'){//像左走
                        oper[k][0]=i;
                        oper[k][1]=j-1;
                    }
                }
                if(setWay(map,oper[0][0],oper[0][1],s)){
                    return true;
                }else if(setWay(map,oper[1][0],oper[1][1],s)){
                    return true;
                }else if(setWay(map,oper[2][0],oper[2][1],s)) {
                    return true;
                }else if(setWay(map,oper[3][0],oper[3][1],s)){
                    return true;
                } else{//都走不通
                    map[i][j]=3;//是当前节点为走不通
                    return false;
                }
            }else{ //如果不是0，可能是123，则点不可走
                return false;
            }
        }
    }
}
