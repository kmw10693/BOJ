import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int result = 0;
        int startIndex= section[0];
        while(true) {
            
             startIndex = -1;
            for(int i=0; i<section.length; i++) {
                if(section[i] != -1) {
                    startIndex = section[i];
                    break;
                }
            }
            
            if(startIndex == -1) break;
            
            for(int k=0; k<section.length; k++) {
                if(section[k] >= startIndex && section[k] < startIndex + m) {
                    section[k] = -1;
                }
            }
            result++;
        }
        return result;
    }
}