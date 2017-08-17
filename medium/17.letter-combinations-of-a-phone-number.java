public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        LinkedList<String> solution = new LinkedList<>();

        // Start off with an empty string in our solutions so we have something to remove
        // and add to.
        solution.add("");

        // Here's the trick. The indeces of mapping correspond to the digits on the phone, their
        // values being the corresponding letters that can come from the digit.
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            int convertedInt = Character.getNumericValue(digits.charAt(i));
            // Go through the whole queue, adding every possible char for the next digit (i).
            // When the new head is longer than i, we know we're done with the previous combinations.
            // The length of the combination will be at most the length of the digit.
            while (solution.peek().length() == i) {
                String previousCombo = solution.remove();
                for (char c : mapping[convertedInt].toCharArray())
                    solution.add(previousCombo + c);
            }
        }
        return solution;
    }
}