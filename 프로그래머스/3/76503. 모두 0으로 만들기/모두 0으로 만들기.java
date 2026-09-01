import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        int[] parent = new int[a.length];
        long sum = 0;
        for(int i=0; i<a.length; i++) {
            parent[i] = -1;
            sum += a[i];
        }
        
        long[] weight = new long[a.length];
        for(int i=0; i<a.length; i++) {
            weight[i] = a[i];
        }
        
        if(sum != 0) return -1;
        List<Integer>[] graph = new ArrayList[a.length];
        for(int i=0; i<a.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        Stack<Integer> s = new Stack<>();
        s.push(0);
        parent[0] = 0;
        List<Integer> seq = new ArrayList<>();
        
        while(!s.isEmpty()) {
            int cur = s.pop();
            seq.add(cur);
            
            for(int nxt : graph[cur]) {
                if(parent[nxt] != -1) continue;
                parent[nxt] = cur;
                s.push(nxt);
            }
        }
        long ans = 0;
        for(int i=seq.size()-1; i>=0; i--) {
            ans += Math.abs(weight[seq.get(i)]);
            weight[parent[seq.get(i)]] += weight[seq.get(i)];
        }
        return ans;
    }
}