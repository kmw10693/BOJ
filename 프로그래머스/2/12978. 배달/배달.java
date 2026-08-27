import java.util.*;
import java.io.*;


class Solution {
    class Node {
        int to, cost;
        
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        List<Node>[] graph = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int cost = r[2];
            
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }
        
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        
        Queue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            int curidx = cur.to;
            int curcost = cur.cost;
            if(curcost > distance[curidx]) continue;
            
            for(Node nxt : graph[curidx]) {
                int nxtcost = curcost + nxt.cost;
                
                if(nxtcost < distance[nxt.to]) {
                    distance[nxt.to] = nxtcost;
                    pq.add(new Node(nxt.to, nxtcost));
                }
            }
        }
        
        int ans = 0;
        for(int dis : distance) {
            if(dis <= K) ans++;
        }
        return ans;
    }
}