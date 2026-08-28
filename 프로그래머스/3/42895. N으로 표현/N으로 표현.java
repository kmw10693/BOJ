import java.util.*;
import java.io.*;


class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());
        
        for(int i=1; i<=8; i++) {
            Set<Integer> eachlist = new HashSet<>();
            
            int repeat = 0;
            for(int j=1; j<=i; j++) {
                repeat += N * Math.pow(10, j-1);
            }
            
            eachlist.add(repeat);
            for(int j=1; j<i; j++) {
                for(int n1 : dp.get(j)) {
                    for(int n2 : dp.get(i-j)) {
                        eachlist.add(n1 + n2);
                        eachlist.add(n1 - n2);
                        eachlist.add(n1 * n2);
                        if(n2 != 0) eachlist.add(n1 / n2);
                    }
                }
            }
            if(eachlist.contains(number)) return i;
            dp.add(eachlist);
        }
        
        return -1;
    }
}