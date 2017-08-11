import java.util.HashMap;

// Given a roman numeral, convert it to an integer.
// Input is guaranteed to be within the range from 1 to 3999/

// Symbols:
// I = 1
// V = 5
// X = 10
// L = 50
// C = 100
// D = 500
// M = 1000

// Solution: Starting from the back and working forwards is probably easier
// as we can add or subtract from the sum based on if the current character
// value is smaller than the previous one. This solution is O(n) time and 
// constant space using a HashMap of size 7 (number of Roman Numerals there are).

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> nums = new HashMap<>();
        nums.put('I', 1);
        nums.put('V', 5);
        nums.put('X', 10);
        nums.put('L', 50);
        nums.put('C', 100);
        nums.put('D', 500);
        nums.put('M', 1000);

        int prevCharValue = -1;
        int sum = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currCharVal = nums.get(s.charAt(i));
            if (prevCharValue != -1 && currCharVal < prevCharValue) {
                sum -= currCharVal;
            } else {
                sum += currCharVal;
            }

            prevCharValue = currCharVal;
        }
        return sum;
    }
}