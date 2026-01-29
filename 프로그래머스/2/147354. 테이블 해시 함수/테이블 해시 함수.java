import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            int first = o1[col-1];
            int second = o2[col-1];
            if(first == second) {
                return o2[0] - o1[0];
            }
            return first - second;
        });
        
        
        int[] si = new int[data.length];
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++) {
                si[i] += (data[i][j] % (i+1));
            }
        }
        int start = si[row_begin-1];
        for(int i=row_begin; i<=row_end-1; i++) {
            start ^= si[i];
        }
        return start;
    }
}