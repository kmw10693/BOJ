import java.io.*;
import java.util.*;

class Solution {
    int best = 1;
    List<int[]>[] adj;
    int n;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        adj = new ArrayList[n+1];
        this.n = n;
        
        for(int i=0; i<=n; i++) adj[i] = new ArrayList<>();
        
        for(int[] edge : edges) {
            int e1 = edge[0];
            int e2 = edge[1];
            int num = edge[2];
            
            adj[e1].add(new int[]{e1, e2, num});
            adj[e2].add(new int[]{e2, e1, num});
        }
        
        boolean[] infectionCnt = new boolean[n+1];
        infectionCnt[infection] = true;
        dfs(infectionCnt, k, 0);
        
        return best;
    }
    
    void dfs(boolean[] infectionCnt, int k, int lastIndex) {
        int cnt = count(infectionCnt);
        if(cnt > best) best = cnt;
        if(k <= 0) return;
        
        for(int i=1; i<=3; i++) {
            if(lastIndex == i) continue;
            dfs(eachinfect(infectionCnt, i), k-1, i);
        }
    }
    
    boolean[] eachinfect(boolean[] infectionCnt, int infidx) {
        boolean[] tmpInfection = infectionCnt.clone();
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i=1; i<=n; i++) if(tmpInfection[i]) dq.push(i);
        
        while(!dq.isEmpty()) {
            int u = dq.pop();
            for(int[] e : adj[u]) {
                if(e[2] == infidx && !tmpInfection[e[1]]) {
                    tmpInfection[e[1]] = true;
                    dq.push(e[1]);
                }
            }
        }
        return tmpInfection;
    }
    
    
    int count(boolean[] infectionCnt) {
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(infectionCnt[i]) cnt++;
        }
        return cnt;
    }
}