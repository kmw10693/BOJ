import java.util.*;
import java.io.*;

class Solution {
    int n, m;
    int Ex, Ey;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(String[] maps) {
        // bfs
        n = maps.length;
        m = maps[0].length();
        int k = -1;
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'E') {
                    Ex = i;
                    Ey = j;
                }
            }
        }
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    k = bfs(i,j,maps);
                }
            }
        }
        return k;
    }
    public int bfs(int x, int y, String[] maps) {
        int[][] visited = new int[n][m];
        int[][] visited2 = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = -1;
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited2[i][j] = -1;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1]; 
            // 레버까지 이동해야 함.
            
            for(int i=0; i<4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];
                
                if(nxtX < 0 || nxtX >=n || nxtY < 0 || nxtY >=m) continue;
                if(visited[nxtX][nxtY] != -1 || maps[nxtX].charAt(nxtY) == 'X') continue;
                
                visited[nxtX][nxtY] = visited[curX][curY] + 1;
                if(maps[nxtX].charAt(nxtY) == 'L') {
                    q2.add(new int[]{nxtX, nxtY});
                    visited2[nxtX][nxtY] = visited[curX][curY] + 1;
                    break;
                }
                q.add(new int[]{nxtX, nxtY});
            }
        }
        
        while(!q2.isEmpty()) {
            int[] cur = q2.poll();
            int curX = cur[0];
            int curY = cur[1]; 
            // 레버까지 이동해야 함.
            
            for(int i=0; i<4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];
                
                if(nxtX < 0 || nxtX >=n || nxtY < 0 || nxtY >=m) continue;
                if(visited2[nxtX][nxtY] != -1 || maps[nxtX].charAt(nxtY) == 'X') continue;
                
                visited2[nxtX][nxtY] = visited2[curX][curY] + 1;
                q2.add(new int[]{nxtX, nxtY});
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(visited2[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.print(visited2[Ex][Ey]);
        return visited2[Ex][Ey];
    }
}