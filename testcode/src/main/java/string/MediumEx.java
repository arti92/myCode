package string;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Arti.Jadhav
 */
public class MediumEx {

    public int lengthOfLongSub(String input) {
        int count = 0;
        String s = "";
        char[] ch = input.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (s.contains(Character.toString(ch[i]))) {
                if (s.length() < (s.indexOf(ch[i]) + 1))
                    break;
                s = s.substring(s.indexOf(ch[i]) + 1);
                if (!s.equalsIgnoreCase(Character.toString(ch[i]))) {
                    s += ch[i];
                    input = input.substring(input.indexOf(ch[i]));
                } else
                    input = input.substring(input.indexOf(ch[i]) + 1);

            } else {
                s += ch[i];
                if (count < s.length())
                    count = s.length();
            }
        }
        return count;
    }


    public String longestPalindrome(String input) {

        int count = 0;
        String s = "";
        char[] ch = input.toCharArray();
        List<String> palindrom = new ArrayList<>();

        String palStr = "";
        if (isPalindrome(input))
            return input;

       /* if(input.length()==1)
            return input;*/

        for (int i = 0; i < ch.length; i++) {
            if (s.contains(Character.toString(ch[i]))) {
                s += ch[i];
                System.out.println("check palindrom :: " + s);
                if (isPalindrome(s)) {
                    System.out.println("palindrom: " + s);
                    if (palStr.length() < s.length())
                        palStr = s;
                    palindrom.add(s);
                } //else {
                s = s.charAt(0) == ch[i] ? s : s.replaceFirst(Character.toString(s.charAt(0)), "");
                /*if (s.contains(Character.toString(ch[i]))) {
                    if (isPalindrome(s)) {
                        System.out.println("same palindrom: " + s);
                        if (palStr.length() < s.length())
                            palStr = s;
                        palindrom.add(s);
                    }
                }*/
                System.out.println("next:: " + s);
            } else {
                s += ch[i];
                if (count < s.length()) {
                    count = s.length();
                }

            }
        }
        System.out.println("list:: " + palindrom.toString());

       /* for(String s1:palindrom ){

        }*/
        if (palStr.isEmpty())
            palStr += ch[input.length() - 1];
        return palStr;
    }


    public String longestPali(String input) {

        int count = 0;
        String s = "";
        char[] ch = input.toCharArray();
        List<String> palindrom = new ArrayList<>();

        String palStr = "";
        if (isPalindrome(input))
            return input;

       /* if(input.length()==1)
            return input;*/

        for (int i = 0; i < ch.length; i++) {
            s = "";
            for (int j = i; j < ch.length; j++) {
                s += ch[j];
                if (s.contains(Character.toString(ch[i])) && s.length() > 1) {
                    System.out.println("j:: " + j);
                    if (palStr.length() > s.length()) {
                        System.out.println("dnt check: " + s);
                     /* if(j>palStr.length()-j+i)
                          break;
                        j=palStr.length()-j+i;
                        s=input.substring(i,j+1);
                        System.out.println("i: "+i+" j: "+j+" s:: "+s);*/
                        //i+=palStr.length()-1;
                        //   j+=i+palStr.length()-1;
                    } else if (isPalindrome(s)) {
                        System.out.println("add palindrom: " + s);
                        if (palStr.length() < s.length())
                            palStr = s;
                        // input.subst;
                    }
                }
            }


        }
        System.out.println("list:: " + palindrom.toString());

       /* for(String s1:palindrom ){

        }*/
        if (palStr.isEmpty())
            palStr += ch[input.length() - 1];
        return palStr;
    }

    private boolean checkPalindrom(String s) {
        char[] strChr = s.toCharArray();
        int j = strChr.length;
        for (int i = 0; i < strChr.length / 2; i++) {
            if (strChr[i] != strChr[j])
                return false;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]+", "");
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {

            if (!Character.toString(s.charAt(i)).equalsIgnoreCase(Character.toString(s.charAt(j))))
                return false;
        }
        return true;
    }

    public String arrangeWords(String text) {

        text = text.toLowerCase();
        String[] chars = text.split(" ");

        Arrays.sort(chars, (s1, s2) -> s1.length() - s2.length());
        System.out.println("chars:: " + chars);

        HashMap<Integer, String> map = new HashMap<>();
        final String[] newText = {""};
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
            String newChar = map.get(chars[i].length()) != null ? map.get(chars[i].length()) + " " : "";
            newChar += chars[i];
            map.put(chars[i].length(), newChar);
        }
        System.out.println("map:: " + map);

        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> newText[0] += x.getValue() + " ");

        String op = newText[0];
        op = Character.toString(op.charAt(0)).toUpperCase() + op.substring(1);
        //   op = op.replaceFirst(op.charAt(1),Character.toString(op.charAt(0)).toUpperCase().charAt(0));
        System.out.println("op:: " + op);
        op = op.trim();
        return op;
    }

    public String arrangeWordsNew(String text) {

        text = text.toLowerCase();
        String[] chars = text.split(" ");

        Arrays.sort(chars, (s1, s2) -> s1.length() - s2.length());
        Arrays.stream(chars).forEach(a -> System.out.println(a));
        LinkedList<String> originalList = new LinkedList<>();
        Collections.addAll(originalList, chars);
        System.out.println("list:: " + originalList);
        HashMap<Integer, String> map = new HashMap<>();
        for (String txt : originalList) {
            map.put(txt.length(), map.get(txt.length()) + " " + txt);
        }
        System.out.println();
        System.out.println("map:: " + "");
       /* String newStr = "";
        for (String n : map.values()) {
          n = n.replaceAll("null","");
                newStr += n;
        }*/
        String newStr = map.values().stream()
                .map(n -> n.replaceAll("null", ""))
                .collect(Collectors.joining(""));
        System.out.println("a" + newStr.substring(0, 2).toUpperCase());

        newStr = newStr.replaceFirst(newStr.substring(0, 2), newStr.substring(0, 2).toUpperCase());
        return newStr;
    }

    public String arrangeWordsOld(String text) {

        text = text.toLowerCase();
        String[] chars = text.split(" ");
        List<String> newTextList = new ArrayList<>();

        //  String[] newText = new String[];
        int l = 0;
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
            String a = "";
            if (newTextList.size() > chars[i].length())
                a = newTextList.get(chars[i].length()) != null ? newTextList.get(chars[i].length()) + " " : "";
            a = a + chars[i];

            newTextList.add(chars[i].length(), a);

        }

        newTextList.forEach(a -> System.out.println("a: " + a));
        String op = "";
        for (String s : newTextList) {
            if (s != null)
                op += s + " ";
        }
        op = Character.toString(op.charAt(0)).toUpperCase() + op.substring(1);
        System.out.println("op:: " + op.trim());
        return op;
    }

    public String[] getFolderNames(String[] names) {
        String[] op = new String[names.length];
        List<String> opList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {

            String nameWo = names[i];
            System.out.println(nameWo.replaceAll("(.*)\\(", "").replaceAll("\\)", ""));
            int count = (int) opList.stream().filter(li -> !li.replaceAll("(.*)\\(", "").replaceAll("\\)", "")
                            .equalsIgnoreCase("0"))
                    .filter(l -> !l.contains(")("))
                    .filter(l -> l.split("\\(")[0].equalsIgnoreCase(nameWo)).count();
            System.out.println("emp:: " + nameWo.contains(")("));
            System.out.println(nameWo.split("\\(")[0]);
            System.out.println("count:: " + count);
            if (count > 0)
                opList.add(nameWo + "(" + count + ")");
            else {
                int count2 = (int) opList.stream().filter(l -> l.equalsIgnoreCase(nameWo)).count();
                if (count2 > 0)
                    opList.add(nameWo + "(" + count2 + ")");
                else
                    opList.add(nameWo);
            }

            System.out.println(opList);
        }

        return opList.toArray(new String[0]);
    }


    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length() + num2.length()];

        //multiply each digit and sum at the corresponding positions
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            sb.insert(0, mod);
        }

        //remove front 0's
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    //https://leetcode.com/problems/design-tinyurl
    //http://tinyurl.com/4e9iAk
    public String encode(String longUrl) {
        String[] startUrl = longUrl.split("https://");
        String[] comUrl = startUrl[1].split(".com");


        return longUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl;

    }
}
