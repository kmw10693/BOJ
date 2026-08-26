import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int ans = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++) {
            List<Integer>[] arr = new ArrayList[n+1];
            
            for(int j=1; j<=n; j++) arr[j] = new ArrayList<>();
            
            for(int j=0; j<wires.length; j++) {
                if(i == j) continue;
                
                arr[wires[j][0]].add(wires[j][1]);
                arr[wires[j][1]].add(wires[j][0]);
            }
            boolean[] visited = new boolean[n+1];
            int subtotal = dfs(1, arr, visited);
            ans = Math.min(ans, Math.abs(subtotal - (n - subtotal)));
        }
        return ans;
    }
    
    public int dfs(int start, List<Integer>[] arr, boolean[] visited) {
        visited[start] = true;
        int total = 1;
        
        for(int next : arr[start]) {
            if(!visited[next]) {
                total += dfs(next, arr, visited);
            }
        }
        
        return total;
    }
}