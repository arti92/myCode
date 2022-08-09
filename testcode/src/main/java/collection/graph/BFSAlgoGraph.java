package collection.graph;

import java.util.*;

/**
 * @author Arti.Jadhav
 */
public class BFSAlgoGraph {

    private int V;
    private LinkedList<Integer> adjList[];

    public BFSAlgoGraph(int v) {
        V = v;
        adjList = new LinkedList[v]; // why not LinkedList<Integer> for assignment
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdges(int node, int value) {
        adjList[node].add(value);
    }

    private void getBFS(int startNode) {

        boolean[] visited = new boolean[V];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        getBFSUtils(startNode, visited);

    }

    private void getBFSUtilsByRecursion(int startNode, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[startNode] = true;
        q.add(startNode);

        System.out.print(".. " + startNode + " , ");
        for (Integer ni : adjList[startNode]) {
            q.add(ni);
        }

        while (!q.isEmpty()) {
            // System.out.println(" :: ");
            //q.stream().forEach(i -> System.out.print(i+"--"));
            Integer node = q.poll();
            if (visited[node] == false) {
                getBFSUtils(node, visited);
            }
        }
    }

    private List<Integer> getBFSUtils(int startNode, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        visited[startNode] = true;
        q.add(startNode);
        path.add(startNode);

        while (!q.isEmpty()) {
            //  System.out.println(" :: ");
            //q.stream().forEach(i -> System.out.print(i+"--"));
            Integer node = q.poll();
            System.out.print(".. " + node + " , ");
            for (Integer ni : adjList[node]) {
                if (visited[ni] == false) {
                    visited[ni] = true;
                    q.add(ni);
                    path.add(ni);
                }
            }
        }
        // System.out.println("path..");
        //path.stream().forEach(i-> System.out.println(i));
        return path;
    }

    public static void main(String[] args) {
        System.out.println("create Graph");
        BFSAlgoGraph graph = new BFSAlgoGraph(4); //assign size of graph,
        // for creating that many linkedList (for edges) and visited false boolean array
        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(1, 2);
        graph.addEdges(2, 0);
        graph.addEdges(2, 3);
        graph.addEdges(3, 3);

        /* adj list
        0 [1,2]
        1 [2]
        2 [0,3]
        3 [3]
         */
        Arrays.stream(graph.adjList).sequential().forEach(integers -> System.out.print(integers + " , "));

        System.out.println("BFS Graph Print");
        graph.getBFS(2);//2 0 3 1
    }

}
