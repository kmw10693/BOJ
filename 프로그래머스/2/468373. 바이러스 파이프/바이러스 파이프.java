import java.util.*;
import java.io.*;

class Solution {
    List<Integer>[][] sortpipes;
    int ans = -1;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        
        sortpipes = new ArrayList[4][n+1];
        for(int i=0; i<4; i++) {
            for(int j=0; j<=n; j++) {
                sortpipes[i][j] = new ArrayList<>();
            }
        }
        
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            
            sortpipes[type][x].add(y);
            sortpipes[type][y].add(x);
        }
        
        dfs(n, k, 1, new HashSet<>(Set.of(infection)));
        return ans;
    }
    
    void dfs(int n, int k, int infcounts, Set<Integer> infections) {
        if(k == 0) {
            ans = Math.max(ans, infcounts);
            return;
        }
        
        for(int i=1; i<=3; i++) {
            Set<Integer> eachinfections = bfs(infections, i);
            dfs(n, k-1, eachinfections.size(), eachinfections);
        }
    }
    
    Set<Integer> bfs(Set<Integer> infections, int targetsort) {
        Set<Integer> tempinfections = new HashSet<>(infections);
        Queue<Integer> q = new ArrayDeque<>(infections);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int nxt: sortpipes[targetsort][cur]) {
                if(!tempinfections.contains(nxt)) {
                    tempinfections.add(nxt);
                    q.add(nxt);
                }
            }
        }
        
        return tempinfections;
    }
}