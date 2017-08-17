public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        // This is the case where we've gotta add a new digit to the front
        // because adding one added a new digit place (ex: 999 -> 1000).
        int[] newNumber = new int [n + 1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}