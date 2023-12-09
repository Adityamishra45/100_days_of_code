class Solution {
    static int digitsSum(int num){
        int sum = 0;
        while(num >0){
            sum += (num%10);
            num /= 10;
        }
        return sum;
    }
    static int smithNum(int n) {
        // code here
        int num = n;
        int digitSum = digitsSum(num);
        num = n;
        int i = 2;
        int primeFactorSum = 0;
        while(num != 0 && i <= num && i != n){
            if(num%i == 0){
                int val = digitsSum(i);
                primeFactorSum += val;
                num /= i;
                
            }else{
                i++;
            }
        }
        if(digitSum == primeFactorSum)
            return 1;
        return 0;
    }
};
