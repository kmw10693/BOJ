import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] ordermap = new int[m][n];
        
        int MAX_VALUE = drops.length + 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ordermap[i][j] = MAX_VALUE;
            }
        }
        
        for(int i=0; i<drops.length; i++) {
            int x = drops[i][0];
            int y = drops[i][1];
            
            ordermap[x][y] = i+1;
        }
        
        int[][] rowmin = new int[m][n];
        
        for(int i=0; i<m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for(int j=0; j<n; j++) {
                while(!dq.isEmpty() && ordermap[i][dq.peekLast()] >= ordermap[i][j]) {
                    dq.pollLast();
                }
                dq.addLast(j);
                
                while(!dq.isEmpty() && dq.peekFirst() <= j-w) dq.pollFirst();
                
                if(j-w+1 >= 0) rowmin[i][j-w+1] = ordermap[i][dq.peekFirst()];
            }
        }
        
        int ansX = 0, ansY = 0;
        int maxValue = -1;
        
        for(int i=0; i<n; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for(int j=0; j<m; j++) {
                while(!dq.isEmpty() && rowmin[dq.peekLast()][i] >= rowmin[j][i]) {
                    dq.pollLast();
                }
                dq.addLast(j);
                
                while(!dq.isEmpty() && dq.peekFirst() <= j-h) dq.pollFirst();
                
                if(j-h+1 >= 0) {
                    rowmin[j-h+1][i] = rowmin[dq.peekFirst()][i];
                    
                    if(rowmin[j-h+1][i] > maxValue) {
                        maxValue = rowmin[j-h+1][i];
                        ansX = j-h+1;
                        ansY = i;
                    } else if (rowmin[j-h+1][i] == maxValue) {
                        if(j-h+1 < ansX || (j-h+1 == ansX && i < ansY)) {
                            ansX = j-h+1;
                            ansY = i;
                        }
                    }
                }
            }
        }
        return new int[]{ansX, ansY};
    }
}