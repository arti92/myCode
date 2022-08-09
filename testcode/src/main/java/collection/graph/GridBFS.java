package collection.graph;

import java.util.LinkedList;

/**
 * @author Arti.Jadhav
 */
/*
From grid find the shortest pah using BFS
 */
public class GridBFS {
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

        queue.add(new GridPoint(source, 0));
        valiadted[source.x][source.y] = true;

        if (!isValid(source.x, source.y, input))
            return -1;
        if (!isValid(desti.x, desti.y, input))
            return -1;

        int row[] = {-1, 0, 0, 1};
        int column[] = {0, -1, 1, 0};

        while (!queue.isEmpty()) {
            GridPoint gp = queue.poll();
            Points node = gp.points;
            if (node.x == desti.x && node.y == desti.y)
                return gp.dis;
            //for node - not visited neighbor to be added in q
            for (int i = 0; i < 4; i++) {

                int rr = node.x + row[i]; // neighbours row
                int cc = node.y + column[i];// neighbours column

                //input[rr][cc] means the matched condisions , or values -- input[rr][cc] ==1 means chek only for matrix values 1
                // not given means check in entire matrix

                if (isValid(rr, cc, input) && valiadted[rr][cc] != true) {
                    valiadted[rr][cc] = true;
                    // Points pt = new Points(rr, cc);
                    queue.add(new GridPoint(new Points(rr, cc), gp.dis + 1));

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int input[][] = {
                {1, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0}};

        System.out.println("row length:: " + input.length + " column length:: " + input[0].length);
        GridBFS gridBFS = new GridBFS();

        Points source = new Points(0, 0); // indices
        Points desti = new Points(3, 3); // indices
        int dist = gridBFS.getBFSGrid(source, desti, input);
        System.out.println("distance:: " + dist);

    }

}
