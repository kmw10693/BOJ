import java.util.*;
import java.io.*;

class Solution {
    class Node {
        String num;
        int total;
        Node(String num, int total) {
            this.num = num;
            this.total = total;
        }
    }
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        
        for(String r : records) {
            String[] splits = r.split(" ");
            String time = splits[0];
            String num = splits[1];
            String inout = splits[2];
            
            int contime = convert(time);
            if(inout.equals("IN")) {
                map.put(num, contime);
            }
            else if(inout.equals("OUT")) {
                int eachtime = map.get(num);
                int gap = contime - eachtime;
                total.put(num, total.getOrDefault(num, 0) + gap);
                map.remove(num);
            }
        }
        
        for(String key : map.keySet()) {
            if(map.get(key) >= 0) {
                total.put(key, total.getOrDefault(key, 0) + convert("23:59") - map.get(key));
            }
        }
        
        List<Node> ans = new ArrayList<>();
        for(String key : total.keySet()) {
            int time = total.get(key);
            int amount = 0;
            
            if(time > fees[0]) {
                amount = fees[1] + (int)Math.ceil((time-fees[0])/(double)fees[2]) * fees[3];
            } else {
                amount = fees[1];
            }
            ans.add(new Node(key, amount));
        }
        
        ans.sort((a,b) -> a.num.compareTo(b.num));
        int[] result = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            result[i] = ans.get(i).total;
        }
        return result;
    }
    
    public int convert(String s) {
        String[] splits = s.split(":");
        
        return Integer.parseInt(splits[0])*60 + Integer.parseInt(splits[1]);
    }
}