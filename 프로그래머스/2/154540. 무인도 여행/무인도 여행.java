import java.util.*;
import java.io.*;

class Solution {
    boolean[][] visited;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    int n,m;
    
    public int[] solution(String[] maps) {
        // 한번 방문 해야 하니 bfs
        visited = new boolean[maps.length][maps[0].length()];
        n = maps.length;
        m = maps[0].length();
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(!visited[i][j] && maps[i].charAt(j) != 'X') {
                    ans.add(bfs(i, j, maps));
                }
            }
        }
        int[] tmp = new int[ans.size()];
        for(int i=0; i<tmp.length; i++) {
            tmp[i] = ans.get(i);
        }
        Arrays.sort(tmp);
        if(tmp.length == 0) return new int[]{-1};
        return tmp;
    }
    
    public int bfs(int x, int y, String[] maps) {
        Queue<int[]> q = new LinkedList<>();
        int sum = 0;
        q.add(new int[]{x,y});
        sum += maps[x].charAt(y) - '0';
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i=0; i<4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];
                
                if(nxtX < 0 || nxtX >= n || nxtY < 0 || nxtY >= m) continue;
                if(visited[nxtX][nxtY] || maps[nxtX].charAt(nxtY) == 'X') continue;
                
                sum += maps[nxtX].charAt(nxtY) - '0';
                visited[nxtX][nxtY] = true;
                q.add(new int[]{nxtX, nxtY});
            }
        }
        return sum;
    }
}