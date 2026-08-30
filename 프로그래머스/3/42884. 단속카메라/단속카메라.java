import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> a[1]-b[1]);
        
        int ans = 0;
        int camera = Integer.MIN_VALUE;
        
        for(int[] route : routes) {
            if(camera < route[0]) {
                ans++;
                camera = route[1];
            }
        }
        return ans;
    }
}