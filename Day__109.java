class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long window_sum = 0;
        for(int i = 0;i<(int)k;i++){
            window_sum += a[i];
        }
        if(n == k) return window_sum;
        
        long maxSum = window_sum;
        long otherSum = 0;
        for(int i = (int)k;i<n;i++){
            window_sum += a[i];
            otherSum += a[i-(int)k];
            window_sum -= a[i-(int)k];
            
            if(otherSum >=0){
                maxSum = Math.max(window_sum + otherSum, maxSum);
            }
            else{
                
                maxSum = Math.max(maxSum,window_sum);
                otherSum = 0;
            }
        }
        return maxSum;
    }
}
