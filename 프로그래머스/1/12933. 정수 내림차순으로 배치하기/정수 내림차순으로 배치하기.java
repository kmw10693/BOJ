import java.util.*;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        String[] arr = str.split("");
        
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }
        return Long.parseLong(sb.toString());
     }
}