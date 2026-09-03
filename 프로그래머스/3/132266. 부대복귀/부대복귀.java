import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] cost = new int[n+1];
        Arrays.fill(cost, -1);
        
        cost[destination] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int nxt : graph[cur]) {
                if(cost[nxt] != -1) continue;
                cost[nxt] = cost[cur] + 1;
                q.add(nxt);
            }
        }
        
        int[] result = new int[sources.length];
        for(int i=0; i<result.length; i++) {
            int eachidx = sources[i];
            result[i] = cost[eachidx];
        }
        return result;
    }
}