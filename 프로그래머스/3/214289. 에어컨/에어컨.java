import java.util.*;
import java.io.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        temperature += 10;
        t1 += 10;
        t2 += 10;
        
        // i초일때 온도가 j일 경우 최솟값 dp
        int[][] dp = new int[onboard.length][51];
        
        for(int i=0; i<onboard.length; i++) {
            for(int j=0; j<51; j++) {
                dp[i][j] = 1000000;
            }
        }
        
        // 외부온도가 실내온도보다 낮은 경우 
        int flag = 1;
        if(temperature > t2) flag = -1;
        
        dp[0][temperature] = 0;
        
        for(int i=1; i<onboard.length; i++) {
            for(int j=0; j<=50; j++) {
                if((onboard[i] == 1 && j >= t1 && j <= t2) || onboard[i] == 0) {
                    int minValue = 1000000;
                    
                    if(j+flag >= 0 && j+flag <= 50) {
                        minValue = Math.min(minValue, dp[i-1][j+flag]);
                    }
                    
                    if(j == temperature) minValue = Math.min(minValue, dp[i-1][j]);
                    
                    if(j-flag >= 0 && j-flag <= 50) {
                        minValue = Math.min(minValue, dp[i-1][j-flag] + a);
                    }
                    
                    if(j != temperature) minValue = Math.min(minValue, dp[i-1][j] + b);
                    
                    dp[i][j] = minValue;
                }
                
            }
        }
        
        int answer = 1000000;
        
        for(int i=0; i<=50; i++) {
            answer = Math.min(dp[onboard.length-1][i], answer);
        }
        
        return answer;
        
    }
}