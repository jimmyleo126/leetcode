package leetcode.queue.stack;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis {

    private Stack<Character> characters = new Stack<>();

    private Map<Character, Character> characterMap = new HashMap<>();

    public Parenthesis() {
        characterMap.put('(', ')');
        characterMap.put('[', ']');
        characterMap.put('{', '}');
    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return false;
        }
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                characters.push(aChar);
            } else {
                if (characters.isEmpty()) {
                    return false;
                }
                Character popChar = characters.pop();
                if (characterMap.get(popChar) != aChar) {
                    return false;
                }
            }
        }
        if (!characters.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        System.out.println(parenthesis.isValid("(("));
    }

}
