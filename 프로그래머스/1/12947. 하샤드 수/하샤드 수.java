class Solution {
    public boolean solution(int x) {
        int tmp = x;
        int ans = 0;
        while(tmp > 0) {
            ans += tmp%10;
            tmp/=10;
        }
        System.out.println(ans);
        return (x % ans == 0);
    }
}