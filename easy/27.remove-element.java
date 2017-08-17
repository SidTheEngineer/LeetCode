import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // If we don't need to remove it, move it to the front and increase
                // the counter we have that represents the length of the new array;
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }
}