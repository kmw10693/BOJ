class Solution {
    public long solution(int r1, int r2) {
        long ans = 0;
        for(int y=1; y<=r2; y++) {
            long x = (long) Math.sqrt(Math.pow(r2, 2) - Math.pow(y, 2));
            long x2 = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(y, 2)));
            ans += (x+1 - x2);
        }
        return ans * 4;
    }
}