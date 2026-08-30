import java.util.*;
import java.io.*;

class Solution {
    class Node {
        int from, to;
        Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    public int solution(int n, int[][] computers) {
        List<Node>[] graph = new ArrayList[n+1];
        for(int i=1; i<=computers.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=computers.length; i++) {
            for(int j=1; j<=computers[0].length; j++) {
                if(i != j && computers[i-1][j-1] == 1) {
                    graph[i].add(new Node(i, j));
                    graph[j].add(new Node(j, i));
                } 
            }
        }   
     
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int ans = 0;
        
        for(int i=1; i<=computers.length; i++) {
            if(!visited[i]) {
                ans++;
                q.add(i);
                
                while(!q.isEmpty()) {
                    // visited[1] = true
                    int cur = q.poll();
                    visited[cur] = true;
                    
                    // graph[1]
                    for(Node nxt : graph[cur]) {
                        if(!visited[nxt.to]) {
                            q.add(nxt.to);
                        }
                    }
                }
            }
        }
        return ans;
    }
}