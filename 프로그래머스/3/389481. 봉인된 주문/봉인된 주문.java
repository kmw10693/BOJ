import java.util.*;

class Solution {
    static long[] pow = new long[12];
    
    private long stringToRank(String s) {
        int len = s.length();
        
        long rank = 0;
        for(int i=1; i<len; i++) {
            rank += pow[i];
        }
        
        long value = 0;
        
        for(int i=0; i<len; i++) {
            value = value * 26 + (s.charAt(i) - 'a');
        }
        rank += value + 1;
        return rank;
    }
    
    private String rankToString(long rank) {
        int len = 1;
        
        while(rank > pow[len]) {
            rank -= pow[len];
            len++;
        }
        
        long value = rank - 1;
        char[] result = new char[len];
        
        for(int i=len-1; i>=0; i--) {
            result[i] = (char) ('a' + value % 26);
            value /= 26;
        }
        return new String(result);
    }
    
    private int upperBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public String solution(long n, String[] bans) {
        pow[0] = 1;
        for(int i=1; i<=11; i++) {
            pow[i] = pow[i-1] * 26;
        }
        
        long[] bannedRanks = new long[bans.length];
        
        for(int i=0; i<bans.length; i++) {
            bannedRanks[i] = stringToRank(bans[i]);
        }
        
        Arrays.sort(bannedRanks);
        
        long left = 0;
        long right = 0;
        for(int len=1; len<=11; len++) {
            right += pow[len];
        }
        
        while(left < right) {
            long mid = left + (right - left) / 2;
            
            long bannedCount = upperBound(bannedRanks, mid);
            long remainCount = mid - bannedCount;
            
            if(remainCount >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return rankToString(left);
    }
}