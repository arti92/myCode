package array.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class Main {

    //items[i] = [typei, colori, namei]
    public static void main(String[] args) {
        System.out.println("easy array code");
        Main mn = new Main();

        List<String> item = new ArrayList<>();
        item.add("phone");
        item.add("blue");
        item.add("pixel");
        List<List<String>> items = new ArrayList<>();
        items.add(item);

        item = new ArrayList<>();
        item.add("phone");
        item.add("silver");
        item.add("phone");
        items.add(item);

        // System.out.println(mn.countMatches(items, "type", "phone"));

        int[][] image = {{1, 1, 0}, {1, 0, 1}};

        System.out.println(mn.flipAndInvertImage(image));
    }

    /**
     * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
     * Output: 1
     * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count = 0;
        for (List<String> item : items) {
            if (ruleKey.equalsIgnoreCase("type") && ruleValue.equalsIgnoreCase(item.get(0))) {
                count++;
            }
            if (ruleKey.equalsIgnoreCase("color") && ruleValue.equalsIgnoreCase(item.get(1))) {
                count++;
            }
            if (ruleKey.equalsIgnoreCase("name") && ruleValue.equalsIgnoreCase(item.get(2))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
     * Output: [[1,0,0],[0,1,0],[1,1,1]]
     * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
     */
    public int[][] flipAndInvertImage(int[][] image) {

        int[][] img = new int[image.length][image[0].length];

        for (int r = 0; r < image.length; r++) {
            System.out.println("row");
            int col = 0;
            for (int c = image[0].length - 1; c > -1; c--) {
                System.out.println("old" + image[r][c]);
                if(image[r][c]==1)
                    img[r][col]=0;
                else
                    img[r][col]=1;
                System.out.println("new" + img[r][col]);
                col++;
            }
        }

        return img;
    }
}
