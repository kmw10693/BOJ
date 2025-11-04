class Solution {
    public int solution(int num) {
        int tmp = 0;
        if(num == 1) return 0;
        long ans = (long) num;
        while(tmp < 500) {
            if(ans % 2 == 0) ans /= 2;
            else ans = ans*3 + 1;
            tmp++;
            if(ans == 1) return tmp;
        }
        return -1;
    }
}