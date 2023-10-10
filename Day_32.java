class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                numbers.add(i);
            }
        }
        if (k <= numbers.size()) {
            int number = numbers.get(k - 1);
            return number;
        } 
        else 
        {
            return -1; 
        }
    }
}
