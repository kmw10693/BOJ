import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        int[] distances = new int[n+1];
        Arrays.fill(distances, -1);
        distances[1] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
        
            for(int nxt : graph[cur]) {
                if(distances[nxt] != -1) continue;
                distances[nxt] = distances[cur] + 1;
                q.add(nxt);
            }
        }
        
        int maxdistance = -1;
        for(int dis : distances) {
            maxdistance = Math.max(maxdistance, dis);
        }
        
        int ans = 0;
        for(int dis : distances) {
            if(maxdistance == dis) ans++;
        }
        return ans;
    }
}