package dynamicProgramming;

/**
 * @author Arti.Jadhav
 */
public class GridTraveler {
    public static void main(String[] args) {
        System.out.println("grid travel");
        int[][] cache = {};
        //  System.out.println(gridTravelDistance(1, 1));//1
        // System.out.println(gridTravelDistance(2, 3));//3
        //System.out.println(gridTravelDistance(3, 2));//3

        System.out.println(gridTravelDistanceMemo(1, 1, cache));//1
        System.out.println(gridTravelDistanceMemo(2, 3, cache));//3
        System.out.println(gridTravelDistanceMemo(3, 2, cache));//3
        System.out.println(gridTravelDistanceMemo(3, 3, cache));//6
        //  System.out.println(gridTravelDistanceMemo(18, 18, cache));//2333606220
    }

    /**
     * check how many ways require traveling grid of 2*3 (only can move down and right)
     * lets see as tree, left for down(row) travel and right for right(column) travel
     * so for 2*3 it will take 3 ways -  right right down, down right right, right down right
     */
    /**
     * 2,3
     * 1,3                2,2
     * 0,3    1,2        1,2       2,1
     * 0,2  1,1   0,2  1,1  1,1  2,0
     * 0 means empty grid
     * 1,1 ,means reached at destination
     */
    private static int gridTravelDistance(int row, int col) {

        if (row == 0 || col == 0)
            return 0;
        if (row == 1 && col == 1)
            return 1;

        return gridTravelDistance(row - 1, col) + gridTravelDistance(row, col - 1);
    }

    //Memoization
    private static int gridTravelDistanceMemo(int row, int col, int[][] cache) {

        String keys = row + "," + col;

        if (row == 0 || col == 0)
            return 0;
        if (row == 1 && col == 1)
            return 1;
      //  System.out.println("cache" +cache[row][col]);
        if (cache[row][0] >0 && cache[0][col] >0)
            return cache[row][col];

        return cache[row][col] = gridTravelDistanceMemo(row - 1, col, cache) + gridTravelDistanceMemo(row, col - 1, cache);

    }
}
