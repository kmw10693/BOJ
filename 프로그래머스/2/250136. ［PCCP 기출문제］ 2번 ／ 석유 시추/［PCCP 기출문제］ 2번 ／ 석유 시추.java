import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    int[][] tmp;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int col, row;
    int[] ans;
    int maxans = Integer.MIN_VALUE;

    public int solution(int[][] land) {
        col = land[0].length; // 열
        row = land.length; // 행
        ans = new int[col];

        tmp = new int[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                tmp[i][j] = land[i][j];
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(tmp[i][j] == 1) dfs(i, j);
            }
        }
        for(int i=0; i<col; i++) maxans = Math.max(maxans, ans[i]);
        return maxans;
    }

    public void dfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        Set<Integer> s = new HashSet<>();
        s.add(y);
        int tmpvalue = 1;
        tmp[x][y] = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];

                if (nxtX < 0 || nxtX >= row || nxtY < 0 || nxtY >= col) continue;
                if (tmp[nxtX][nxtY] != 1) continue;
                s.add(nxtY);
                tmpvalue++;
                tmp[nxtX][nxtY] = -1;
                q.add(new int[]{nxtX, nxtY});
            }
        }
        // Set 갱신
        for(Integer i : s) ans[i] += tmpvalue;
    }
}