class Solution
{
        //add code here.
        public static int maxSubsetXOR(int arr[], int N)
    {
        int res=0;
        Arrays.sort(arr);
        while(true)
        {
            int max=arr[N-1];
            for(int i=0;i<N;i++)
            {
                    if(max<arr[i])
                    {
                        max=arr[i];
                    }
            }
            if(max==0)
            {
                return res;
            }
            res=Math.max(res,res^max);
            for(int i=0;i<N;i++)
            {
                    arr[i]=Math.min(arr[i],arr[i]^max);
            }
        }
    }
    
}
