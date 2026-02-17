import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] tired = {{1,1,1}, {5,1,1}, {25, 5, 1}};
        
        int totalpick = picks[0] + picks[1] + picks[2];
        int maxlength = Math.min(minerals.length, totalpick * 5);
        
        List<int[]> groups = new ArrayList<>();
        
        for(int i=0; i<minerals.length; i+=5) {
            
            int groupdia = 0;
            int groupiron = 0;
            int groupstone = 0;
            for(int j=i; j<i+5 && j<maxlength; j++) {
                if(minerals[j].equals("diamond")) groupdia++;
                else if(minerals[j].equals("iron")) groupiron++;
                else groupstone++;
            }
            groups.add(new int[]{groupdia, groupiron, groupstone});
        }
        
        groups.sort((a,b) -> {
            int psum1 = a[0]*25 + a[1]*5 + a[2];
            int psum2 = b[0]*25 + b[1]*5 + b[2];
            return psum2 - psum1;
        });
        
        for(int[] g : groups) {
            for(int i=0; i<picks.length; i++) {
                if(picks[i] > 0) {
                    answer += g[0] * tired[i][0] + g[1] * tired[i][1] + g[2] * tired[i][2];
                    picks[i]--;
                    break;
                }
            }
        }
        return answer;
    }
}