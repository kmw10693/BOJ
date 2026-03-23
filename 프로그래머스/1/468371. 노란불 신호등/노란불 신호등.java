import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] signals) {
        
        List<Character>[] charsignals = new ArrayList[signals.length];
            
        for(int i=0; i<signals.length; i++) {
            charsignals[i] = new ArrayList<>();
                
            int[] eachsignal = signals[i];
                
            for(int j=0; j<eachsignal.length; j++) {
                if(j == 0) {
                    while(eachsignal[j]-- > 0) {
                        charsignals[i].add('G');
                    }
                } else if(j == 1) {
                    while(eachsignal[j]-- > 0) {
                        charsignals[i].add('Y');
                    }
                } else if(j == 2) {
                    while(eachsignal[j]-- > 0) {
                        charsignals[i].add('R');
                    }
                }
            }
        }
        
        int curtime = 0;
        int maxtime = 2000000;
        
        while(curtime <= maxtime) {
            
            boolean isallyellow = true;
            for(List<Character> charsignal : charsignals) {
                if(charsignal.get(curtime % (charsignal.size())) != 'Y') isallyellow = false;
            }
            
            if(isallyellow == true) {
                return curtime + 1;
            }
            
            curtime++;
        }
        
        return -1;
    }
}