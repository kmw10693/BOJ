import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        List<List<int[]>> arr = new ArrayList<>();
        int maxsize = -1;
        
        for(int[] route : routes) {
            int startidx = route[0] - 1;
            
            int startr = points[startidx][0];
            int startc = points[startidx][1];
            
            List<int[]> eachroute = new ArrayList<>();
            eachroute.add(new int[]{startr, startc});
            
            for(int i=1; i<route.length; i++) {
                int endidx = route[i] - 1;
                int endr = points[endidx][0];
                int endc = points[endidx][1];
                    
                while(startr != endr) {
                    startr += (startr < endr) ? 1 : -1;
                    eachroute.add(new int[]{startr, startc});
                }

                while(startc != endc) {
                    startc += (startc < endc) ? 1 : -1;
                    eachroute.add(new int[]{startr, startc});
                }
            }
            arr.add(eachroute);
            maxsize = Math.max(maxsize, eachroute.size());
        }
        
        int result = 0;
        
        for(int i=0; i<maxsize; i++) {
            int[][] present = new int[200][200];
           
            for(List<int[]> eacharr : arr) {
                if(eacharr.size() <= i) continue;

                int[] point = eacharr.get(i);
                int r = point[0];
                int c = point[1];
                    
                present[r][c]++;
            }
            
            
            for(int j=0; j<200; j++) {
                for(int k=0; k<200; k++) {
                    if(present[j][k] >= 2) result++;
                }
            }
        }
        return result;
        
        
    }
}