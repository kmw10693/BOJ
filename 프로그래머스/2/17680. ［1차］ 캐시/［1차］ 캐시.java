import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        Set<String> cache = new HashSet<>();
        if(cacheSize == 0) return 5*cities.length;
        int result = 0;
        for(String city : cities) {
            String name = city.toLowerCase();
            
            if(cache.contains(name)) {
                q.remove(name);
                result += 1;
            } else {
                result += 5;
    
                if(cache.size() == cacheSize) {
                    String k = q.poll();
                    cache.remove(k);
                }
            }
            q.add(name);
            cache.add(name);
        }
        return result;
    }
}