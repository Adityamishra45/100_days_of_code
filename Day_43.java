class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();

        findCombination(0, target, candidates, currentSubset, result);
        return result;
    }

    public static void findCombination(int index, int target, int[] candidates, List<Integer> currentSubset, List<List<Integer>> result) {

        if(index == candidates.length) {
            if(target == 0) {
                result.add(new ArrayList<>(currentSubset));
            }
            return;
        }

        if(candidates[index] <= target) {
            currentSubset.add(candidates[index]);

            findCombination(index, target - candidates[index], candidates, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }

        findCombination(index + 1, target, candidates, currentSubset, result);
    }
}
