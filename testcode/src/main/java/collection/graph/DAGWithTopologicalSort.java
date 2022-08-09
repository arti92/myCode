package collection.graph;

/**
 * @author Arti.Jadhav
 */

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Topological sort : reverse path (maintain possible backtrack from start to end)
 * directed acyclic graph (DAG)
 * Topological can perform only on directed and acyclic graphs i.e DAG
 */
public class DAGWithTopologicalSort {

    public static void main(String[] args) {
        System.out.println("topological order of provided DAG");
        int[][] input = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        printTopologicalSort(input);
    }

    private static void printTopologicalSort(int[][] input) {

        boolean[] visited = new boolean[input.length];
        Stack<Integer> stack = new Stack<>();

        LinkedList<Integer> adj[] = new LinkedList[input.length];
        for (int i = 0; i < input.length; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int j = 0; j < input.length; j++) {
            if (adj[input[j][0]] != null)
                adj[input[j][0]].add(input[j][1]); // for directed graph
        }

        //perform dfs for every not visited node
        for (int i = 0; i < input.length; i++) {
            if (visited[i] == false) {
                topologicalSortUtils(adj, i, visited, stack);
            }
        }
        //5 4 2 3 1 0
        while (!stack.isEmpty())
            System.out.print(" " + stack.peek() + " , ");


    }

    private static void topologicalSortUtils(LinkedList<Integer>[] adj, int i, boolean[] visited, Stack<Integer> stack) {

        visited[i] = true;
        ListIterator<Integer> listIterator = adj[i].listIterator();

        while (listIterator.hasNext()) {
            int node = listIterator.next();
            if (!visited[node]) {
                topologicalSortUtils(adj, node, visited, stack);
            }
        }
        stack.push(i);
    }
}
