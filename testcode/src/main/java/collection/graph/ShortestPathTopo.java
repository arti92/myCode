package collection.graph;

/**
 * @author Arti.Jadhav
 */

import java.util.*;

/**
 * shortest path using topological ordering
 * for DAG graph
 * from source to each node the shortest path weight
 */
public class ShortestPathTopo {
    int node;
    LinkedList<AdjecentNodes> adj[];

    public ShortestPathTopo(int size) {
        this.node = size;
        adj = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int node, int edge, int weight) {
        AdjecentNodes an = new AdjecentNodes(edge, weight);
        adj[node].add(an);
    }


    class AdjecentNodes {
        int edge;
        int weight;

        public AdjecentNodes(int v, int w) {
            this.edge = v;
            this.weight = w;
        }

        public int getEdge() {
            return edge;
        }

        public int getWeight() {
            return weight;
        }
    }


    public static void main(String[] args) {
        System.out.println("find shortest path");
        ShortestPathTopo g = new ShortestPathTopo(6);
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 3, 3);

        g.addEdge(2, 3, 4);

      /*  g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);*/

        int s = 0;
        //shows min weight dist from 1 to each node
        System.out.println("Following are shortest distances " +
                "from source " + s);
        g.shortestPath(s);
    }

    private void shortestPath(int s) {

        boolean visited[] = new boolean[node];

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> qstack = new LinkedList<>();
        for (int i = 0; i < node; i++) {
            if (!visited[i])
                topologicalUtil(i, stack, visited);
        }
        //what if no toplogical oreder...5 4 3 2 1 0
        //topo order means it covers all privios compulsory nodes ...so stack contain nearest node
        //if no topo then it start from end and these node not able to clavulate
        //as for shortest path need to go from start to each and evry...but if no topo then not all path get covered
        //as there will be no proper order for who is 1st and who is noy
        for (int i = 0; i < node; i++) {
            qstack.add(i);
        }
        //end
        System.out.println("topoOrder:: ");
        stack.stream().forEach(data -> System.out.print(data + " , "));


        // Initialize distances to all vertices as infinite and
        // distance to source as 0
        Integer dist[] = new Integer[node];
        Map<Integer, Integer> distMap = new HashMap<>();

        for (int i = 0; i < node; i++) {
            dist[i] = Integer.MAX_VALUE;
            distMap.put(i, Integer.MAX_VALUE);
        }
        dist[s] = 0;
        distMap.put(s, 0);
        while (!stack.isEmpty()) {
            int sData = stack.pop();
            if (dist[sData] != Integer.MAX_VALUE) {
                ListIterator<AdjecentNodes> itr = adj[sData].listIterator();
                while (itr.hasNext()) {
                    AdjecentNodes nextNode = itr.next();
                    if (dist[nextNode.getEdge()] > (dist[sData] + nextNode.getWeight())) {
                        dist[nextNode.getEdge()] = dist[sData] + nextNode.getWeight();
                        distMap.put(nextNode.getEdge(), dist[sData] + nextNode.getWeight());
                    }
                }
            }
        }
        System.out.println("map showing source to each node distance:: ");
        distMap.entrySet().stream().forEach(a -> System.out.println(a.getKey() + " :: " + a.getValue()));
        System.out.println("Shortest Path is...");
        for (int i = 0; i < node; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print("max" + " ");
            else
                System.out.print(dist[i] + " ");
        }


    }

    private void topologicalUtil(int i, Stack<Integer> stack, boolean[] visited) {

        visited[i] = true;
        ListIterator<AdjecentNodes> itr = adj[i].listIterator();
        while (itr.hasNext()) {
            AdjecentNodes an = itr.next();
            int nextNode = an.getEdge();
            if (!visited[nextNode]) {
                topologicalUtil(nextNode, stack, visited);
            }
        }
        stack.push(i);
    }
}
