import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    
    List<int[]>[] cards = new ArrayList[7];
    
    public int solution(int[][] board, int r, int c) {
        for(int i=0; i<=6; i++) {
            cards[i] = new ArrayList<>();
        }
        
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(board[i][j] != 0) {
                    cards[board[i][j]].add(new int[]{i,j});
                }
            }
        }
        
        dfs(board, r, c, 0);
        
        return answer;
    }
    
    void dfs(int[][] board, int r, int c, int count) {
        boolean finished = true;
        
        for(int card=1; card<=6; card++) {
            if(cards[card].isEmpty()) continue;
            
            int[] p1 = cards[card].get(0);
            int[] p2 = cards[card].get(1);
            
            if(board[p1[0]][p1[1]] == 0) continue;
            
            finished = false;
            int r1 = p1[0];
            int c1 = p1[1];
            
            int r2 = p2[0];
            int c2 = p2[1];
            
            int move1 = bfs(board, r, c, r1, c1) + bfs(board, r1, c1, r2, c2) + 2;
            board[r1][c1] = 0;
            board[r2][c2] = 0;
            
            dfs(board, r2, c2, count + move1);
            
            board[r1][c1] = card;
            board[r2][c2] = card;
            
            int move2 = bfs(board, r,c,r2,c2) + bfs(board, r2, c2, r1, c1) + 2;
            
            board[r1][c1] = 0;
            board[r2][c2] = 0;
            
            dfs(board, r1, c1, count + move2);
            
            board[r1][c1] = card;
            board[r2][c2] = card;
        }
        
        if(finished) {
            answer = Math.min(answer, count);
        }
    }
    
    int bfs(int[][] board, int sr, int sc, int er, int ec) {
        boolean[][] visited = new boolean[4][4];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            
            if(r == er && c == ec) return dist;
            
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr >=0 && nr<4 && nc >=0 && nc <4 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist+1});
                }

            
                int[] next = ctrlMove(board, r, c, d);
                nr = next[0];
                nc = next[1];

                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist+1});
                }
            }
        }
        return -1;    
    }
    int[] ctrlMove(int[][] board, int r, int c, int dir) {
        while(true) {
            int nr = r +dr[dir];
            int nc = c + dc[dir];
            
            if(nr < 0 || nr >= 4 || nc < 0 || nc >=4) return new int[]{r,c};
            r = nr;
            c = nc;
            if(board[r][c] != 0) return new int[]{r,c};
        }
        
    }
}