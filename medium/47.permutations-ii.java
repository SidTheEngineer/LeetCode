class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return solutions;

        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), solutions, used);
        return solutions;
    }

    public void backTrack(int[] nums, List<Integer> currSolution, List<List<Integer>> solutions, boolean[] used) {
        if (currSolution.size() == nums.length) {
            solutions.add(new ArrayList<>(currSolution));
            return;
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
                used[i] = true;
                currSolution.add(nums[i]);
                backTrack(nums, currSolution, solutions, used);
                used[i] = false;
                currSolution.remove(currSolution.size() - 1);
            }
        }
    }
}