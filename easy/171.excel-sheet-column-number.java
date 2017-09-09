/*

AAA -> 55
ABA -> 

*/


class Solution {
    public int titleToNumber(String s) {
        // A-Z = 10-35 in Unicode
        if (s.length() == 1) return Character.getNumericValue(s.charAt(0)) - 9;

        int runningExponent = 0;
        int runningTotal = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            runningTotal += Math.pow(26, runningExponent++) * (Character.getNumericValue(s.charAt(i)) - 9);
        }

        return runningTotal;
    }
}