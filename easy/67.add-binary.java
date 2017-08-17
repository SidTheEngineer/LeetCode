// 1010
// 1011
// 1010

public class Solution {
    public String addBinary(String a, String b) {
        // Become familiar with StringBuilder, it has a lot of useful string
        // manipulation methods.
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            // Using - '0' converts a character to an int w/o using a method.
            // We only add the number to our sum if there are numbers to add
            // (the index is >= 0)
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            // Modding by 2 allows us to add the correct value in binary to the sum,
            // since there are 4 different numbers it could be (either 0, 1, 2, or 3)
            sb.append(sum % 2);
            carry = sum / 2;
        }
        // If we have left over carry by the time we reach the end of the string,
        // we need to append it to the string.
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}