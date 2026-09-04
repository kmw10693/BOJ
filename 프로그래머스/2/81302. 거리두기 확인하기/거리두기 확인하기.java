import java.util.*;
import java.io.*;

class Solution {
    boolean result = true;
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public void dfs(String[] place, int cnt, int curx, int cury, boolean[][] isvisited) {
        if(result == false) return; 
        
        if(cnt <= 2 && cnt > 0) {
            if(place[curx].charAt(cury) == 'P') {
                result = false;
            }
        }
        
        if(cnt == 2) return;
        
        for(int dir=0; dir<4; dir++) {
            int nxtx = curx + dx[dir];
            int nxty = cury + dy[dir];
            
            if(nxtx < 0 || nxtx >= place.length || nxty < 0 || nxty >= place[0].length()) continue;
            if(place[nxtx].charAt(nxty) == 'X') continue;
            if(isvisited[nxtx][nxty]) continue;
            
            isvisited[nxtx][nxty] = true;
            dfs(place, cnt+1, nxtx, nxty, isvisited);
            isvisited[nxtx][nxty] = false;
        }
    }
    
    public int[] solution(String[][] places) {
        
        List<Integer> ans = new ArrayList<>();
        
        for(String[] place : places) {
            int n = place.length;
            int m = place[0].length();
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(place[i].charAt(j) == 'P') {
                        boolean[][] isvisited = new boolean[n][m];
                        isvisited[i][j] = true;
                        dfs(place, 0, i, j, isvisited);
                    } 
                }
            }
            
            if(result) ans.add(1);
            else ans.add(0);
            result = true;
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}