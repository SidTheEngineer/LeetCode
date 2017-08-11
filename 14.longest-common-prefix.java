// Trick here: using String.indexOf(). This method returns the index within
// String of the first ocurrence of the specified substring.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            // While the substring is NOT a prefix (it needs to start at 0)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                // If there is no common prefix common between the current two strings being compared;
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}