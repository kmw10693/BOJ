
import java.io.*;
import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int ans = 0;
        boolean[] spidx = new boolean[message.length()];
        Arrays.fill(spidx, false);
        
        for(int[] spr : spoiler_ranges) {
            int start_range = spr[0];
            int end_range = spr[1];
            
            for(int i=start_range; i<=end_range; i++) {
                spidx[i] = true;
            }
        }

        Set<String> spoilerwords = new HashSet<>();
        List<String> nonspoilerwords = new ArrayList<>();
        
        int startidx = 0;
        while(startidx < message.length()) {
            if(message.charAt(startidx) == ' ') {
                startidx++;
                continue;
            }
            int eachstartidx = startidx;
            boolean isspoiler = false;
            while(startidx < message.length() && message.charAt(startidx) != ' ') {
                if(spidx[startidx] == true) {
                    isspoiler = true;
                }
                startidx++;
            }
            String eachword = message.substring(eachstartidx, startidx);
            if(isspoiler) spoilerwords.add(eachword);
            else nonspoilerwords.add(eachword);
        }
        // for(String sw : spoilerwords) System.out.println(sw);
        // for(String nsw : nonspoilerwords) System.out.println(nsw);
        
        for(String sw : spoilerwords) {
            if(!nonspoilerwords.contains(sw)) ans++;
        }
        return ans;
    }
}