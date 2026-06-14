import java.io.*;
import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        // 스포일러 문자
        boolean[] sprange = new boolean[message.length()];
        
        for(int[] sr : spoiler_ranges) {
            for(int i=sr[0]; i<=sr[1]; i++) {
                sprange[i] = true;
            }    
        }
        
        int st = 0;
        List<String> allwords = new ArrayList<>();
        List<Boolean> isSpolier = new ArrayList<>();
        while(st < message.length()) {
            if(message.charAt(st) == ' ') {
                st++;
                continue;
            }
            int tmpstart = st;
            
            boolean eachspolier = false;
            while(st < message.length() && message.charAt(st) != ' ') {
                if(sprange[st] == true) eachspolier = true;
                st++;
            }
            allwords.add(message.substring(tmpstart, st));
            isSpolier.add(eachspolier);
        }
        
        Set<String> notspoliers = new HashSet<>();
        for(int i=0; i<allwords.size(); i++) {
            if(isSpolier.get(i) == true) continue;
            notspoliers.add(allwords.get(i));
        }
        
        int ans = 0;
        Set<String> dupspoliers = new HashSet<>();
        for(int i=0; i<allwords.size(); i++) {
            String eachword = allwords.get(i);
            if(isSpolier.get(i) == false) continue;
            if(notspoliers.contains(eachword)) continue;
            if(dupspoliers.contains(eachword)) continue;
            dupspoliers.add(eachword);
            ans++;
        }
        return ans;
    }
}