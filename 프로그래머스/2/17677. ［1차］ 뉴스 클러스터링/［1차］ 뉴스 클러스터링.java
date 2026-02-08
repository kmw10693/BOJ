import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> str1list = new ArrayList<>();
        List<String> str2list = new ArrayList<>();
        
        for(int i=0; i<str1.length(); i++) {
            if(i+1 >= str1.length()) break;
            String part = "";
            part += str1.charAt(i);
            part += str1.charAt(i+1);
            part = part.toLowerCase();
            if(part.charAt(0) < 'a' || part.charAt(0) > 'z') continue;
            if(part.charAt(1) < 'a' || part.charAt(1) > 'z') continue;
            str1list.add(part);
        }
        
        for(int i=0; i<str2.length(); i++) {
            if(i+1 >= str2.length()) break;
            String part = "";
            part += str2.charAt(i);
            part += str2.charAt(i+1);
            part = part.toLowerCase();
            if(part.charAt(0) < 'a' || part.charAt(0) > 'z') continue;
            if(part.charAt(1) < 'a' || part.charAt(1) > 'z') continue;
            str2list.add(part);
        }
        
        Map<String, Integer> str1map = new HashMap<>();
        Map<String, Integer> str2map = new HashMap<>();
        
        for(String s : str1list) {
            str1map.put(s, str1map.getOrDefault(s, 0) + 1);
        }
        for(String s : str2list) {
            str2map.put(s, str2map.getOrDefault(s, 0) + 1);
        }
        
        int gyo = 0;
        int hap = 0;
        
        for(String s : str1map.keySet()){
            int p1 = str1map.get(s);
            int p2 = 0;
            if(str2map.containsKey(s)) {
                p2 = str2map.get(s);   
            }
            
            if(p1 < p2) gyo += p1;
            else gyo += p2;
        }
        
        for(String s : str1map.keySet()) {
            int p1 = str1map.get(s);
            int p2 = 0;
            if(str2map.containsKey(s)) {
                p2 = str2map.get(s);   
            }
            
            if(p1 > p2) {
                hap += p1;
                str1map.put(s, -1);
                str2map.put(s, -1);
            } else {
                hap += p2;
                str1map.put(s, -1);
                str2map.put(s, -1);
            }
        }
        
        for(String s : str1map.keySet()) {
            if(str1map.get(s) != -1) {
                hap += str1map.get(s);
            }
        }
        for(String s : str2map.keySet()) {
            if(str2map.get(s) != -1) {
                hap += str2map.get(s);
            }
        }

        if(hap == 0) return 65536;
        return (int)(((double)gyo/hap) * 65536);
    }
}