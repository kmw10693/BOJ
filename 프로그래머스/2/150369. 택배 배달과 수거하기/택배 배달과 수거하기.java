class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deli = 0, pick = 0;
        for(int i=n-1; i>=0; i--) {
            deli -= deliveries[i];
            pick -= pickups[i];
            
            while(deli < 0 || pick < 0) {
                deli += cap;
                pick += cap;
                answer += (i+1)*2;
            }
        }
        return answer;
    }
}