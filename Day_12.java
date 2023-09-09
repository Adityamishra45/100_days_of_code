// Binary Search

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            } else if (nums[1] == target) {
                return 1;
            }
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}

