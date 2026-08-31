import java.util.*;
import java.io.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        for(String i : info) {
            String[] each = i.split(" ");
            List<String> combarr = new ArrayList<>();
            
            for(String e : each) {
                combarr.add(e);
            }
            combination(0, "", combarr);
        }
        
        for(List<Integer> m : map.values()) {
            Collections.sort(m);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(String q : query) {
            String[] splits = q.split(" ");
            String key = splits[0] + " and " + splits[2] + " and " + splits[4] + " and " + splits[6];
            int score = Integer.parseInt(splits[7]);
            
            if(!map.containsKey(key)) {
                result.add(0);
                continue;
            }

            List<Integer> eachmap = map.get(key);
            int eachresult = lowerbound(score, eachmap);
            result.add(eachresult);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int lowerbound(int score, List<Integer> eachmap) {
        int left = 0;
        int right = eachmap.size();
        
        while(left < right) {
            int mid = (left + right) / 2;
            
            if(eachmap.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return eachmap.size() - left;
    }
    
    public void combination(int cnt, String result, List<String> combarr) {
        if(cnt == 4) {
            int score = Integer.parseInt(combarr.get(4));
            map.computeIfAbsent(result, k -> new ArrayList<>())
                .add(score);
            return;
        }
        
        if(cnt >= 1) {
            result += " and ";
        }
        
        combination(cnt+1, result + combarr.get(cnt), combarr);
        combination(cnt+1, result + "-", combarr);
    }
}