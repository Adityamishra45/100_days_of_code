class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int n2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[n2] = nums[i];
                n2++;
            }
        }
        for (int i = n2; i < n; i++) {
            nums[i] = 0;
        }
    }
}
