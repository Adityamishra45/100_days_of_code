class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            int midNextValue = mountainArr.get(mid + 1);
            
            if (midValue < midNextValue) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int peakIndex = left;
        
        // Search in the left side of the mountain
        int result = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (result != -1) {
            return result;
        }
        
        return binarySearch(mountainArr, target, peakIndex, mountainArr.length() - 1, false);
    }
    

    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean increasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = increasing ? mid + 1 : left;
                right = increasing ? right : mid - 1;
            } else {
                left = increasing ? left : mid + 1;
                right = increasing ? mid - 1 : right;
            }
        }
        
        return -1;
    }
}
