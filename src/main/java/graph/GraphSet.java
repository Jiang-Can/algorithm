package graph;

import java.util.*;

public class GraphSet {
    public static void main(String[] args) {
        HashMap<String,HashSet<String>> graph=new HashMap<>();
        graph.put("A",new HashSet<>(Arrays.asList("B", "C")));
        graph.put("B",new HashSet<>(Arrays.asList("A","C","D")));
        graph.put("C",new HashSet<>(Arrays.asList("A","B","D","E")));
        graph.put("D",new HashSet<>(Arrays.asList("B","C","E","F")));
        graph.put("E",new HashSet<>(Arrays.asList("C","D")));
        graph.put("F",new HashSet<>(Arrays.asList("D")));
        DFS2(graph,"A");
    }

    public static void BFS(HashMap<String,HashSet<String>> graph,String initialPoint){
        Queue<String> queue=new LinkedList<>();
        queue.add(initialPoint);
        HashSet<String> old=new HashSet<>();
        old.add(initialPoint);
        ArrayList<String> outputs=new ArrayList<>();
        while (queue.size()>0){
           String output=queue.poll();
           outputs.add(output);
           HashSet<String> neighbors=graph.get(output);
           // remain new neighbors
            neighbors.removeAll(old);
            if(neighbors.size()>0){
                queue.addAll(neighbors);
                old.addAll(neighbors);
            }
        }
        System.out.println(outputs);
    }

    public static void DFS(HashMap<String,HashSet<String>> graph,String initialPoint){
        Stack<String> stack=new Stack<>();
        stack.push(initialPoint);
        HashSet<String> old=new HashSet<>();
        old.add(initialPoint);
        ArrayList<String> outputs=new ArrayList<>();
        outputs.add(initialPoint);
        String next=initialPoint;
        while (outputs.size()!=graph.size()){
            HashSet<String> neighbors=graph.get(next);
            neighbors.removeAll(old);

            if(neighbors.size()>0){
                for(String neighbor: neighbors){
                    if(!old.contains(neighbor)){
                         old.add(neighbor);
                         stack.push(neighbor);
                         outputs.add(neighbor);
                         next=neighbor;
                         break;
                    }
                }
            }else{
                 stack.pop();
                 next=stack.peek();
            }
            System.out.println(outputs);
        }
    }

    public static void DFS2(HashMap<String,HashSet<String>> graph,String initialPoint){
        Stack<String> stack=new Stack<>();
        stack.push(initialPoint);
        HashSet<String> old=new HashSet<>();
        old.add(initialPoint);
        ArrayList<String> outputs=new ArrayList<>();
        String next;
        HashSet<String> neighbors;
        while(stack.size()>0){
            //pop() one node
            next=stack.pop();
            outputs.add(next);
            neighbors=graph.get(next);
            neighbors.removeAll(old);
            if(neighbors.size()>0){  //it has neighbor(s) , push all neighbors into stack
                stack.addAll(neighbors);
                old.addAll(neighbors);
            }System.out.println(outputs);
        }

    }
}

