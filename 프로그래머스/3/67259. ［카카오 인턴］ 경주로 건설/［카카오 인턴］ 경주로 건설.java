import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    class Node {
        int x, y, dir, cost;
        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] cost = new int[n][n][4];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        for(int dir=0; dir<4; dir++) {
            cost[0][0][dir] = 0;
            pq.add(new Node(0, 0, dir, 0));
        }
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(cur.cost > cost[cur.x][cur.y][cur.dir]) continue;
            
            for(int nxtdir = 0; nxtdir < 4; nxtdir++) {
                int nxtx = cur.x + dx[nxtdir];
                int nxty = cur.y + dy[nxtdir];
                
                if(nxtx < 0 || nxtx >= n || nxty < 0 || nxty >= n) continue;
                if(board[nxtx][nxty] == 1) continue;
                
                int nxtcost = 0;
                if(nxtdir == cur.dir) {
                    nxtcost = cur.cost + 100;
                } else {
                    nxtcost = cur.cost + 600;
                }
                
                if(nxtcost < cost[nxtx][nxty][nxtdir]) {
                    cost[nxtx][nxty][nxtdir] = nxtcost;
                    pq.add(new Node(nxtx, nxty, nxtdir, nxtcost));
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int dir=0; dir<4; dir++) {
            ans = Math.min(ans, cost[n-1][n-1][dir]);
        }
        return ans;
    }
}