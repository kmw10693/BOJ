class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];
        
        dp[0][0][0] = 1;
        
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(cityMap[r][c] == 1) continue;
                
                if(cityMap[r][c] == 0) {
                    int total = (dp[r][c][0] + dp[r][c][1]) % MOD;
                    if(r+1 < m && cityMap[r+1][c] != 1) {
                        dp[r+1][c][0] = (dp[r+1][c][0] + total) % MOD;
                    }
                    
                    if(c+1 < n && cityMap[r][c+1] != 1) {
                        dp[r][c+1][1] = (dp[r][c+1][1] + total) % MOD;
                    }
                }
                else if(cityMap[r][c] == 2) {
                    if (r + 1 < m && cityMap[r + 1][c] != 1) {
                        dp[r+1][c][0] = (dp[r+1][c][0] + dp[r][c][0]) % MOD;
                    }
                    
                    if(c+1 < n && cityMap[r][c+1] != 1) {
                        dp[r][c+1][1] = (dp[r][c+1][1] + dp[r][c][1]) % MOD;
                    }
                }
            }
        }
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}