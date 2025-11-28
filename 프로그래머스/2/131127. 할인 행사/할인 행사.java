import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantmap = new HashMap<>();
        
        for(int i=0; i<want.length; i++) {
            wantmap.put(want[i], number[i]);
        }
        int ans = 0;
        for(int i=0; i<discount.length; i++) {
            if(i+9 >= discount.length) break;
            Map<String, Integer> tempMap = new HashMap<>();
            // i+10 - i = 10
            for(int j=i; j<=i+9; j++) {
                tempMap.put(discount[j], tempMap.getOrDefault(discount[j], 0)+1);
            }
            
            int check = 1;
            for(String key : wantmap.keySet()) {
                if(tempMap.get(key) == null) {
                    check = 0;
                    break;
                }
                if(tempMap.get(key) < wantmap.get(key)) {
                    check = 0;
                }
            }
            if(check == 1) ans++;
        }
        return ans;
    }
}