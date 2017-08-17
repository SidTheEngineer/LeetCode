public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() < 2) return true;

        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)) && i < j) ++i;
            while (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j)) && i < j) --j;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;

            ++i;
            --j;
        }
        
        return true;
    }
}