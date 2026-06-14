import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        
        List<Character>[] signalList = new ArrayList[signals.length];
        for(int i=0; i<signals.length; i++) {
            List<Character> eachsignal = new ArrayList<>();
            
            while(signals[i][0]-- > 0) eachsignal.add('G');
            while(signals[i][1]-- > 0) eachsignal.add('Y');
            while(signals[i][2]-- > 0) eachsignal.add('R');
            
            signalList[i] = eachsignal;
        }
        
        int st = 0, end = 2000000;
        for(int i=st; i<=end; i++) {  
            boolean canYellow = true;
            for(int j=0; j<signalList.length; j++) {
                int eachsize = signalList[j].size();
                if(signalList[j].get(i%eachsize) != 'Y') {
                    canYellow = false;
                    break;
                }
            }
            if(canYellow) return i+1;
        }
        return -1;
        
    }
}