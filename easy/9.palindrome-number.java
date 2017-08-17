public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x % 10 == x) return true;
        
        // Idea: start from both ends of the number, retrieving and chopping
        // off the digits wnile comparing to check for palindrome.
        int divider = 1;

        // This is how we find how many digits are in the number.
        while (x / divider >= 10) {
            divider *= 10;
        }

        while (x != 0) {
            int left = x / divider;
            int right = x % 10;
            if (left != right) return false;

            // x % divider chops off the front digit, / 10 chops off the last digit.
            x = (x % divider) / 10;

            // We removed 2 numbers from x, so we need to adjust our divider by 2 positions.
            divider /= 100;
        }
        return true;
    }
}