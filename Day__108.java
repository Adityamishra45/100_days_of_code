class Solution {
 public static boolean isPossible(int N, int[] coins) {
       int total = Arrays.stream(coins).sum();
        boolean[][] dp = new boolean[N + 1][2025];

        // Base case: It is always possible to achieve a sum of 0.
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        // Bottom-up DP
        for (int i = 1; i <= N; i++) {
            for (int sum = 0; sum <= 2024; sum++) {
                // Exclude the current coin
                dp[i][sum] = dp[i - 1][sum];

                // Include the current coin if it doesn't exceed the target sum
                if (sum >= coins[i - 1]) {
                    dp[i][sum] |= dp[i - 1][(sum - coins[i - 1]) % 2024];
                }
            }
        }

        // Check if it is possible to achieve a valid sum
        return dp[N][2024] || dp[N][0] || dp[N][20];
    }
}
