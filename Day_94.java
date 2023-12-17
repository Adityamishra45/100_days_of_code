class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int prev_sum = 0;
        int curr_sum = 0;
        for(int i=0;i<n;i++) {
            int temp = Math.max(prev_sum + arr[i], curr_sum);
            prev_sum = curr_sum;
            curr_sum = temp;
        }
        return curr_sum;
    }
}
