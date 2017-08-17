import java.util.Arrays;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            if (target <= nums[0])
                return 0;
            else
                return 1;
        }
        int index =  Arrays.binarySearch(nums, target);

        // Binary search returns (-(insertionPoint) - 1) if it can't find the key. Just reverse
        // this math to find the normal insertion point.
        if (index < 0) return (-1 * index) - 1;

        return index;
    }
}