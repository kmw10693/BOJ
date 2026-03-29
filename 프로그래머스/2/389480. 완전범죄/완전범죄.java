import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1_000_000_000;
        
        // dp[a] = A 흔적이 a일 때 가능한 B 흔적의 최소값
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];
            
            int[] next = new int[n];
            Arrays.fill(next, INF);
            
            for (int a = 0; a < n; a++) {
                if (dp[a] == INF) continue;
                
                // 1. A도둑이 훔치는 경우
                int nextA = a + aTrace;
                if (nextA < n) {
                    next[nextA] = Math.min(next[nextA], dp[a]);
                }
                
                // 2. B도둑이 훔치는 경우
                int nextB = dp[a] + bTrace;
                if (nextB < m) {
                    next[a] = Math.min(next[a], nextB);
                }
            }
            
            dp = next;
        }
        
        for (int a = 0; a < n; a++) {
            if (dp[a] < m) return a;
        }
        
        return -1;
    }
}