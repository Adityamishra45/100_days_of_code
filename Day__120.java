class Solution {
    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static Pair<Boolean, Integer> traverse(TreeNode root, int targetVal, int[] targetSubtreeHeight, int[] maxIndirect) {
        if (root == null) {
            return new Pair<>(false, 0);
        } else if (root.val == targetVal) {
            targetSubtreeHeight[0] = Math.max(height(root.left), height(root.right));
            return new Pair<>(true, 0);
        } else {
            Pair<Boolean, Integer> leftResult = traverse(root.left, targetVal, targetSubtreeHeight, maxIndirect);
            Pair<Boolean, Integer> rightResult = traverse(root.right, targetVal, targetSubtreeHeight, maxIndirect);
            if (leftResult.first) {
                maxIndirect[0] = Math.max(maxIndirect[0], 1 + leftResult.second + rightResult.second);
                return new Pair<>(true, 1 + leftResult.second);
            } else if (rightResult.first) {
                maxIndirect[0] = Math.max(maxIndirect[0], 1 + leftResult.second + rightResult.second);
                return new Pair<>(true, 1 + rightResult.second);
            } else {
                return new Pair<>(false, 1 + Math.max(leftResult.second, rightResult.second));
            }
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        int[] targetLeafLen = new int[1];
        int[] maxIndirect = new int[1];
        traverse(root, start, targetLeafLen, maxIndirect);
        return Math.max(maxIndirect[0], targetLeafLen[0]);
    }
}
