// Shuffle the Array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int start = 0;

        for (int i = 0; i < n; i++) {
            arr[start] = nums[i];
            start += 2;
        }
        start = 1;
        for (int i = n; i < 2 * n; i++) {
            arr[start] = nums[i];
            start += 2;
        }

        return arr;
    }
}
