class Solution {
    public int smallestSubstring(String S) {
        // Code here
        
        int char0=-1,char1=-1,char2 =-1;
        int ans=S.length();
        int flag = -1;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='0'){
                char0=i;
            }
            else if(S.charAt(i)=='1'){
                char1=i;
            }
            else if(S.charAt(i)=='2'){
                char2=i;
            }
            
            if(char0 !=-1 & char1!=-1 & char2!=-1){
                ans = Math.min(ans, i-Math.min(char0,Math.min(char1,char2))+1);
                flag = ans;
            }
        }
        return flag;
        
    }
}
