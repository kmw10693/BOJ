import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] xcnt = new int[10];
        int[] ycnt = new int[10];
        
        for(String x : X.split("")){
            xcnt[Integer.parseInt(x)]++;
        }
        for(String y : Y.split("")) {
            ycnt[Integer.parseInt(y)]++;
        }
        for(int i=9; i>=0; i--){
            while(xcnt[i] > 0 && ycnt[i] >0){
                answer.append(i);
                xcnt[i]--;
                ycnt[i]--;
            }
        }
        
        if("".equals(answer.toString())) return "-1";
        if("0".equals(answer.toString().substring(0,1))) return "0";
        
        return answer.toString();
    }
}