import java.util.HashMap;
import java.util.Stack;

import javax.print.attribute.HashAttributeSet;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StackType;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;

        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        Stack<Character> memory = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (pairs.containsKey(bracket)) {
                memory.push(bracket);
            } else {
                if (memory.isEmpty()) return false;
                char openBracket = memory.pop();
                if (pairs.get(openBracket) != bracket) return false;
            }
        }
        return memory.isEmpty();
    }
}