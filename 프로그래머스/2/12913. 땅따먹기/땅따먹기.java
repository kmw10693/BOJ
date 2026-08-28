import java.util.*;
import java.io.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int[][] dp = new int[n][m];
        for(int i=0; i<m; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                
                for(int k=0; k<m; k++) {
                    if(k == j) continue;
                    dp[i][j] = Math.max(dp[i-1][k] + land[i][j], dp[i][j]);
                }
             }
        }
        
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<m; i++) {
            ans = Math.max(dp[n-1][i], ans);
        }
        return ans;
    }
}