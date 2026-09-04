import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(String[] board) {
        int n, m;
        
        n = board.length;
        m = board[0].length();
        
        boolean[][][] visited = new boolean[n][m][4];
        Queue<int[]> s = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i].charAt(j) == 'R') {
                    
                    for(int dir=0; dir<4; dir++) {
                        s.add(new int[]{i,j,dir,1});
                    }
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        while(!s.isEmpty()) {
            int[] cur = s.poll();
            
            int curx = cur[0];
            int cury = cur[1];
            int dir = cur[2];
            
            visited[curx][cury][dir] = true;
            
            int cnt = cur[3];
            
            int nxtx = curx + dx[dir];
            int nxty = cury + dy[dir];
            
            while(true) {
                if(nxtx < 0 || nxtx >= n || nxty < 0 || nxty >= m) break;
                if(board[nxtx].charAt(nxty) == 'D') break;
                
                nxtx += dx[dir];
                nxty += dy[dir];
            }
            
            nxtx -= dx[dir];
            nxty -= dy[dir];
            
            if(board[nxtx].charAt(nxty) == 'G') return cnt;
            
            for(int d=0; d<4; d++) {
                if(visited[nxtx][nxty][d]) continue;
                s.add(new int[]{nxtx, nxty, d, cnt+1});
            }
            
        }
        return -1;
    }
}