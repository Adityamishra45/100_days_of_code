public static int posOfRightMostDiffBit(int m, int n)
    {
            
       for(int i=0;i<32;i++){
            int mr=(m&(1<<i))==0?0:1;
            int nr=(n&(1<<i))==0?0:1;
            if(mr!=nr)
            {
                return i+1;
            }
        }
        return -1;       
            
    }
