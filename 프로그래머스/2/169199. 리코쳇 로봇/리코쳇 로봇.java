import java.util.*;
import java.io.*;

class Solution {
    class Node {
        int x, y, dir, cnt;
        Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(String[] board) {
        Queue<Node> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length();
        
        boolean[][][] isvisited = new boolean[n][m][4];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i].charAt(j) == 'R') {
                    for(int dir=0; dir<4; dir++) {
                        q.add(new Node(i,j,dir,1));
                    }
                }
            }
        }
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            int curx = cur.x;
            int cury = cur.y;
            int dir = cur.dir;
            isvisited[curx][cury][dir] = true;
            
            int cnt = cur.cnt;
            
            int nxtx = curx + dx[dir];
            int nxty = cury + dy[dir];
            
            while(nxtx >= 0 && nxtx < n && nxty >= 0 && nxty < m && board[nxtx].charAt(nxty) != 'D') {
                nxtx += dx[dir];
                nxty += dy[dir];
            }
            
            nxtx -= dx[dir];
            nxty -= dy[dir];
            
            if(board[nxtx].charAt(nxty) == 'G') {
                return cnt;
            }
            
            for(int d=0; d<4; d++) {
                if(isvisited[nxtx][nxty][d]) continue;
                q.add(new Node(nxtx,nxty,d,cnt+1));
            }
        }
        return -1;
    }
}