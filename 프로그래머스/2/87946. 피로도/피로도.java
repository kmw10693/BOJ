import java.util.*;
import java.io.*;

class Solution {
    int ans = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return ans;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
        ans = Math.max(ans, cnt);
        
        for(int i=0; i<dungeons.length; i++) {
            if(visited[i]) continue;
            if(k < dungeons[i][0]) continue;
            
            visited[i] = true;
            dfs(k-dungeons[i][1], dungeons, visited, cnt+1);
            visited[i] = false;
        }
    }
}