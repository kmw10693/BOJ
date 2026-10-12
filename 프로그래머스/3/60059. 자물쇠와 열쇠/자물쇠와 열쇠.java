import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        
        int size = n + 2*(m-1);
        int offset = m-1;
        
        int[][] board = new int[size][size];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[offset+i][offset+j] = lock[i][j];
            }
        }
        
        for(int r=0; r<4; r++) {
            for(int x=0; x<=size-m; x++) {
                for(int y=0; y<=size-m; y++) {
                    
                    for(int i=0; i<m; i++) {
                        for(int j=0; j<m; j++) {
                            board[x+i][y+j] += key[i][j];
                        }
                    }
                    
                    if(check(board, offset, n)) return true;
                    
                    for(int i=0; i<m; i++) {
                        for(int j=0; j<m; j++) {
                            board[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
            
            key = rotate(key);
        }
        return false;
    }
    
    boolean check(int[][] board, int offset, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[offset+i][offset+j] != 1) return false;
             }
        }
        return true;
    }
    
    int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] result = new int[m][m];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                result[j][m-1-i] = key[i][j];
            }
        }
        return result;
    }
}