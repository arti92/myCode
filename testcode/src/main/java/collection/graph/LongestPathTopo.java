package collection.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @author Arti.Jadhav
 */
public class LongestPathTopo {

    public int V;
    public LinkedList<AdjNodes> adj[];

    class AdjNodes {
        int edge;
        int weight;

        public AdjNodes(int e, int w) {
            edge = e;
            weight = w;
        }

        public int getEdge() {
            return edge;
        }

        public int getWeight() {
            return weight;
        }

    }

    public LongestPathTopo(int size) {
        V = size;

        adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    private void addEdge(int node, int edge, int weight) {
        AdjNodes adjNodes = new AdjNodes(edge, weight);
        adj[node].add(adjNodes);
    }

    public static void main(String[] args) {
        LongestPathTopo g = new LongestPathTopo(6);
      /*  g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);*/
        g.addEdge(9, 9, 4);
        g.addEdge(6, 6, 8);
        g.addEdge(2, 1, 1);


        int s = 9;
        System.out.print("Following are longest distances from source vertex " + s + " \n");
        g.longestPath(s);
    }

    private void longestPath(int s) {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[V];
        HashMap<Integer, Integer> distMap = new HashMap<>();

        //get topological order
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                getDFSUtil(i, visited, stack);
            }
            dist[i] = Integer.MIN_VALUE; //initialize all value to min
            distMap.put(i, Integer.MIN_VALUE);
        }
        System.out.println("topological order");
        stack.stream().forEach(st -> System.out.print(st + " , "));

        dist[s] = 0;
        distMap.put(s, 0);
        while (!stack.isEmpty()) {
            int topoNode = stack.pop();
            if (dist[topoNode] != Integer.MIN_VALUE) {
                ListIterator<AdjNodes> itr = adj[topoNode].listIterator();
                // while (itr.hasNext()) { // it will give nodes which are connected
                for (int i = 0; i < adj[topoNode].size(); i++) { //need all nodes , hence for
                    int nextWdge = adj[topoNode].get(i).getEdge();
                    int weight = adj[topoNode].get(i).getWeight();
                    if (dist[nextWdge] < (dist[topoNode] + weight)) {
                        dist[nextWdge] = dist[topoNode] + weight;
                        distMap.put(nextWdge, dist[topoNode] + weight);
                    }
                }
            }
        }
        System.out.println("Longest Distance");
        distMap.entrySet().stream().forEach(e -> System.out.print(e.getKey() + "::" + e.getValue() + " , "));

    }

    private void getDFSUtil(int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;

        ListIterator<AdjNodes> itr = adj[i].listIterator();
        while (itr.hasNext()) {
            int nextNode = itr.next().getEdge();
            if (!visited[nextNode]) {
                getDFSUtil(nextNode, visited, stack);
            }
        }
        stack.add(i); // for topological order
    }

}
