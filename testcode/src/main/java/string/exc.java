package string;

/**
 * @author Arti.Jadhav
 */
public class exc {

    public static void main(String[] args) {
        try {
            exc.recursivePrint(1);
        } catch (OutOfMemoryError e) {
            System.err.println("ouch!");
        }

        System.out.println("see");
    }

    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);
        if (num == 0)
            return;
        else
            recursivePrint(++num);
    }

}
