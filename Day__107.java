class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String , Integer> num = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            num.put(arr[i],num.getOrDefault(arr[i],0)+1);
            
        }
        String str[] = new String[2];
        int max=Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> e: num.entrySet())
        {
            if(e.getValue()>max)
            {
                str[0]=e.getKey();
                str[1]=Integer.toString(e.getValue());
                max=e.getValue();
            }
            if(e.getValue()==max)
            {
                if(str[0].compareTo(e.getKey())>0)
                {str[0]=e.getKey();
                str[1]=Integer.toString(e.getValue());}
            }
        }
        return str;
    }
}
