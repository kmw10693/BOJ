import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        List<Character>[] arr = new ArrayList[signals.length];
        for(int i=0; i<signals.length; i++) {
            arr[i] = new ArrayList<>();
        }
        
        int idx = 0;
        for(int[] signal : signals) {
            
            int Gcnt = signal[0];
            int Ycnt = signal[1];
            int Rcnt = signal[2];
            
            for(int i=0; i<Gcnt; i++) arr[idx].add('G');
            for(int i=0; i<Ycnt; i++) arr[idx].add('Y');
            for(int i=0; i<Rcnt; i++) arr[idx].add('R');
            
            idx++;
       } 
        
       for(int i=0; i<10000000; i++) {
           boolean check = true;
           for(int j=0; j<signals.length; j++) {
               int eachidxsize = arr[j].size();
               int eachidx = i % eachidxsize;
               if(arr[j].get(eachidx) != 'Y') {
                   check = false;
                   break;
               }
           }
           if(check) return i+1;
       }
        return -1;
    }
}