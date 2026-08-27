import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcda = arrayA[0];
        int gcdb = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++) {
            gcda = gcd(gcda, arrayA[i]);
        }
        for(int i=1; i<arrayB.length; i++) {
            gcdb = gcd(gcdb, arrayB[i]);
        }
        
        int ans = 0;
        if(!candivide(arrayB, gcda)) ans = Math.max(ans, gcda);
        if(!candivide(arrayA, gcdb)) ans = Math.max(ans, gcdb);
        
        return ans;
    }
    
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    public boolean candivide(int[] arr, int num) {
        boolean div = false;
        
        for(int a : arr) {
            if(a % num == 0) div = true;
        }
        return div;
    }
    
}