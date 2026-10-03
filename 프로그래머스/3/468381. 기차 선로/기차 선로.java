import java.util.*;

class Solution {
    int n, m;
    int[][] grid;
    int[][] board;
    
    final int U = 1;
    final int D = 2;
    final int L = 4; 
    final int R = 8; 
    int[] piece = {
        0,
        L|R,
        U|D,
        U|D|L|R,
        U|L,
        U|R,
        D|R,
        D|L
    };
    
    public int solution(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        
        board = new int[n][m];
        board[0][0] = piece[1];
        
        return dfs(1);
    }
    
    int dfs(int pos) {
        if(pos == n*m) {
            return connected() ? 1 : 0;
        }
        
        int r = pos/m;
        int c = pos%m;
        
        boolean needUp = r>0 && (board[r-1][c] & D) != 0;
        boolean needLeft = c >0 && (board[r][c-1] & R) != 0;
        
        int total = 0;
        
        if(grid[r][c] == -1) {
            if(needUp || needLeft) return 0;
            board[r][c] = 0;
            return dfs(pos+1);
        }
        
        if(grid[r][c] > 0) {
            int mask = piece[grid[r][c]];
            
            if(!match(mask, needUp, needLeft)) return 0;
            if(!boundaryCheck(r,c,mask)) return 0;
            
            board[r][c] = mask;
            total = dfs(pos+1);
            board[r][c] = 0;
            
            return total;
        }
        
        int[] candidates = getCandidates(needUp, needLeft);
        
        for(int mask: candidates) {
            if(!boundaryCheck(r,c,mask)) continue;
            board[r][c] = mask;
            total += dfs(pos+1);
            board[r][c] = 0;
        }
        return total;
    }
    
    boolean match(int mask, boolean needUp, boolean needLeft) {
        boolean hasUp = (mask & U) != 0;
        boolean hasLeft = (mask & L) != 0;
        
        return hasUp == needUp && hasLeft == needLeft;
    }
    int[] getCandidates(boolean up, boolean left) {
        if(!up && !left) return new int[]{0, D|R};
        
        if(up && !left) return new int[]{U|D, U|R};
        
        if(!up && left) return new int[]{L|R, D|L};
        
        return new int[]{
            U|L, U|D|L|R
        };
    }
    boolean boundaryCheck(int r, int c, int mask){
        boolean end = r == n-1 && c == m-1;
        
        if(c == m-1 && (mask&R) != 0 && !end) return false;
        
        if(r == n-1 && (mask&D)!=0 && !end) return false;
        return true;
    }
    
    boolean connected() {
        int[][] used = new int[n][m];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        int[] bits = {U,D,L,R};
        int[] opp = {1, 0, 3, 2};  
        
        boolean[][][] seen = new boolean[n][m][4];
        
        int r= 0;
        int c = 0;
        int move = 3;
        
        used[0][0] = piece[1];
        
        while(true) {
            int nr = r + dr[move];
            int nc = c + dc[move];
            
            if(nr < 0 || nr >=n || nc <0 || nc>=m)  {
                if(r!=n-1 || c!= m-1) return false;
                
                break;
             }
            
            if(board[nr][nc] == 0) return false;
            
            int entry =opp[move];
            if((board[nr][nc] & bits[entry]) == 0) return false;
            
            if(seen[nr][nc][entry]) return false;
            
            int exit = -1;
            
            if(board[nr][nc] == 15) {
                exit= opp[entry];
            } else {
                for(int d=0; d<4; d++) {
                    if(d == entry) continue;
                    if((board[nr][nc] & bits[d]) !=0) {
                        exit = d;
                        break;
                    }
                }
            }
            
            if(exit == -1) return false;
            used[nr][nc] |= bits[entry];
            used[nr][nc] |= bits[exit];
            
            r = nr;
            c = nc;
            move = exit;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0) continue;
                
                if(used[i][j] != board[i][j]) return false;
            }
        }
        return true;
    }
}