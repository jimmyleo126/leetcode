package leetcode.queue;

import java.util.Stack;

public class DecodeString {



    public String decodeString(String s) {
        Stack<Character> characters = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ']') {
                char temp;
                StringBuilder str = new StringBuilder();
                while ((temp = characters.pop()) != '[') {
                    str.append(temp);
                }
                StringBuilder strDigit = new StringBuilder();
                while (!characters.isEmpty() && Character.isDigit((temp = characters.peek()))) {
                    strDigit.append(temp);
                    characters.pop();
                }

                int size = Integer.valueOf(strDigit.reverse().toString());
                for (int i = 0; i < size; i++) {
                    char[] tempstr = str.toString().toCharArray();
                    for (int i1 = tempstr.length - 1; i1 >= 0; i1--) {
                        characters.push(tempstr[i1]);
                    }
                }
            }else {
                characters.push(aChar);
            }
        }
        String result = "";
        for (Character character : characters) {
            result += character;
        }
        return result;
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("100[leetcode]"));

    }

}
