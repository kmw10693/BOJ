import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1000000000;
        
        int[] dp = new int[n];
        // a가 0개를 훔쳤을때, b의 훔친 갯수 최솟값
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int[] eachinfo : info) {
            int ainfo = eachinfo[0];
            int binfo = eachinfo[1];
            int[] next = new int[n];
            Arrays.fill(next, INF);
            
            for(int i=0; i<n; i++) {
                if(dp[i] == INF) continue;
                
                // A가 하나 훔쳤을때
                int achief = i + ainfo;
                if(achief < n) {
                    next[achief] = Math.min(next[achief], dp[i]);
                }
                
                // b가 훔쳤을때
                int bchief = dp[i] + binfo;
                if(bchief < m) {
                    next[i] = Math.min(next[i], bchief);
                }
            }
            dp = next;
        }
        
        for(int i=0; i<n; i++) {
            if(dp[i] < m) return i;
        }
        return -1;
    }
}