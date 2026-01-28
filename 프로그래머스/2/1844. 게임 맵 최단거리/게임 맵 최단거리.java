import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        // 우선순위 큐 bfs
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,0,0));
        maps[0][0] = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.x == n-1 && cur.y == m-1) return cur.dis + 1;
            
            for(int i=0; i<4; i++) {
                int nxtX = cur.x + dx[i];
                int nxtY = cur.y + dy[i];
                
                if(nxtX < 0 || nxtX >= n || nxtY < 0 || nxtY >= m) continue;
                if(maps[nxtX][nxtY] != 1) continue;
                maps[nxtX][nxtY] = cur.dis + 1;
                q.add(new Node(nxtX, nxtY, cur.dis+1));
            }
        }
        printArr(n, m, maps);
        return -1;
    }
    
    public void printArr(int n, int m, int[][] maps) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
    }
    class Node implements Comparable<Node> {
        int x, y, dis;
        
        @Override
        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
        
        Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}