package collection;

import java.util.Stack;

/**
 * @author Arti.Jadhav
 */
public class StackExample {
    public boolean isValid(String s) {

        MyStack<String> st = new MyStack<>();

        char[] ch = s.toCharArray();
        try {
            for (int i = 0; i < ch.length; i++) {
                String cha = Character.toString(ch[i]);

                if (cha.equalsIgnoreCase("}") && st.peek().equalsIgnoreCase("{")) {

                    st.pop();
                } else if (cha.equalsIgnoreCase("]") && st.peek().equalsIgnoreCase("[")) {
                    st.pop();
                } else if (cha.equalsIgnoreCase(")") && st.peek().equalsIgnoreCase("(")) {
                    st.pop();
                } else {
                    st.push(cha);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (st.isEmpty())
            return true;

        return false;
    }

    public int scoreOfParentheses(String s) {

        int index = 0;
        MyStack<String> st = new MyStack<>();

        char[] ch = s.toCharArray();
        try {
            for (int i = 0; i < ch.length; i++) {
                String cha = Character.toString(ch[i]);

                if (cha.equalsIgnoreCase("}") && st.peek().equalsIgnoreCase("{")) {
                    st.pop();
                    index++;
                } else if (cha.equalsIgnoreCase("]") && st.peek().equalsIgnoreCase("[")) {
                    st.pop();
                    index++;
                } else if (cha.equalsIgnoreCase(")") && st.peek().equalsIgnoreCase("(")) {
                    st.pop();
                    index++;
                } else {
                    st.push(cha);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return index;
        }
        if (st.isEmpty())
            return index;

        return index;
    }
}
