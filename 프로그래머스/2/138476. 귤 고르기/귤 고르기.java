import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> m = new HashMap<>();

        for(int t : tangerine) {
            m.put(t, m.getOrDefault(t,0) + 1);
        }

        List<Integer> sortlist = new ArrayList<>(m.keySet());

        sortlist.sort((a,b) -> m.get(b).compareTo(m.get(a)));

        int result = 0;
        for(int s : sortlist) {

            if(m.get(s) >= k) {
                result++;
                break;
            } else {
                result++;
                k -= m.get(s);
            }
        }
        return result;
    }
}