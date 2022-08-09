package plan1;

/**
 * @author Arti.Jadhav
 */
public class App {
    public static void main(String[] args) {

        Easy easy = new Easy();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        // System.out.println("binary search:: "+easy.search(nums, 3));

        //System.out.println(easy.firstBadVersion(2));
        System.out.println("serch and insert:: " + easy.searchInsert(nums, 4));

    }
}
