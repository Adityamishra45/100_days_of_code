class Solution {
    static int singleElement(int[] arr , int N) {
        int ones = 0, twos = 0;
        for (int i = 0; i < N; i++) {
            twos |= ones & arr[i];
            ones ^= arr[i];
            int commonBits = ones & twos;
            ones &= ~commonBits;
            twos &= ~commonBits;
        }
        return ones;
    }

}
