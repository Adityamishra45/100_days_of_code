class Solution {
    private int MOD = (int) Math.pow(10, 9) + 7;

    public int numberOfSequence(int n, int[] sick) {
        List<Integer> segments = new ArrayList<>();
        int startSegmentLen = sick[0];
        int endSegmentLen = n - sick[sick.length - 1] - 1;
        // System.out.println("start, end, segments: " + startSegmentLen + "," + endSegmentLen + ",");

        for (int i = 1; i < sick.length; i++) {
            if (sick[i] - sick[i-1] - 1 > 0) {
                segments.add(sick[i] - sick[i-1] - 1);
            }
            // System.out.println(segments.get(segments.size() - 1));
        }

        int[] fac = prepareFactorial(n);
        int[] pow2 = preparePow2(n);

        int totalNotSick = n - sick.length;

        int ans = fac[totalNotSick];

        // order within segment does not matter outside of segment;
        // opening and closing segments may be unbounded so possible sequence is 1
        ans = multiply(ans, inverse(fac[startSegmentLen])); 
        ans = multiply(ans, inverse(fac[endSegmentLen]));

        for (int segment : segments) {
            ans = multiply(ans, pow2[segment - 1]); // ordering within segment to get sick
            ans = multiply(ans, inverse(fac[segment])); // order within segment does not matter outside of segment
        }

        return ans;
    }

    private int inverse(int n) {
        return exp(n, MOD - 2);
    }

    private int exp(int base, int exp) {
        int res = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp /= 2;
        }
        return res;
    }

    private int multiply(int a, int b) {
        return (int) ((1L * a * b) % MOD);
    }

    private int[] preparePow2(int n) {
        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = multiply(pow2[i - 1], 2);
        }
        return pow2;
    }

    private int[] prepareFactorial(int n) {
        int[] fac = new int[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = multiply(fac[i - 1], i);
        }
        return fac;        
    }
}
