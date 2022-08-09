package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arti.Jadhav
 */
public class MediumExamples {

    /**
     * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
     * <p>
     * You have to form a team of 3 soldiers amongst them under the following rules:
     * <p>
     * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
     * A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
     * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
     *
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        int count = 0;

        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if ((rating[i] < rating[j] && rating[i] < rating[k] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[i] > rating[k] && rating[j] > rating[k])) {
                        System.out.println(rating[i] + "," + rating[j] + "," + rating[k]);
                        System.out.println("-----------------");
                        System.out.println(i + "," + j + "," + k);
                        count++;
                    }
                }
            }
        }
        System.out.println("count:: " + count);
        return count;
    }

    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     * Return the answer in any order.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> numArray = new ArrayList<>();
        digits = digits.replaceAll("[^2-9]", "");

        if (digits.length() <= 0 || digits.contains("1") || digits.length() > 4)
            return numArray;

        char[] chars = digits.toCharArray();
        Map<Character, String> alpha = new HashMap<>();
        alpha.put('2', "abc");
        alpha.put('3', "def");
        alpha.put('4', "ghi");
        alpha.put('5', "jkl");
        alpha.put('6', "mno");
        alpha.put('7', "pqrs");
        alpha.put('8', "tuv");
        alpha.put('9', "wxyz");
        List<String> newArray = new ArrayList<>();
        for (Character digi : chars) {
            newArray = combineChar(newArray, alpha.get(digi).toCharArray());
        }
        System.out.println("newArray:: " + newArray);
        return newArray;
    }

    private List<String> combineChar(List<String> newArray, char[] val) {
        List<String> oldArray = new ArrayList<>();
        if (newArray.isEmpty())
            for (int j = 0; j < val.length; j++) {
                oldArray.add(Character.toString(val[j]));
            }
        else {
            for (int i = 0; i < newArray.size(); i++) {
                for (int k = 0; k < val.length; k++) {
                    oldArray.add(newArray.get(i) + Character.toString(val[k]));//adding Character.toString give less time
                }
            }
        }
        return oldArray;
    }
}
