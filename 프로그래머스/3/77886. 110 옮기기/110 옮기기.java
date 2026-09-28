import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int idx =0; idx<s.length; idx++) {
            String str = s[idx];
            StringBuilder stack = new StringBuilder();
            
            int count = 0;
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                stack.append(c);
                int len = stack.length();
                
                if(len >= 3 && stack.charAt(len-3) == '1' && stack.charAt(len-2) == '1' && stack.charAt(len-1) == '0') {
                    stack.delete(len-3, len);
                    count++;
                }
            }
            
            if(count ==0) {
                answer[idx] = str;
                continue;
            }
            
            int lastZero = -1;
            for(int i=stack.length()-1; i>=0; i--) {
                if(stack.charAt(i) == '0') {
                    lastZero = i;
                    break;
                }
            }
            StringBuilder result = new StringBuilder();
            
            if(lastZero != -1) {
                result.append(stack.substring(0, lastZero + 1));
            }
            
            for(int i=0; i<count; i++) {
                result.append("110");
            }
            
            if(lastZero != -1) {
                result.append(stack.substring(lastZero + 1));
            } else {
                result.append(stack);
            }
            answer[idx] = result.toString();
            
        }
        return answer;
    }
}