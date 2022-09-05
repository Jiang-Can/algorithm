package graph;

import java.util.*;

public class Graph {
    public static void main(String[] args) {
        int n=5;
        String[] vertexes={"A","B","C","D","E"};
        Graph graph= new Graph(n);
        for(String vertex:vertexes){
            graph.insertVertex(vertex);
        }
        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,0,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        graph.insertEdges(3,1,1);
        graph.insertEdges(4,1,1);

        //graph.BFS(3);
        graph.DFS(0);
    }
    private int[][] edges;
    private ArrayList<String> vertexList;
    private int numberOfEdges;
    boolean[] visited;

    public Graph(int n){
       edges=new int[n][n];
       vertexList=new ArrayList<>();
       visited=new boolean[n];
    }
    public void DFS(int start){
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        visited[start]=true;
        while(stack.size()>0){
            int vertex=stack.pop();
            LinkedList<Integer> neighbours=searchNeighbour(vertex);
            for(int v:neighbours){
                if(!visited[v]){
                    stack.push(v);
                    visited[v]=true;
                }
            }
            System.out.println(vertex);
        }
    }
    public void BFS(int start){
        List<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while(queue.size()>0){
            LinkedList<Integer> neighbours=searchNeighbour(queue.get(0));
            for(int v:neighbours){
                if(!visited[v]){
                    queue.add(v);
                    visited[v]=true;
                }
            }
            System.out.println(queue.get(0));
            queue.remove(0);
        }
    }
    public LinkedList<Integer> searchNeighbour(int v){
        LinkedList<Integer> neiList=new LinkedList<>();
        for(int i = 0; i<edges[v].length; i++){
            if(edges[v][i]>0){
                neiList.add(i);
            }
        }
        return neiList;
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    public void insertEdges(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        ++numberOfEdges;
    }
    public int getNumberOfVertex(){
        return vertexList.size();
    }
    public int getNumberOfEdges(){
        return numberOfEdges;
    }
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    public void showGraph(){
        for(int[] row:edges){
            System.out.println(Arrays.toString(row));
        }
    }
}
