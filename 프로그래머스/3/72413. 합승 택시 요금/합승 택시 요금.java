import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = 1_000_000_000;
        
        int[][] dist = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for(int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            
            dist[u][v] = cost;
            dist[v][u] = cost;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        long answer = Long.MAX_VALUE;
        for(int k=1; k<=n; k++) {
            long cost = (long) dist[s][k] + dist[k][a] + dist[k][b];
            answer = Math.min(answer, cost);
        }
        return (int) answer;
        
    }
}