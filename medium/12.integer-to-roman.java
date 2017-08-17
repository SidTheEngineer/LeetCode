import java.util.HashMap;
import java.util.TreeMap;

// Examples:
// 1954 -> MCMLIV
// 1990 -> MCMXC
// 2014 -> MMXIV

// For this problem, we can use a data structure called a TreeMap.
// A TreeMap is a HashMap that stores it's keys in ascending order
// and has extra methods that can be used accordingly. In
// particular, the TreeMap.floorKey() method will be especially helpful.

public class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, String> nums = new TreeMap<>();
        // Using just the single character numerals could cause trouble.
        // Example 4 -> IIII instead of IV if we didn't pre-add 4 to
        // our map.
        nums.put(1000, "M");
        nums.put(900, "CM");
        nums.put(500, "D");
        nums.put(400, "CD");
        nums.put(100, "C");
        nums.put(90, "XC");
        nums.put(50, "L");
        nums.put(40, "XL");
        nums.put(10, "X");
        nums.put(9, "IX");
        nums.put(5, "V");
        nums.put(4, "IV");
        nums.put(1, "I");

        if (nums.containsKey(num)) return nums.get(num);

        return toRoman(nums, num);
    }

    public static String toRoman(TreeMap<Integer, String> map, int number) {
        int num = map.floorKey(number);
        // Base case
        if (num == number) return map.get(num);

        // This covers the case of having smaller roman numerals in front
        // of larger ones to represent numbers that do not have a roman
        // numeral character (like 4 -> IV).
        return map.get(num) + toRoman(map, number - num);
    }
}