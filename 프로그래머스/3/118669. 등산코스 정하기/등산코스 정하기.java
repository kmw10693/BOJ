import java.util.*;
import java.io.*;

class Solution {
    class Node {
        int to, intensity;
        Node(int to, int intensity) {
            this.to = to;
            this.intensity = intensity;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Node>[] graph = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int intensity = path[2];
            
            graph[from].add(new Node(to, intensity));
            graph[to].add(new Node(from, intensity));
        }
        
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.intensity - b.intensity);
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
       
        for(int gate : gates) {
            distance[gate] = 0;
            pq.add(new Node(gate, 0));
        }
        
        boolean[] issummit = new boolean[n+1];
        for(int summit : summits) {
            issummit[summit] = true;
        }
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int curnode = cur.to;
            int curintensity = cur.intensity;
            
            if(curintensity > distance[curnode]) continue;
            if(issummit[curnode]) continue;
            
            for(Node nxt : graph[curnode]) {
                int maxintensity = Math.max(curintensity, nxt.intensity);
                if(maxintensity < distance[nxt.to]) {
                    distance[nxt.to] = maxintensity;
                    pq.add(new Node(nxt.to, maxintensity));
                }
            }
        }
        
        Arrays.sort(summits);
        
        int summitnumber = -1;
        int minintensity = Integer.MAX_VALUE;
        
        for(int summit : summits) {
            if(distance[summit] < minintensity) {
                summitnumber = summit;
                minintensity = distance[summit];
            }
        }
        
        return new int[]{summitnumber, minintensity};
    }
}