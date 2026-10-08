class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 1;
        
        for(int time : times) {
            right = Math.max(right, time);
        }
        
        right = right * n;
        
        while(left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            for(int time : times) {
                count += (mid / time);
            }
            
            if(count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}