package others;

public class LongestPalindromicSubsequence_最长回文子序列 {

    public static int longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i < n-1) {
                dp[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 2 : 1;
            }
        }
        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0, j = length-1; j < n; i++,j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

}
