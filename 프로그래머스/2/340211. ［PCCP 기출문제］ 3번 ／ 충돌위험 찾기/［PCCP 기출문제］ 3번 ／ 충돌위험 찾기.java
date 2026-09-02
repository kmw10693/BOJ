import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        List<List<int[]>> arr = new ArrayList<>();
        int maxsize = 0;
        
        for(int[] route : routes) {
            int startidx = route[0] - 1;
            List<int[]> eachlist = new ArrayList<>();
            
            eachlist.add(new int[]{points[startidx][0], points[startidx][1]});
            
            int r = points[startidx][0];
            int c = points[startidx][1];
            
            for(int i=1; i<route.length; i++) {
                int dstr = points[route[i]-1][0];
                int dstc = points[route[i]-1][1];
                
                while(r != dstr) {
                    r += (r < dstr) ? 1 : -1;
                    eachlist.add(new int[]{r, c});
                }
                
                while(c != dstc) {
                    c += (c < dstc) ? 1 : -1;
                    eachlist.add(new int[]{r, c});
                }
            }
            maxsize = Math.max(maxsize, eachlist.size());
            arr.add(eachlist);
        }
        
        int ans = 0;
                
        for(int i=0; i<maxsize; i++) {
            int[][] count = new int[500][500];
            
            for(int j=0; j<arr.size(); j++) {
                List<int[]> eachlist = arr.get(j);
                if(i >= eachlist.size()) continue;
                
                int[] curpos = eachlist.get(i);
                count[curpos[0]][curpos[1]]++;
                
            }
            
            for(int j=0; j<500; j++) {
                for(int k=0; k<500; k++) {
                    if(count[j][k] >= 2) ans++;
                }
            }
        }
        
        return ans;
        
    }
}