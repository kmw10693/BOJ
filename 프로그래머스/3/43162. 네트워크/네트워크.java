import java.util.*;
import java.io.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(computers, i, n);
            }
        }
        return answer;
    }
    public void dfs(int[][] computers, int curidx, int n) {
        visited[curidx] = true;
        for(int i=0; i<n; i++) {
            if(computers[curidx][i] == 1 && !visited[i]) {
                dfs(computers, i, n);
            }
        }

    }
}