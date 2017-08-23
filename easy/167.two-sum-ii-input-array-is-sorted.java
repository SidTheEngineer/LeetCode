class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int sum = 0;
        int[] indeces = new int[] { left, right };

        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{ left + 1, right + 1 };
            if (sum < target) ++left;
            if (sum > target) --right;
        }

        return indeces;
    }
}