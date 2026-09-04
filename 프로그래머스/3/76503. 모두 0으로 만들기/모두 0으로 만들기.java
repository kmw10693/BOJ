import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        List<Integer>[] arr = new ArrayList[n];
        
        for(int i=0; i<arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        
        long[] numbers = new long[n];
        long sum = 0;
        for(int i=0; i<n; i++) {
            numbers[i] = a[i];
            sum += numbers[i];
        }
        if(sum != 0) return -1;
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            arr[u].add(v);
            arr[v].add(u);
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        q.add(0);
        
        boolean[] isvisited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            isvisited[cur] = true;
            order.add(cur);
            
            for(int nxt : arr[cur]) {
                if(isvisited[nxt]) continue;
                parent[nxt] = cur;
                q.add(nxt);
            }
        }
        
        
        long answer = 0;
        for(int i=order.size()-1; i>0; i--) {
            int curidx = order.get(i);
            long num = numbers[curidx];            
            answer += Math.abs(num);
            
            numbers[parent[curidx]] += num;
        }
        
        return answer;
    }
}