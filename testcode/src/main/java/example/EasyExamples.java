package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class EasyExamples {
    public static int abs(int a) {
        return (a < 0) ? -a : a;
    }

    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^A-Za-z0-9]+", "");
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {

            if (!Character.toString(s.charAt(i)).equalsIgnoreCase(Character.toString(s.charAt(j))))
                return false;
        }
        return true;
    }

    /**
     * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
     * <p>
     * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
     * <p>
     * 0 <= i < j < k < arr.length
     * |arr[i] - arr[j]| <= a
     * |arr[j] - arr[k]| <= b
     * |arr[i] - arr[k]| <= c
     * Where |x| denotes the absolute value of x.
     * <p>
     * Return the number of good triplets.
     *
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int aO = abs(arr[i] - arr[j]);
                    int bO = abs(arr[j] - arr[k]);
                    int cO = abs(arr[i] - arr[k]);
                    if (aO <= a && bO <= b && cO <= c) {
                        System.out.println(aO + "a" + bO + "b" + cO);
                        System.out.println(arr[i] + "i" + arr[j] + "j" + arr[k]);
                        count++;
                    }
                }
            }
        }
        System.out.println("count:: " + count);

        return count;
    }

    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you
     * have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are
     * also jewels.
     * <p>
     * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case
     * sensitive, so "a" is considered a different type of stone from "A".
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        for (int i = 0; i < jewels.length; i++) {
            for (int j = 0; j < stones.length; j++) {
                if (J.charAt(i) == S.charAt(j))
                    count++;
            }
        }

        System.out.println("count:: " + count);
        return count;
    }

    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     * <p>
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     *
     * @param s
     * @param t
     * @return
     */
    //taking tooo much time
    public boolean isAnagramOld(String s, String t) {
        boolean isAnagram = false;

        if (s.length() != t.length())
            return false;

        char[] tArray = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < tArray.length; j++) {
                if (s.charAt(i) == tArray[j]) {
                    tArray[j] = ' ';
                    break;
                }
            }
        }

        t = String.valueOf(tArray);

        if (t.trim().isEmpty())
            isAnagram = true;

        System.out.println("isAnagram:: " + isAnagram);
        return isAnagram;
    }


    public boolean isAnagram(String s, String t) {
        boolean isAnagram = true;

        if (s.length() != t.length())
            return false;

        int[] a = new int[256];
        int[] b = new int[256];

        for (char c : s.toCharArray()) {
            int index = (int) c;
            a[index]++;
        }

        for (char c : t.toCharArray()) {
            int index = (int) c;
            b[index]++;
        }

        for (int i = 0; i < 256; i++) {
            if (a[i] != b[i]) {
                isAnagram = false;
                break;
            }
        }

        System.out.println("isAnagram:: " + isAnagram);
        return isAnagram;
    }

    /**
     * Input: s = "Hello World"
     * Output: 5
     */

    public int lengthOfLastWord(String s) {
        if (s.trim().isEmpty())
            return 0;

        String[] splitData = s.trim().split(" ");
        System.out.println(splitData);
        System.out.println(splitData.length);
        System.out.println(splitData[splitData.length - 1]);

        return splitData[splitData.length - 1].length();
    }


    /**
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * https://leetcode.com/problems/implement-strstr/
     */
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle))
            return -1;
        return haystack.indexOf(needle);
    }

    /**
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * https://leetcode.com/problems/longest-common-prefix/
     */
    public String longestCommonPrefix(String[] strs) {

        HashMap<Integer, String> map = new LinkedHashMap<>();

        String smallStr = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (smallStr.length() > strs[i].length())
                smallStr = strs[i];
        }

        String partialString = "";

        String matchString = "";
        for (int i = smallStr.length(); i >= 0; i--) {

            partialString = smallStr.substring(i) + partialString;
            smallStr = smallStr.substring(0, i);

            if (!smallStr.isEmpty()) {
                //  if (smallStr.length() > partialString.length())
                //     matchString = getMatch(strs, smallStr);
                //   else if (matchString.isEmpty() && smallStr.length() == partialString.length()) {
                matchString = getMatch(strs, smallStr);
                if (!matchString.isEmpty())
                    map.put(matchString.length(), matchString);
                if (matchString.isEmpty() || matchString.length() < partialString.length())
                    matchString = getMatch(strs, partialString);
                if (!matchString.isEmpty())
                    map.put(matchString.length(), matchString);

                //} else if (matchString.isEmpty())
                //    matchString = getMatch(strs, partialString);
            }
        }

        System.out.println("small:: " + map);
       /* String match = "";
        for (int i = map.size(); i > 0; i--) {
            match = map.get(i);
            if(!match.isEmpty())
                break;
        }
        System.out.println("match:... "+match);*/

        if (map.size() == 0)
            return "";
        else
            return map.get(map.size());
    }

    private String getMatch(String[] strs, String smallStr) {
        for (String s : strs) {
            if (!s.startsWith(smallStr))
                return "";
        }
        return smallStr;
    }

    public String longestCommonPrefixBetter(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            System.out.println("in " + strs[i].indexOf(prefix));
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;

    }
}
