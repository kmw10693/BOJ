import java.util.function.Function;

class Solution {
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        int n = depth.length;
        
        long[][] dp = new long[n+2][n+2];
        int[][] choice = new int[n+2][n+2];
        
        for(int len=1; len <= n; len++) {
            for(int left = 1; left + len - 1 <=n; left++) {
                int right = left + len -1;
                dp[left][right] = Integer.MAX_VALUE;
                
                for(int k=left; k<=right; k++) {
                    long leftcost = 0;
                    long rightcost = 0;
                    
                    if(left <= k-1) {
                        leftcost = dp[left][k-1];
                    }
                    
                    if(k+1 <= right) {
                        rightcost = dp[k+1][right];
                    }
                    
                    long cost = depth[k-1];
                    long worstcost = cost + Math.max(leftcost, rightcost);
                    
                    if(worstcost < dp[left][right]) {
                        dp[left][right] = worstcost;
                        choice[left][right] = k;
                    }
                }
            }
        }
        
        int left = 1;
        int right = n;
        
        while(left <= right) {
            int col = choice[left][right];
            int result = excavate.apply(col);
            
            if(result == 0) {
                return col;
            }
            
            if(result == -1) {
                right = col - 1;
            }
            
            else {
                left = col + 1;
            }
        }
        
        return 0;
    }
}