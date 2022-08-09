package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestArray {
    private static final String inputFile = "C:\\Users\\Shrikant.Mulik\\Documents\\Jio\\Open_api";
    private static final List<String> classes = Arrays.asList(new String[]{"'number'", "'array'", "'object'", "'string'", "'boolean'"});


    public static void main(String[] args) throws IOException {

        File file = new File(inputFile);
        for (File fileName : file.listFiles()) {
            if (fileName.isFile())
                doProcess(fileName);
        }

        System.out.println("Done");


//	      String pattern = "type: \\'(.*?)\\'";
//	      Set<String> dataTypes= new HashSet<>();
//
//	      // Create a Pattern object
//	      Pattern r = Pattern.compile(pattern);
//
//	      // Now create matcher object.
//	      Matcher m = r.matcher(line);
//	   
//	      
//	      while (m.find()) {
//	    	  System.out.println("Found value: "+m.group().replaceAll("\\'", ""));
//	    	  
//	    	  dataTypes.add(m.group().replaceAll("\\'", ""));
//	    	 }
//	      if (m.find( )) {
//	         System.out.println("Found value: " + m.group(0) );
//	         System.out.println("Found value: " + m.group(1) );
//	         System.out.println("Found value: " + m.group(2) );
//	      }else {
//	         System.out.println("NO MATCH");
//	      }

        //   System.out.println("Data::"+dataTypes.toString());
    }

    private static void doProcess(File fileName) throws IOException {
        String line = new String(Files.readAllBytes(Paths.get(fileName.getAbsolutePath())));

        for (String className : classes) {
            line = line.replaceAll(className, className.replaceAll("\'", ""));
        }

        Files.write(Paths.get(fileName.getAbsolutePath().replaceAll(".yaml", "-v1.yaml")), (line).getBytes(), StandardOpenOption.CREATE);

    }

    static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }


    static String doUpperCase(String name) throws IOException {


        // create two substrings from name
        // first substring contains first letter of name
        // second substring contains remaining letters
        String firstLetter = name.substring(0, 1);
        String remainingLetters = name.substring(1, name.length());

        // change the first letter to uppercase
        firstLetter = firstLetter.toUpperCase();

        // join the two substrings
        return firstLetter + remainingLetters;

    }


    /*
     * public static void main(String[] args) { int [] array= {3,2,2,3}; int
     * input=5;
     *
     *
     *
     *
     * //calculateLength(array,input);
     *
     * //calculateLengthCollection(array,input);
     *
     * calculateWhileLoop(array,input);
     *
     * for(int a:array) { System.out.println("data main::"+a); }
     *
     * }
     */
    private static int calculateWhileLoop(int[] array, int input) {
        int counter = 0;

        for (int value : array) {
            if (value != input) {
                counter++;
            }
        }

        int count = 0;
        int nextCount = 1;
        while (true) {
            try {
                if (array[count] == input) {
                    array[count] = array[nextCount];
                    ++nextCount;
                } else {
                    ++nextCount;
                    ++count;
                }

                if (count == array.length)
                    break;

            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }

        }
        return counter;
    }

    private static void calculateLengthCollection(int[] array, int input) {


        List<Integer> collect = Arrays.stream(array)
                .mapToObj(Integer::valueOf).collect(Collectors.toList());

        collect.removeIf(d -> d.equals(new Integer(input)));

        for (int i = 0; i < collect.size(); i++) {
            array[i] = collect.get(i);
        }


    }

    private static int calculateLength(int[] array, int input) {
        int counter = 0;
        String output = "";
        for (int value : array) {
            if (value != input) {
                output += "#" + value;
                counter++;

            }
        }


        for (int i = 0; i < counter; i++) {
            array[i] = Integer.parseInt(output.split("#")[i + 1]);
        }


        return counter;
    }
}
