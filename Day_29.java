class Solution {
    public int integerBreak(int n) {
       if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int t = n / 3;
        int rem = n % 3;

        if (rem == 1) {
            t -= 1; 
            rem = 4; 
        } else if (rem == 0) {
            rem = 1;
        }

        return (int) (Math.pow(3, t) * rem);        
    }
}
