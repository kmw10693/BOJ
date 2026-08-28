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
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            
            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        
        Queue<Node> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Node(1, 0));
        distance[1] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.cost > distance[cur.to]) continue;
            
            for(Node nxt : graph[cur.to]) {
                int nxtcost = cur.cost + nxt.cost;
                if(nxtcost < distance[nxt.to]) {
                    distance[nxt.to] = nxtcost;
                    pq.add(new Node(nxt.to, nxtcost));
                }
            }
        }
        
        int ans = 0;
        for(int i=1; i<=N; i++) {
            if(distance[i] <= K) ans++;
        }
        
        return ans;
    }
}