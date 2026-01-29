import java.util.*;
import java.io.*;

class Solution {
    int result = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        for(int i=0; i<dungeons.length; i++) {
            if(k >= dungeons[i][0] && visited[i] == false) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, 1, visited);
                visited[i] = false;
            }
        }
        return result;
    }
    
    public void dfs(int k, int[][] dungeons, int cnt, boolean[] visited) {
        for(int i=0; i<dungeons.length; i++) {
            if(visited[i]) continue;
            if(k >= dungeons[i][0] && visited[i] == false) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, cnt+1, visited);
                visited[i] = false;
            }
        }
        result = Math.max(result, cnt);
    }
}