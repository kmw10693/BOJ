import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int maxA = info.length * 3;
        int INF = Integer.MAX_VALUE;
        
        int[] dp = new int[maxA + 1];
        Arrays.fill(dp, INF);
        
        dp[0] = 0;
        
        for(int[] in : info) {
            int aTrace = in[0];
            int bTrace = in[1];
            
            int[] ndp = new int[maxA + 1];
            Arrays.fill(ndp, INF);
            
            for(int a=0; a<=maxA; a++) {
                if(dp[a] == INF) continue;
                int b = dp[a];
                
                int na = a + aTrace;
                if(na <= maxA && b < ndp[na]) ndp[na] = b;
                
                int nb = b + bTrace;
                if(nb < ndp[a]) ndp[a] = nb;
            }
            dp = ndp;
        }
        
        int ans = -1;
        for(int a=0; a<n; a++) {
            if(dp[a] < m) {
                ans = a;
                break;
            }
        }
        return ans;
    }
}