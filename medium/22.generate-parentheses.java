/*

The idea here is that we have n number of right and left parentheses and we 
need to use them to make up correct well-formed parentheses. We can solve
this problem using recursion (using a helper function).

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return null;
        List<String> list = new ArrayList<>();
        recursivelyGenerate("", list, n, n);
        return list;

    }

    public void recursivelyGenerate(String subList, List<String> list, int numLeft, int numRight) {
        // Case where the current subList is not well-formed.
        if (numLeft > numRight) return;

        if (numLeft > 0) recursivelyGenerate(subList + "(", list, numLeft-1, numRight);
        if (numRight > 0) recursivelyGenerate(subList + ")", list, numLeft, numRight-1);

        if (numLeft == 0 && numRight == 0) {
            list.add(subList);
            return;
        }
    }
}