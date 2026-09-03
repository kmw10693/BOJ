import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int pickcount = picks[0] + picks[1] + picks[2];
        
        int maxcount = Math.min(pickcount * 5, minerals.length);
        List<int[]> arr = new ArrayList<>();
        
        for(int i=0; i<maxcount; i+=5) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j=i; j<Math.min(maxcount, i+5); j++) {
                if(minerals[j].equals("diamond")) {
                    diamond++;
                } else if(minerals[j].equals("iron")) {
                    iron++;
                } else {
                    stone++;
                }
            }
            
            arr.add(new int[]{diamond, iron, stone});
        }
        
        arr.sort((a,b) -> {
            if(a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        
        int answer = 0;
        
        for(int[] a : arr) {
            if(picks[0] > 0) {
                answer += (a[0] + a[1] + a[2]); 
                picks[0]--;
            } else if(picks[1] > 0) {
                answer += (a[0] *5 + a[1] + a[2]);
                picks[1]--;
            } else {
                answer += (a[0]*25 + a[1]*5 + a[2]);
                picks[2]--;
            }
        }
        return answer;
    }
}