import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int delete = 0;
        
        while(!s.equals("1")) {
            String temp = "";
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '1') temp += "1";
                else delete++;
            }
            int length = temp.length();
            s = change(length);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = delete;
        return answer;
    }
    public String change(int length) {
        // 3 -> 011
        String temp = "";
        while(length > 0) {
            if(length % 2 == 0) temp += '0';
            else temp += '1';
            length /= 2;
        }
        StringBuffer sb = new StringBuffer(temp);
        String reverse = sb.reverse().toString();
        return reverse;
    }
}