import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] match = new boolean[n+1][n+1];
        
        for(int[] result : results) {
            int from = result[0];
            int to = result[1];
            match[from][to] = true;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(match[i][k] && match[k][j]) match[i][j] = true;
                }
            }
        }
        
        int ans = 0;
        for(int i=1; i<=n; i++) {
            int eachmatch = 0;
            for(int j=1; j<=n; j++) {
                if(i == j) continue;
                if(match[i][j] || match[j][i]) eachmatch++;
            }
            if(eachmatch == n-1) ans++;
        }
        return ans;
    }
}