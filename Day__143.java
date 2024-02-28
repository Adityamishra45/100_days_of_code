class Solution{
    int DivisibleByEight(String s){
        if(s.length()>3){
        String s1=s.substring(s.length()-3);
        int i= Integer.parseInt(s1);
        if(i%8==0)
            return 1;
            else 
            return -1;
        
      }
      else{
      int j= Integer.parseInt(s);
        if(j%8==0)
            return 1;
            else 
            return -1;
        
        }
        
    }
    
}
