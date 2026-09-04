import java.util.*;
import java.io.*;

class Solution {
    List<int[]> anslist = new ArrayList<>();
    int maxgap = Integer.MIN_VALUE;
    
    public void dfs(int[] info, int n, int lastidx, int[] lions) {
        if(n == 0) {
            int apeach = 0;
            int lion = 0;
            
            for(int i=0; i<info.length; i++) {
                if(info[i] == 0 && lions[i] == 0) continue;
                if(info[i] >= lions[i]) apeach += (10-i);
                else lion += (10-i);
            }
        
            if(lion > apeach) {
                int gap = lion - apeach;
                if(gap > maxgap) {
                    anslist.clear();
                    anslist.add(lions.clone());
                } 
                else if(gap == maxgap) {
                    anslist.add(lions.clone());
                }
                maxgap = Math.max(gap, maxgap);
            }
            return;
        }
        
        for(int i=0; i<info.length; i++) {
            if(lastidx >= i) continue;
            if(n > info[i]) {
                lions[i] = info[i] + 1;
                n -= (info[i] + 1);  
                dfs(info, n, i, lions);
                n += (info[i] + 1);
                lions[i] = 0;
            } else {
                lions[10] = n;
                n = 0;
                dfs(info, n, i, lions);
                n += (lions[10]);
                lions[10] = 0;
            }
        }
    }
    public int[] solution(int n, int[] info) {
        dfs(info, n, -1, new int[info.length]);
        
        if(maxgap == Integer.MIN_VALUE) return new int[]{-1};
        
        Collections.sort(anslist, (a,b) -> {
            for(int i=a.length-1; i>=0; i--) {
                if(a[i] != b[i]) return b[i] - a[i];
            }
            return b[0] - a[0];
        });
        System.out.println(anslist.size());
        
        return anslist.get(0);
    }
}