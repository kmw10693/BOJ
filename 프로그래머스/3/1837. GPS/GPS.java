import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
            graph[i].add(i);
        }
        
        for(int[] edge : edge_list) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int INF = 1_000_000;
        
        int[][] dp = new int[k][n+1];
        
        for(int i=0; i<k; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][gps_log[0]] = 0;
        for(int time=1; time<k; time++) {
            for(int prev = 1; prev<=n; prev++) {
                if(dp[time-1][prev] == INF) continue;
                
                for(int next: graph[prev]) {
                if(time == k-1 && next != gps_log[k-1]) continue;
                int cost = gps_log[time] == next ? 0 : 1;
                dp[time][next] = Math.min(dp[time][next], dp[time-1][prev] + cost);
            }
            }
        }
        
        int answer = dp[k - 1][gps_log[k - 1]];
        return answer == INF ? -1 : answer;
    }
}