 int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        // Complete the function
        HashMap<Integer,Integer> hs=new HashMap<>();
        int sum=0;
        int ans=0;
        hs.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=a[i];
            int rem=((sum%k)+k)%k;
            if(hs.containsKey(rem)){
                int prev=hs.get(rem);
                ans=Math.max(ans,i-prev);
            }
            else{
                hs.put(rem,i);
            }
        }
        return ans;
  
    }
