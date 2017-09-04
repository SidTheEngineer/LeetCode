

// Hashmap of O(n) space, number:howManyTimesNumberAppears. Return number that
// appears >= n/2 times, this can be completed in O(n) time.

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>(nums.length);
        int retVal = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (!freq.containsKey(nums[i])) {
                freq.put(nums[i], 1);
            } else {
                int digitFrequency = freq.get(nums[i]);
                freq.put(nums[i], digitFrequency + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int dig = e.getValue().intValue();
            // We need to cast to a float and check against the ceiling of the result
            // value so as to account for odd length of array of nums.
            if (dig >= Math.ceil((float)nums.length / 2)) retVal =  e.getKey(); 
        }
        return retVal;
    }
}