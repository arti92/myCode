package string.MediumEx2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arti.Jadhav
 */

/**
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
 */
public class FindReplacePattern {
    public static void main(String[] args) {

        FindReplacePattern findReplacePattern = new FindReplacePattern();
        String[] words = {"abc", "cbb"};
        findReplacePattern.findAndReplacePatterns(words, "xyx");
    }

    //https://leetcode.com/problems/find-and-replace-pattern/
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matchedOp = new ArrayList<>();
        char[] split = pattern.toCharArray();
        List<List<Integer>> matchList = getInternalMatch(split);
        System.out.println("matched:: " + matchList);

        for (int i = 0; i < words.length; i++) {
            char[] wrd = words[i].toCharArray();
            if (words[i].length() == split.length)
                if (matchList.equals(getInternalMatch(wrd)))
                    matchedOp.add(words[i]);
        }
        System.out.println("matchedOp:: " + matchedOp);

        return matchedOp;
    }

    private List<List<Integer>> getInternalMatch(char[] split) {

        List<List<Integer>> matchList = new ArrayList<>();
        for (int j = 0; j < split.length; j++) {
            List<Integer> internal = new ArrayList<>();
            int val = j + 1;
            for (int i = j + 1; i < split.length; i++) {
                if (String.valueOf(split[j]).equalsIgnoreCase(String.valueOf(split[i])))
                    internal.add(i);
            }
            internal.add(j);
            matchList.add(internal);
        }
        return matchList;
    }

    //best solution
    public List<String> findAndReplacePatterns(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) res.add(word);
        }
        System.out.println("matchedOp:: " + res);
        return res;
    }

    boolean check(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
           // System.out.println(a.indexOf(a.charAt(i)) +" :: "+b.indexOf(b.charAt(i)));
           // System.out.println( a.indexOf(a.charAt(i)) +" :: "+b.indexOf(b.charAt(i)));
            if (a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i))) return false;
        }
        return true;
    }

}
