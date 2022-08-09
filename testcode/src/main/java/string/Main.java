package string;

import java.util.*;

/**
 * @author Arti.Jadhav
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("main....");
        Main m = new Main();
        EasyEx eex = new EasyEx();
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println("op:: " + eex.mostWordsFound(sentences));

        String chars = "ABCD";
        System.out.println((int) Math.random());
        System.out.println(chars.charAt((int) Math.random() * 62));

        char[] code = new char[6];
        for (int i = 0; i < 6; i++)
            code[i] = chars.charAt((int) Math.random() * 62);

        System.out.println(String.valueOf(code));

        System.out.println("encode..");
        // System.out.println(m.encode("abasmbdasbdcd"));
        //System.out.println(m.decode("http://tinyurl.com/000000"));
        // System.out.println(m.encode("abasmbdasbdcd"));
        //System.out.println(m.decode("http://tinyurl.com/000000"));
        System.out.println("1" + m.encode("12sfdjsbfkjsdf"));
        System.out.println(m.decode("http://tinyurl.com/000000"));


        MediumEx ex = new MediumEx();
        //   lengthOfLongestSubstring(ex);
        //longestPalindrome(ex);

        // arrangeWords(ex);
        // getFoldersNames(ex);
        // System.out.println(ex.multiply("2","3"));
        // getPath();

        System.out.println("test examl");

        List list = new ArrayList<>();
        list.add("a");
        list.add("b");

        for (Iterator it = reverse(list); it.hasNext(); ) {
            Object obj = it.next();
            System.out.println(obj);
        }

        EasyEx<String> a = new EasyEx<>();
        EasyEx b = a;
    }

    public static Iterator reverse(List list){
        Collections.reverse(list);
        return list.iterator();
    }

    Map<String, String> codeDB = new HashMap<>(),
            urlDB = new HashMap<>();
    static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private String getCode() {
        char[] code = new char[6];
        for (int i = 0; i < 6; i++)
            code[i] = chars.charAt((int) Math.random() * 62);
        return "http://tinyurl.com/" + String.valueOf(code);
    }

    public String encode(String longUrl) {
        if (urlDB.containsKey(longUrl)) return urlDB.get(longUrl);
        String code = getCode();
        while (codeDB.containsKey(code)) code = getCode();
        codeDB.put(code, longUrl);
        urlDB.put(longUrl, code);
        return code;
    }

    public String decode(String shortUrl) {
        return codeDB.get(shortUrl);
    }

    private static void getPath() {
        List<String> path = new ArrayList<>();
        List<List<String>> paths = new ArrayList<>();

        path.add("London");
        path.add("New York");

        paths.add(path);
        path = new ArrayList<>();


        path.add("Sao Paulo");
        path.add("last");
        paths.add(path);
        path = new ArrayList<>();

        path.add("New York");
        path.add("Lima");
        paths.add(path);
        path = new ArrayList<>();

        path.add("Lima");
        path.add("Sao Paulo");
        paths.add(path);

        System.out.println(EasyEx.destCity(paths));
    }

    private static void getFoldersNames(MediumEx ex) {

        // String[] names = {"kaido","kaido(1)","kaido","kaido(1)"}; //op:: [kaido, kaido(1), kaido(2), kaido(1)(1)]
        String[] names = {"kaido(1)(2)", "kaido"}; //op:: "kaido(1)(2)","kaido"
        //String[] names = {"gta","gta(1)","gta","avalon"}; //op:: ["gta","gta(1)","gta(2)","avalon"]

        //  String[] names = {"wano","wano","wano","wano"};
        //  String[] names = {"kingston(0)","kingston","kingston"}; //op: ["kingston(0)","kingston","kingston(1)"]
        ex.getFolderNames(names);

    }

    private static void arrangeWords(MediumEx ex) {
        String input = "my name is Leetcode is cool";
        System.out.println("op:: " + ex.arrangeWordsNew(input));
    }

    private static void longestPalindrome(MediumEx ex) {
        //  String input="babad";
        // String input="cbbd";
        // String input="a";
        // String input="ac";
        //   String input = "ccc";
        //String input = "abcbad";
        //   String input = "labcbalabcba";
        String input = "babadada"; //"adada"


        // System.out.println(ex.lengthOfLongestSubstring(input));
        //    System.out.println(ex.lengthOfLongSubstring(input));
        // System.out.println(ex.longestPalindrome(input));
        System.out.println(ex.longestPali(input));
    }

    private static void lengthOfLongestSubstring(MediumEx ex) {
        //  String input = "abcabcbb"; //3
        //  String input = "dvdf";//3
        // String input = "pwwkew";//3
        //  String input="ohomm";//3
        //String input = "aabaab!bb";//
        // String input = "bpfbhmipx";//7
        //  String input ="ggububgvfk";//6
        String input = "dlcfuadxmycvumq";

        // System.out.println(ex.lengthOfLongestSubstring(input));
        //    System.out.println(ex.lengthOfLongSubstring(input));
        System.out.println(ex.lengthOfLongSub(input));
    }
}
