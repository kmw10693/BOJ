import java.util.*;
import java.io.*;

class Solution {
    int[][] board = new int[102][102];
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for(int i=x1; i<=x2; i++) {
                for(int j=y1; j<=y2; j++) {
                    board[i][j] = 1;
                }
            }   
        }
        
        for(int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            for(int i=x1+1; i<x2; i++) {
                for(int j=y1+1; j<y2; j++) {
                    board[i][j] = 0;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        int cx = characterX * 2;
        int cy = characterY * 2;
        
        int ix = itemX * 2;
        int iy = itemY * 2;
        
        visited[cx][cy] = true;
        q.add(new int[]{cx, cy, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            cx = cur[0];
            cy = cur[1];
            int cnt = cur[2];
            
            if(cx == ix && cy == iy) return cnt/2;
            
            for(int dir=0; dir<4; dir++) {
                int nxtx = cx + dx[dir];
                int nxty = cy + dy[dir];
                
                if(nxtx < 0 || nxtx >= 102 || nxty < 0 || nxty >= 102) continue;
                if(visited[nxtx][nxty]) continue;
                if(board[nxtx][nxty] == 0) continue;
                
                visited[nxtx][nxty] = true;
                q.add(new int[]{nxtx, nxty, cnt+1});
            }
        }
        return -1;
        
    }
}