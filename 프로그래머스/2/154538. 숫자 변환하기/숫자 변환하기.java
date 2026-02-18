import java.util.*;
import java.io.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        
        Queue<int[]> q = new ArrayDeque<>();
        
        boolean[] visited = new boolean[y+1];
        
        q.add(new int[]{x, 0});
        visited[x] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int count = cur[1];
            
            int[] nxtPoslist = {pos+n, pos*2, pos*3}; 
            
            for(int npl : nxtPoslist) {
                
                if(npl > y || visited[npl]) continue;
                if(npl == y) return count+1;
                visited[npl] = true;
                q.add(new int[]{npl, count+1});
            }
        }
        return -1;
    }
}