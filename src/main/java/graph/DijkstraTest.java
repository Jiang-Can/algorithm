package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraTest {
    static final int MAX=1000;
    public static final String[] alpha={"A","B","C","D","E","F"};
    public static void main(String[] args) {
        int[][] graph=new int[6][6];
        for(int[] s:graph){
            Arrays.fill(s,MAX); 
        }
        graph[0][1]=graph[1][0]=5;
        graph[0][2]=graph[2][0]=1;
        graph[1][2]=graph[2][1]=2;
        graph[1][3]=graph[3][1]=1;
        graph[2][3]=graph[3][2]=4;
        graph[2][4]=graph[4][2]=8;
        graph[3][4]=graph[4][3]=3;
        graph[3][5]=graph[5][3]=6;
        for(int[] s:graph){
            System.out.println(Arrays.toString(s));
        }
        Dijkstra(0,graph);
    }
    public static void Dijkstra(int initial,int[][] graph){
        Comparator<Node> comparator= new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dis-o2.dis;
            }
        } ;
        PriorityQueue<Node> queue=new PriorityQueue<>(comparator);
        Node ini=new Node(initial,0,0);
        queue.add(ini);
        int length=graph[0].length;
        int[] parent=new int[length];
        boolean[] ready=new boolean[length];
        ArrayList<Node> readyNodes=new ArrayList<>();
        while(!queue.isEmpty()){
            Node node=queue.poll(); // this node need to be found all neighbor
            parent[node.no]=node.parent;
            if(!ready[node.no]){ // this node has not already been set, else the the polled node will be thrown
                ready[node.no]=true;
                readyNodes.add(node);
                for(int i=0;i<length;i++){  // add all neighbors of this node to the queue
                    if(graph[node.no][i]!=MAX&&!ready[i]){  // find all neighbors which are not in ready
                        parent[i]=node.no;
                        queue.add(new Node(i,graph[node.no][i]+node.dis,node.no));
                    }
                }
            }
        }
        System.out.println("Parent: "+Arrays.toString(parent));
        System.out.println(readyNodes);

    }
}

class Node{
    int no;
    int dis;
    int parent;

    public Node(int x, int dis,int parent) {
        this.no = x;
        this.dis = dis;
        this.parent=parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                DijkstraTest.alpha[no] +
                ", dis=" + dis +
                ", parent=" + parent +
                '}';
    }
}