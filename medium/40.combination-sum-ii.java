class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (target <= 0) return null;
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backTrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void backTrack(List<List<Integer>> solutions, List<Integer> currSolution, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0 && !solutions.contains(currSolution)) {
            solutions.add(new ArrayList<>(currSolution));
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                currSolution.add(candidates[i]);
                backTrack(solutions, currSolution, candidates, target - candidates[i], i + 1);
                currSolution.remove(currSolution.size() - 1);
            }
        }
    }
}