import java.util.*;
import java.io.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        int anscost = 0;
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        for(int[] c : costs) {
            int from = c[0];
            int to = c[1];
            int cost = c[2];
            
            if(find(from) != find(to)) {
                union(from, to);
                answer++;
                anscost += cost;
            }
            if(answer == n-1) {
                break;
            }
        }
        return anscost;
    }
    
    public int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        
        if(p1 != p2) {
            parent[p2] = p1;
        }
    }
}