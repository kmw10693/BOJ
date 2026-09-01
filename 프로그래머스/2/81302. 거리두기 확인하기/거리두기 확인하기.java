import java.util.*;
import java.io.*;

class Solution {
    boolean arrange = true;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    int n, m;
    
    public int[] solution(String[][] places) {
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<places.length; i++) {
            for(int j=0; j<places[i].length; j++) {
                
                for(int k=0; k<places[i][j].length(); k++) {
                    if(places[i][j].charAt(k) == 'P' && arrange) {
                        n = places[i].length;
                        m = places[i][j].length();
                        
                        boolean[][] visited = new boolean[n][m];
                        visited[j][k] = true;
                        
                        dfs(0, places[i], j, k, visited);
                    }
                }
                
            }
            if(arrange) ans.add(1);
            else ans.add(0);
            
            arrange = true;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void dfs(int cnt, String[] places, int curx, int cury, boolean[][] visited) {
        if(cnt > 0 && cnt <= 2) {
            if(places[curx].charAt(cury) == 'P') {
                arrange = false;
                return;
            }
        }
        
        if(cnt == 2) {
            return;
        }
        
        for(int dir=0; dir<4; dir++) {
            int nxtx = curx + dx[dir];
            int nxty = cury + dy[dir];
            
            if(nxtx < 0 || nxtx >= n || nxty < 0 || nxty >= m) continue;
            if(visited[nxtx][nxty] || places[nxtx].charAt(nxty) == 'X') continue;
            
            visited[nxtx][nxty] = true;
            dfs(cnt+1, places, nxtx, nxty, visited);
            visited[nxtx][nxty] = false;
        }
    }
}