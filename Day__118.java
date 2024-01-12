public int editDistance(String s, String t) {
        // Code here
        int sl = s.length();
        int tl = t.length();
        int[][] dp = new int[sl+1][tl+1];
        for(int i=0;i<=tl;i++){
            dp[0][i] = i;
        }
        for(int i=0;i<=sl;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<=sl;i++){
            for(int j=1;j<=tl;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(1 + dp[i-1][j],
                    Math.min(1 + dp[i][j-1],1 + dp[i-1][j-1]));
                }
            }
        }
        return dp[sl][tl];
    }
