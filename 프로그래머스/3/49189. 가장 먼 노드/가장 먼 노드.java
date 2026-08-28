import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge) {
            int from = e[0];
            int to = e[1];
            
            graph[from].add(to);
            graph[to].add(from);
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        
        Queue<Integer> q = new LinkedList<>();
        distance[1] = 0;
        q.add(1);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int nxt : graph[cur]) {
                if(distance[nxt] != -1) continue;
                distance[nxt] = distance[cur] + 1;
                q.add(nxt);
            }
        }
        int maxdis = Integer.MIN_VALUE;
        
        for(int i=1; i<=n; i++) {
            maxdis = Math.max(maxdis, distance[i]);
        }
        
        int ans = 0;
        for(int i=1; i<=n; i++) {
            if(maxdis == distance[i]) ans++;
        }
        return ans;
    }
}