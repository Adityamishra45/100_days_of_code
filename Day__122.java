class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {

        long prefix = 1;
        long suffix = 1;
        long ans = Integer.MIN_VALUE;


        for(int i = 0; i < n; i++) {
            if(prefix == 0) {
                prefix = 1;
            }
            if(suffix == 0) {
                suffix = 1;
            }
            
            prefix = prefix*arr[i];
            suffix = suffix*arr[n-i-1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }


        return ans;
    }
}
