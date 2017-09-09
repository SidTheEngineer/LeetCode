class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target <= 0 || candidates.length == 0) return null;
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        findSolutions(solutions, new ArrayList<>(), candidates, target, 0);
        return solutions;
    }

    public void findSolutions(List<List<Integer>> solutions, List<Integer> currSolution, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) solutions.add(new ArrayList<>(currSolution));
        else {
            for (int i = start; i < candidates.length; i++) {
                currSolution.add(candidates[i]);
                findSolutions(solutions, currSolution, candidates, target - candidates[i], i);
                currSolution.remove(currSolution.size() - 1);
            }
        }
    }
}