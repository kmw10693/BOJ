import java.util.*;

class Solution {
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][][] visited;
    int[][] board;
    
    class Board {
        int r, c, dir, time;
        
        Board(int r, int c, int dir, int time) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.time = time;
        }
    }
    
    // 단순 이동
    boolean canMove(int r, int c, int dir, int n, int[][] board) {
        // 가로
        if(dir == 0) {
            if(c+1 < 0 || c+1 >= n) return false;
            if(board[r][c] == 0 && board[r][c+1] == 0 && !visited[r][c][dir]) return true;
            return false;
        }
        // 세로
        else {
            if(r+1 < 0 || r+1 >= n) return false;
            if(board[r][c] == 0 && board[r+1][c] == 0 && !visited[r][c][dir]) return true;
            return false;
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        visited = new boolean[n][n][2];
        
        // 0은 가로, 1은 세로
        Queue<Board> q = new LinkedList<>();
        q.add(new Board(0,0,0,0));
        visited[0][0][0] = true;
        
        while(!q.isEmpty()) {
            Board cur = q.poll();
            if(cur.dir == 0 && cur.r == n-1 && cur.c == n-2) {
                return cur.time;
            } else if(cur.dir == 1 && cur.r == n-2 && cur.c == n-1) {
                return cur.time;
            }
            
            // 4방향 이동, 회전 x
            for(int dir=0; dir<4; dir++) {
                int nx = cur.r + dx[dir];
                int ny = cur.c + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(cur.dir == 0 && canMove(nx, ny, cur.dir, n, board)) {
                    visited[nx][ny][0] = true;
                    q.add(new Board(nx, ny, 0, cur.time+1));
                } 
                else if(cur.dir == 1 && canMove(nx, ny, cur.dir, n, board)) {
                    visited[nx][ny][1] = true;
                    q.add(new Board(nx, ny, 1, cur.time+1));
                }   
            }
            
            // 가로 인경우
            if(cur.dir == 0) {
                 // 위로 회전
                 
                 // 왼쪽 축
                 int leftupr = cur.r - 1;
                 if(leftupr >= 0 && leftupr < n && board[leftupr][cur.c] == 0 && board[leftupr][cur.c+1] == 0 && !visited[leftupr][cur.c][1]) {
                     visited[leftupr][cur.c][1] = true;
                     q.add(new Board(leftupr, cur.c, 1, cur.time+1));
                 }
                
                 // 오른쪽 축
                 if(leftupr >= 0 && leftupr < n && board[leftupr][cur.c] == 0 && board[leftupr][cur.c+1] == 0 && !visited[leftupr][cur.c+1][1]) {
                     visited[leftupr][cur.c+1][1] = true;
                     q.add(new Board(leftupr, cur.c+1, 1, cur.time+1));
                 }
                
                 // 아래로 회전 
                int leftdownr = cur.r + 1;
                
                 // 왼쪽 축
                if(leftdownr >= 0 && leftdownr < n && board[leftdownr][cur.c] == 0 && board[leftdownr][cur.c+1] == 0 && !visited[cur.r][cur.c][1]) {
                     visited[cur.r][cur.c][1] = true;
                     q.add(new Board(cur.r, cur.c, 1, cur.time+1));
                 }
                
                 // 오른쪽 축
                 if(leftdownr >= 0 && leftdownr < n && board[leftdownr][cur.c] == 0 && board[leftdownr][cur.c+1] == 0 && !visited[cur.r][cur.c+1][1]) {
                     visited[cur.r][cur.c+1][1] = true;
                     q.add(new Board(cur.r, cur.c+1, 1, cur.time+1));
                 }
            } else if(cur.dir == 1) {
                // 세로 인 경우
                
                // 위로 왼쪽 회전
                int leftupc = cur.c - 1;
                 if(leftupc >= 0 && leftupc < n && board[cur.r][leftupc] == 0 && board[cur.r+1][leftupc] == 0 && !visited[cur.r][leftupc][0]) {
                     visited[cur.r][leftupc][0] = true;
                     q.add(new Board(cur.r, leftupc, 0, cur.time+1));
                 }
                
                // 위로 오른쪽 회전 
                int rightupc = cur.c + 1;
                 if(rightupc >= 0 && rightupc < n && board[cur.r][rightupc] == 0 && board[cur.r+1][rightupc] == 0 && !visited[cur.r][cur.c][0]) {
                     visited[cur.r][cur.c][0] = true;
                     q.add(new Board(cur.r, cur.c, 0, cur.time+1));
                 }
                
                // 아래로 왼쪽 회전
                int leftdownc = cur.c - 1;
                 if(leftdownc >= 0 && leftdownc < n && board[cur.r][leftdownc] == 0 && board[cur.r+1][leftdownc] == 0 && !visited[cur.r+1][leftdownc][0]) {
                     visited[cur.r+1][leftdownc][0] = true;
                     q.add(new Board(cur.r+1, leftdownc, 0, cur.time+1));
                 }
                
                // 아래로 오른쪽 회전
                int rightdownc = cur.c + 1;
                 if(rightdownc >= 0 && rightdownc < n && board[cur.r][rightdownc] == 0 && board[cur.r+1][rightdownc] == 0 && !visited[cur.r+1][cur.c][0]) {
                     visited[cur.r+1][cur.c][0] = true;
                     q.add(new Board(cur.r+1, cur.c, 0, cur.time+1));
                 }
                
            }
        }
        return -1;
    }    
}