import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int[] solution(String[][] places) {
        // bfs
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<places.length; i++) {
            boolean check = true;
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(places[i][j].charAt(k) == 'P') {
                       if(bfs(i, j, k, places) == 0) check = false;        
                    }
                }
            }
            if(check) ans.add(1);
            else ans.add(0);
        }
        int[] result = new int[5];
        for(int i=0; i<5; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
    public int bfs(int index, int x, int y, String[][] places) {
        int[][] visited = new int[5][5];
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                visited[i][j] = -1;
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i=0; i<4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];
                
                if(nxtX < 0 || nxtX >= 5 || nxtY <0 || nxtY >= 5) continue;
                if(visited[nxtX][nxtY] != -1 || places[index][nxtX].charAt(nxtY) == 'X') continue;
                visited[nxtX][nxtY] = visited[curX][curY] + 1;
                if(places[index][nxtX].charAt(nxtY) == 'P') {
                    if(visited[nxtX][nxtY] <= 2) return 0;
                }
                q.add(new int[]{nxtX, nxtY});
            }
        }
      
        return 1;
    }
}