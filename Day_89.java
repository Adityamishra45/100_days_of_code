int countX(int L, int R, int X) {
        // code here
        int count=0,mod=0,temp=0;
        for(int i=L+1;i<R;i++)
        {
            temp=i;
            while(temp>0)
            {
                mod=temp%10;
                if(mod==X){
                    count++;
                }
                temp=temp/10;
            }
        }
        
        return count;
    }
