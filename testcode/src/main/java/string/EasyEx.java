package string;

import java.util.*;

/**
 * @author Arti.Jadhav
 */
public class EasyEx<T>{

    public static String destCity(List<List<String>> paths) {
        System.out.println(paths);
        if (paths.size() < 0)
            return "";

        if (paths.size() < 2)
            return paths.get(0).get(1);


        Map<String, Integer> destination = new LinkedHashMap<>();

        //1st to check all next
        for (int i = 0; i < paths.size(); i++) {
            List<String> combination = new ArrayList<>(); //new path will start
            combination.add(paths.get(i).get(0));
            combination.add(paths.get(i).get(1));
            String source = paths.get(i).get(1);
            recursiveCall(source, paths, combination);
            System.out.println("one comb:: " + combination);

            String comb = combination.get(combination.size() - 1);//last desti of one path
            if (destination.containsKey(comb))
                destination.put(comb, destination.get(comb) + 1);
            else
                destination.put(comb, 0);
            if (combination.size() + 1 > paths.size())
                break;
        }


        System.out.println("destination map:: " + destination);
        Iterator<Map.Entry<String, Integer>> itr = destination.entrySet().iterator();

        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : destination.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    private static void recursiveCall(String source, List<List<String>> paths, List<String> combination) {
        for (int j = 0; j < paths.size(); j++) {
            if (source.equalsIgnoreCase(paths.get(j).get(0))) {
                source = paths.get(j).get(1);
                combination.add(paths.get(j).get(1));// adding as new destination to maitain the graph for all
                // destinations
                recursiveCall(source, paths, combination);
                if (combination.size() > paths.size())
                    break;
            }

        }
    }

    public int mostWordsFound(String[] sentences) {

        if (sentences.length <= 0)
            return 0;
        int maxCount = 0;
        for (String sent : sentences) {
            String[] wordCount = sent.split(" ");
            if (maxCount < wordCount.length)
                maxCount = wordCount.length;
        }
        return maxCount;
    }

}
