import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] sequence) {
        long dp1 = sequence[0];
        long dp2 = -sequence[0];
        long ans = Math.max(dp1, dp2);
        
        for(int i=1; i<sequence.length; i++) {
            long num1, num2;
            if(i % 2 == 0) {
                num1 = sequence[i];
                num2 = -sequence[i];
            }
            else {
                num1 = -sequence[i];
                num2 = sequence[i];
            }
            
            dp1 = Math.max(dp1+num1, num1);
            dp2 = Math.max(dp2+num2, num2);
            
            ans = Math.max(ans, Math.max(dp1, dp2));
        }
        return ans;
    }
}