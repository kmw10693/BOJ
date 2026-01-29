import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int result = 999999;
        
        for(int i=1; i<=s.length(); i++) {
            StringBuilder tmps = new StringBuilder();
            // 처음 문자
            String compare = s.substring(0, i);
            int start = i;
            int cnt = 1;
            // 비교 문자
            while(start + i <= s.length()) {
                String compare2 = s.substring(start, start+i);
                if(compare.equals(compare2)) {
                    cnt++;
                    start += i;
                } else {
                    if(cnt >= 2) {
                        tmps.append(cnt);
                        tmps.append(compare);
                    } else if(cnt == 1) {
                        tmps.append(compare);
                    }
                    compare = s.substring(start, start+i);
                    start += i;
                    cnt = 1;
                }
            }
            for(int j=start; j<=s.length(); j++) {
                String compare2 = s.substring(j, s.length());
                if(compare.equals(compare2)) {
                    cnt++;
                    j += i;
                } else {
                    if(cnt >= 2) {
                        tmps.append(cnt);
                        tmps.append(compare);
                    } else if(cnt == 1) {
                        tmps.append(compare);
                    }
                    tmps.append(s.substring(j, s.length()));
                    break;
                }
            }
            result = Math.min(result, tmps.length());
        }
        return result;
    }
}