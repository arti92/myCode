package collection.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Arti.Jadhav
 */

/**
 * edges.length : give length of rows
 * edges[0].length : give length of column
 */
//Working
//https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class LeetMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        Points source = new Points(0, 0); // indices
        Points desti = new Points(grid.length - 1, grid.length - 1); // indices
        System.out.println("desti.." + desti.x + " ..y " + desti.y);
        int dist = getBFSGrid(source, desti, grid);
        System.out.println("distance:: " + dist);
        return dist;
    }

    static class Points {
        int x;
        int y;

        public Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class GridPoint {
        Points points;
        int dis;

        public GridPoint(Points points, int dis) {
            this.points = points;
            this.dis = dis;
        }
    }

    //indices should not be outside the matrix
    public boolean isValid(int r, int c, int[][] input) {
        if (r < 0 || c < 0 || r >= input.length || c >= input.length)
            return false;
        return true;
    }

    private int getBFSGrid(Points source, Points desti, int[][] input) {

        System.out.println("length:: " + input.length);
        boolean valiadted[][] = new boolean[input.length][input.length];
        LinkedList<GridPoint> queue = new LinkedList<>();

        if (input[source.x][source.y] != 0)
            return -1;

        queue.add(new GridPoint(source, 1));
        valiadted[source.x][source.y] = true;

        if (!isValid(source.x, source.y, input))
            return -1;
        if (!isValid(desti.x, desti.y, input))
            return -1;

        int row[] = {-1, 0, 0, 1, -1, -1, 1, 1};
        int column[] = {0, -1, 1, 0, 1, -1, -1, 1};

        while (!queue.isEmpty()) {
            GridPoint gp = queue.poll();
            Points node = gp.points;
            if (node.x == desti.x && node.y == desti.y)
                return gp.dis;
            //for node - not visited neighbor to be added in q
            for (int i = 0; i < 8; i++) {

                int rr = node.x + row[i]; // neighbours row
                int cc = node.y + column[i];// neighbours column

                //input[rr][cc]==0 means only match path which have value 0
                if (isValid(rr, cc, input) && !valiadted[rr][cc] && input[rr][cc] == 0) {

                    valiadted[rr][cc] = true;
                    // Points pt = new Points(rr, cc);
                    queue.add(new GridPoint(new Points(rr, cc), gp.dis + 1));

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        //  int input[][] = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        // int input[][] = {{0, 1}, {1, 2}, {2, 0}};


        // int input[][] = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        //  int input[][] = {{1, 2}, {2, 3}};
        int input[][] = {{1, 2}, {3}, {3}, {}};

        System.out.println("row length:: " + input.length + " column length:: " + input[0].length);
        LeetMatrix gridBFS = new LeetMatrix();

        // System.out.println("distance:: " + gridBFS.shortestPathBinaryMatrix(input));
        // System.out.println("valid path:: " + gridBFS.validPath(10, input, 7, 5));
        //System.out.println("star node:: " + gridBFS.findCenter(input));
        //  System.out.println("find judge:: " + gridBFS.findJudge(4, input));
        System.out.println("find path:: " + gridBFS.allPathsSourceTarget(input));

    }

    //https://leetcode.com/problems/find-the-town-judge/
    public int findJudge(int n, int[][] trust) {

        HashMap<Integer, Integer> y = new HashMap<>();
        HashMap<Integer, Integer> x = new HashMap<>();

        if (trust.length == 0 && n == 1)
            return n;
        int count = 0;
        for (int i = 0; i < trust.length; i++) {
            int yy = trust[i][1];
            int xx = trust[i][0];
            x.put(xx, yy);
            y.put(yy, y.get(yy) == null ? 1 : y.get(yy) + 1);
        }

        Set<Map.Entry<Integer, Integer>> a = y.entrySet();

        List<Integer> list = y.entrySet().stream()
                .filter(val -> val.getValue() == n - 1).map(key -> key.getKey()).collect(Collectors.toList());
        if (list.size() == 1 && (!x.containsKey(list.get(0)) || x.get(list.get(0)) == list.get(0))) {
            return list.get(0);
        }
        return -1;
    }

    //https://leetcode.com/problems/find-center-of-star-graph/
    public int findCenter(int[][] edges) {

        System.out.println("length:: " + edges.length);

        int x = edges[0][0];
        int y = edges[0][1];
        // for (int i = 1; i < edges.length; i++) {
        int xx = edges[1][0];
        int xy = edges[1][1];
        if (xx == y || xx == x) {
            return xx;
        } else if (xy == x || xy == y) {
            return xy;
        }
        // }
        return -1;
    }

    //EASY : By DFS Algo to find valid path
    //https://leetcode.com/problems/find-if-path-exists-in-graph/
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        LinkedList<Integer> adj[] = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int j = 0; j < edges.length; j++) {

            if (adj[edges[j][0]] != null)
                adj[edges[j][0]].add(edges[j][1]);
            // for both ways to add
            if (adj[edges[j][1]] != null)
                adj[edges[j][1]].add(edges[j][0]);// for undirected graph

        }
        Arrays.stream(adj).forEach(a -> {
            a.stream().forEach(ab -> System.out.print(ab + " , "));
            System.out.println("...");
        });
        boolean[] visited = new boolean[n];

        DFSUtils(adj, source, destination, visited);

        if (visited[destination] == true)
            return true;
        return false;
    }

    private boolean DFSUtils(LinkedList<Integer>[] adj, int source, int destination, boolean[] visited) {
        visited[source] = true;
        if (source == destination)
            return true;

        ListIterator<Integer> iterator = adj[source].listIterator();
        while (iterator.hasNext()) {
            int node = iterator.next();
            if (!visited[node]) {
                DFSUtils(adj, node, destination, visited);
            }
        }
        return false;
    }

    //https://leetcode.com/problems/all-paths-from-source-to-target/
    //Given a directed acyclic graph (DAG)
    //provide DFS for all -- topological sorting
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> innerOp = new ArrayList<>();

        LinkedList<Integer> adj[] = new LinkedList[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (adj[i] == null) {
                adj[i] = new LinkedList<>();
                for (int c = 0; c < graph[i].length; c++) {
                    adj[i].add(graph[i][c]);
                }
            }
        }// formed adjacency list

       /* for(int i=0;i<adj.length;i++){
            innerOp.add(i);
            for(int j=0;j<adj[i].size();j++){
                innerOp.add(j);
            }
            output.add(innerOp);
            innerOp = new ArrayList<>();
        }*/
        // System.out.println("op.." + output);


        boolean[] visited = new boolean[graph.length];
        dfsUtils(0, visited, innerOp, output, adj);
        System.out.println("op.." + output);
        output.add(innerOp);

        return output;
    }

    //not working
    //list - 0,1,2 and 0,1,3
    private List<Integer> dfsUtils(int i, boolean[] visited, List<Integer> innerOp, List<List<Integer>> outerOp, LinkedList<Integer>[] adj) {
        visited[i] = true;
        innerOp.add(i);

        System.out.println("inner:: " + i);
        //  innerOp.stream().forEach(a -> System.out.print(a + " ,"));

        ListIterator<Integer> iterator = adj[i].listIterator();
        if (!iterator.hasNext()) {
            System.out.println("added inner op:: " + innerOp);
            outerOp.add(innerOp);
            return new ArrayList<>();
        }

        while (iterator.hasNext()) {
            int node = iterator.next();
            //innerOp.add(node);
            System.out.println("  nodes:: " + node);
            // if (!visited[node]) { // not visited nodes for dfs
            innerOp = dfsUtils(node, visited, innerOp, outerOp, adj);
            //}
        }
        //outerOp.add(innerOp);
        System.out.println("return.." + innerOp);
        return innerOp;
    }
}
