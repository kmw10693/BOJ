import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        
        for(int i=1; i<arrayA.length; i++) {
            gcdA = getgcd(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        
        for(int i=1; i<arrayB.length; i++) {
            gcdB = getgcd(gcdB, arrayB[i]);
        }
        
        boolean isbdivided = false;
        for(int ab : arrayB) {
            if(ab % gcdA == 0) isbdivided = true;
        }
        
        boolean isadivided = false;
        for(int aa : arrayA) {
            if(aa % gcdB == 0) isadivided = true;
        }
        
        if(isbdivided && isadivided) return 0;
        else if(isbdivided && !isadivided) return gcdB;
        else if(!isbdivided && isadivided) return gcdA;
        return Math.max(gcdA, gcdB);
    }
    
    public int getgcd(int a, int b) {
        if(b == 0) return a;
        return getgcd(b, a%b);
    }
    
}