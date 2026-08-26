import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        maps[0][0] = -1;
            
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];
            
            if(x == maps.length-1 && y == maps[0].length-1) {
                return dis;
            }
            
            for(int i=0; i<4; i++) {
                int nxtX = x + dx[i];
                int nxtY = y + dy[i];
                
                if(nxtX < 0 || nxtX >= maps.length || nxtY < 0 || nxtY >= maps[0].length) continue;
                if(maps[nxtX][nxtY] != 1) continue;
                
                maps[nxtX][nxtY] = dis+1;
                q.offer(new int[]{nxtX, nxtY, dis+1});
            }
        }
        return -1;
    }
}