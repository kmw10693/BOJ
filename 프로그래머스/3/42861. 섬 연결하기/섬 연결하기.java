import java.util.*;
import java.io.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        int answer = 0;
        int count = 0;
        
        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            if(find(a) != find(b)) {
                union(a, b);
                
                answer += c;
                count++;
                
                if(count == n-1) {
                    return answer;
                }
            }
        }
        return -1;
    }
    
    public int find(int x) {
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b) {
        if(find(a) != find(b)) {
            parent[find(b)] = find(a);
        }
    }
}