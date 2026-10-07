import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
       int total = new HashSet<>(Arrays.asList(gems)).size();
       Map<String, Integer> map = new HashMap<>();
        
       int left = 0;
       int beststart = 0;
       int bestend = gems.length-1;
       int minlength = gems.length;
        
        for(int right=0; right <gems.length; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
        
        while(map.size() == total) {
            int length = right - left + 1;
            
            if(length < minlength) {
                minlength = length;
                beststart = left;
                bestend = right;
            }
            
            String gem = gems[left];
            map.put(gem, map.get(gem)-1);
            
            if(map.get(gem) == 0) {
                map.remove(gem);
            }
            left++;
        }
        }
            return new int[]{beststart+1, bestend+1};
    }
}