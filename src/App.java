import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class App {
    static HashMap<Integer, LinkedList<Integer>> adjL = new HashMap<>();
    static boolean[] visited;

    static void addNode(Integer node) {
        adjL.putIfAbsent(node, new LinkedList<Integer>());
    }

    static void addEdge(Integer src, Integer des) {
        LinkedList<Integer> currentNode = adjL.get(src);
        currentNode.addLast(des);

    }

    static void print() {
        for (Map.Entry<Integer, LinkedList<Integer>> set : adjL.entrySet()) {
            Integer node = set.getKey();
            LinkedList<Integer> edges = set.getValue();
            System.out.print(node + "->");
            for (Integer e : edges)
                System.out.print(e + "->");
            System.out.println();
        }
    }
    static void dfsRecursive(Integer start){
        visited[start]=true;
        System.out.println(start);
        LinkedList<Integer> edges=adjL.get(start);
        for(Integer e:edges){
            if(!visited[e])
            dfsRecursive(e);
        }

    }

    static void dfsIterative(Integer start){
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            Integer currentNode=stack.pop();
            visited[currentNode]=true;
            System.out.println(currentNode);
            LinkedList<Integer> edges=adjL.get(currentNode);
            for(Integer e:edges){
                if(!visited[e])
                stack.push(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        addNode(0);
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addEdge(0, 3);
        addEdge(0, 2);
        addEdge(1, 0);
        addEdge(2, 1);
        addEdge(3, 4);
        addEdge(4, 0);
        visited=new boolean[5];
        for(int i=0;i<5;i++){
            visited[i]=false;
        }

        //dfsRecursive(0);
        dfsIterative(0);
        

    }
}
