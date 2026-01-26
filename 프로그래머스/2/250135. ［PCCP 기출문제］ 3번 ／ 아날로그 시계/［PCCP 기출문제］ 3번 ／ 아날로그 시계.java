class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startTime = tosec(h1, m1, s1);
        int endTime = tosec(h2, m2, s2);
        // 시작 시간이 몇번 마주치는가?
        int ans = calc(endTime) - calc(startTime);
        ans += calc2(startTime) ? 1 : 0;
        return ans;
    }
    private boolean calc2(int startTime) {
        return (startTime * 59) % 3600 == 0 || (startTime * 719) % 43200 == 0;
    }
    private int calc(int sec) {
        int tmp = 0;
        tmp += sec * 59 / 3600;
        tmp += sec * 719 / 43200;
        
        if(sec >= 43200) tmp--;
        return tmp;
    }
    private int tosec(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }
}