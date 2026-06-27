import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int[] expire = new int[24+k+1];
        int answer = 0;
        int curserver = 0;
        
        for(int i=0; i<24; i++) {
            curserver -= expire[i];
            
            int require = players[i] / m;
            if(curserver < require) {
                int sub = require - curserver;
                
                curserver += sub;
                answer += sub;
                expire[i+k] += sub;
            }
        }
        return answer;
    }
}