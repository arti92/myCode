package example;

/**
 * @author Arti.Jadhav
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Example Problems Main");
        // palindrome(); // eg.125
        //  countGoodTriplets();//eg.1534
        //   numJewelsInStones();//eg.771

        //   isAnagram();
        //lengthOfLastWord();
        EasyExamples easy = new EasyExamples();
        //  System.out.println("index:: "+easy.strStr("hello","lo"));

        String[] strs = {"flower", "flow", "flight"};
        //["cir","car"]
        //   String[] strs = {"cir","car"};
        System.out.println(easy.longestCommonPrefixBetter(strs));
        //  MediumExamples me = new MediumExamples();
        // numTeams(me);
        // teleNumb(me);

    }

    private static void lengthOfLastWord() {
        EasyExamples easy = new EasyExamples();
        int length = easy.lengthOfLastWord("Hello World");
        System.out.println("length:: " + length);
    }


    private static void isAnagram() {
        EasyExamples easy = new EasyExamples();
        easy.isAnagram("anagram", "nagaram");
    }

    private static void teleNumb(MediumExamples me) {
        me.letterCombinations("23");
    }

    private static void numTeams(MediumExamples me) {
        int[] rating = {2, 5, 3, 4, 1};
        me.numTeams(rating);
    }

    private static void numJewelsInStones() {
        EasyExamples easy = new EasyExamples();
        easy.numJewelsInStones("z", "ZZ");
    }

    private static void countGoodTriplets() {
        EasyExamples easy = new EasyExamples();
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7;
        int b = 2;
        int c = 3;
        easy.countGoodTriplets(arr, a, b, c);
    }

    private static void palindrome() {
        EasyExamples easy = new EasyExamples();
        String input = "0p";
        Boolean output = easy.isPalindrome(input);
        System.out.println("palindorome output: " + output);
    }
}
