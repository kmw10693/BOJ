import java.io.*;
import java.util.*;

class Solution {
    long D, S;
    public int solution(int dist_limit, int split_limit) {
        D = dist_limit;
        S = split_limit;
        
        long ans = Long.MIN_VALUE; 
        
        for(long si=1, i=0; si<=S; i++, si*=2) {
            for(long sj=1, j=0; si*sj<=S; j++, sj*=3) {
                ans = Math.max(ans, calleaf(i, j));
            }
        }
        return (int) ans;
    }
    
    public long calleaf(long si, long sj) {
        long leafcnt = 1;
        long bunbaecnt = D;
        
        for(int i=0; i<si; i++) {
            if(bunbaecnt >= leafcnt) {
                bunbaecnt -= leafcnt;
                leafcnt *= 2;
            }
            else {
                return 2*bunbaecnt + (leafcnt - bunbaecnt);
            }
        }
        
        for(int i=0; i<sj; i++) {
            if(bunbaecnt >= leafcnt) {
                bunbaecnt -= leafcnt;
                leafcnt *= 3;
            }
            else {
                return 3*bunbaecnt + (leafcnt - bunbaecnt);
            }
        }
        
        return leafcnt;
    }
}