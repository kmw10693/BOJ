import java.util.*;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int r = beginning.length;
        int c = beginning[0].length;
        
        int answer = Integer.MAX_VALUE;
        
        for(int mask = 0; mask < (1 << r); mask++) {
            int[][] board = new int[r][c];
            
            for(int i=0; i<r; i++) {
                board[i] = beginning[i].clone();
            }
            
            int count = 0;
            
            for(int i=0; i<r; i++) {
                if((mask & (1 << i)) != 0) {
                    count++;
                    
                    for(int j=0; j<c; j++) {
                       board[i][j] ^= 1;  
                    }
                }
            }
            
            for(int j=0; j<c; j++) {
                if(board[0][j] != target[0][j]) {
                    count++;
                    
                    for(int i=0; i<r; i++) {
                        board[i][j] ^= 1;
                    }
                }
            }
            
            boolean possible = true;
            
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    if(board[i][j] != target[i][j]) {
                        possible = false;
                        break;
                    }
                }
                if(!possible) break;
            }
            
            if(possible) {
                answer = Math.min(answer, count);
            }   
        }
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
}