class Solution {
    int n,m;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        
        Result result = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]);
        return result.count;
    }
    
    static class Result {
        boolean win;
        int count;
        
        Result(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }
    
    Result dfs(int[][] board, int cr, int cc, int or, int oc) {
        if(board[cr][cc] == 0) {
            return new Result(false, 0);
        }
        
        boolean canMove = false;
        int minWin = Integer.MAX_VALUE;
        
        int maxLose = 0;
        
        for(int d=0; d<4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            
            if(nr < 0 || nr >= n || nc <0 || nc >= m) continue;
            if(board[nr][nc] == 0) continue;
            
            canMove = true;
            board[cr][cc] = 0;
            Result next = dfs(board, or, oc, nr, nc);
            board[cr][cc] = 1;
            
            if(!next.win) {
                minWin = Math.min(minWin, next.count + 1);
            } else {
                maxLose = Math.max(maxLose, next.count + 1);
            }
        }
        
        if(!canMove) {
            return new Result(false, 0);
        } 
        
        if(minWin != Integer.MAX_VALUE) {
            return new Result(true, minWin);
        }
        
        return new Result(false, maxLose);
    }
}