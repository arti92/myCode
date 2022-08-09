package collection.graph;

/**
 * @author Arti.Jadhav
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Depth first search print
 * Graph Type : Directed Graph
 * Representation type : Adjacency List
 */
public class DFSGraph {

    private int V; //vertices
    private LinkedList<Integer> adj[]; //Adjacency List

    public DFSGraph(int v) {
        V = v; //assigne size of graph
        adj = new LinkedList[v]; //initialize array
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList(); //create linklist for each node
            System.out.println(i + " adj[i]:: " + adj[i]);
        }
    }

    //add connected numbers n in form of nodes/vertices v
    void addEdges(int v, int n) {
        adj[v].add(n);
    }

    void getDFS(int start) {

        boolean visited[] = new boolean[V]; // created array of false of V numbers of nodes

        DFSUtils(start, visited);
    }

    private void DFSUtils(int start, boolean[] visited) {
        //mark start node as visited and print
        visited[start] = true;
        System.out.print(start + " --- ");

        //listItrator : Can traverse elements present in Collection both in forward and backward directions.
        //https://www.geeksforgeeks.org/difference-between-an-iterator-and-listiterator-in-java/
        ListIterator<Integer> itrator = adj[start].listIterator();
        while (itrator.hasNext()) {
            int n = itrator.next();// n: [n1 n2] , get n1/n2
            if (visited[n] != true) {// to check n1 or n2 is already visited or not
                DFSUtils(n, visited); //if not visited, go for that nodes, n1
            }

        }
    }


    public static void main(String[] args) {
        System.out.println("create Graph");
        DFSGraph graph = new DFSGraph(4); //assign size of graph,
        // for creating that many linkedList (for edges) and visited false boolean array
        graph.addEdges(0, 1);
        graph.addEdges(0, 2);
        graph.addEdges(1, 2);
        graph.addEdges(2, 0);
        graph.addEdges(2, 3);
        graph.addEdges(3, 3);

        Arrays.stream(graph.adj).sequential().forEach(integers -> System.out.print(integers + " , "));

        System.out.println("DFS Graph Print");
        graph.getDFS(2);//start from 2 node ....so 2[0,3] started and then 0[1,2] and so on...
        //print for 2 -- 2,0,1,3
        //print for 0 -- 0,1,2,3
        //print for 3 --- no print
        //print for 1 -- 1,2,0,3
    }
}
