import java.util.*;
import java.io.*;

class Solution {
    // d l r u
    char[] dirx = {'d', 'l', 'r', 'u'};
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
       int minDist = Math.abs(r-x) + Math.abs(c-y);
       if(minDist > k || (k - minDist) % 2 != 0) return "impossible";
       
       StringBuilder sb = new StringBuilder();
       int cx = x;
       int cy = y;
        
       for(int cnt=0; cnt<k; cnt++) {
           for(int dir=0; dir<4; dir++) {
               int nx = cx + dx[dir];
               int ny = cy + dy[dir];
               
               if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
               int remain = k - cnt - 1;
               int dist = Math.abs(nx-r) + Math.abs(ny-c);
               
               if(dist <= remain && (remain - dist) % 2 == 0 ) {
                   sb.append(dirx[dir]);
                   cx = nx;
                   cy = ny;
                   break;
               }
               
           }
       }
       return sb.toString();
    }
}