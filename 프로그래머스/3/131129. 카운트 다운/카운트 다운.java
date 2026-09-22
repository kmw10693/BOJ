import java.util.*;

class Solution {
    public int[] solution(int target) {
        int INF = 1_000_000;
        int[][] dp = new int[target+1][2];
        
        for(int i=1; i<=target; i++) {
            dp[i][0] = INF;
            dp[i][1] = 0;
        }
        List<int[]> scores = new ArrayList<>();
        
        for(int i=1; i<=20; i++) {
            scores.add(new int[]{i,1});
        }
        
        for(int i=1; i<=20; i++) {
            scores.add(new int[]{i*2, 0});
            scores.add(new int[]{i*3, 0});
        }
        
        scores.add(new int[]{50,1});
        
        for(int i=1; i<=target; i++) {
            for(int[] score : scores) {
                int dartScore = score[0];
                int singleOrBull = score[1];
                
                if(i < dartScore) continue;
                int prev = i - dartScore;
                
                if(dp[prev][0] == INF) continue;
                
                int dartCount = dp[prev][0] + 1;
                int singleCount = dp[prev][1] + singleOrBull;
                
                if(dartCount < dp[i][0]) {
                    dp[i][0] = dartCount;
                    dp[i][1] = singleCount;
                }
                
                else if (dartCount == dp[i][0] && singleCount > dp[i][1]) {
                    dp[i][1] = singleCount;
                }
            }
        }
        return new int[]{dp[target][0], dp[target][1]};
    }
}