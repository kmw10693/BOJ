import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int)(right+1-left)];
        for(int i=0; i<(int)(right+1-left); i++) {
            int row = (int)((left+i)/n);
            int col = (int)((left+i)%n);
            
            arr[i] = Math.max(row, col) + 1;
        }
        return arr;
    }
}