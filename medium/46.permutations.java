class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        backTrack(nums, new ArrayList<>(), solutions);
        return solutions;
    }

    public void backTrack(int[] nums, List<Integer> currSolution, List<List<Integer>> solutions) {
        if (currSolution.size() == nums.length)
            solutions.add(new ArrayList<>(currSolution));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (currSolution.contains(nums[i])) continue;
                currSolution.add(nums[i]);
                backTrack(nums, currSolution, solutions);
                currSolution.remove(currSolution.size() - 1);
            }
        }
    }
}