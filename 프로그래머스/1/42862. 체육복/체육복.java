import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostlength = lost.length;
        Set<Integer> losts = new HashSet<>();
        Set<Integer> reserves = new HashSet<>();
        
        for(int l : lost) {
            losts.add(l);
        }
        for(int r : reserve) {
            reserves.add(r);
        }
        
        for(int l : lost) {
            if(reserves.contains(l)) {
                losts.remove(l);
                reserves.remove(l);
                lostlength--;
            }
        }
        Arrays.sort(lost);
        
        for(int l : lost) {
            if(!losts.contains(l)) continue;
            if(reserves.contains(l-1)) {
                losts.remove(l);
                reserves.remove(l-1);
                lostlength--;
            } else if(reserves.contains(l+1)) {
                losts.remove(l);
                reserves.remove(l+1);
                lostlength--;
            }
        }
        return n - lostlength;
    }
}