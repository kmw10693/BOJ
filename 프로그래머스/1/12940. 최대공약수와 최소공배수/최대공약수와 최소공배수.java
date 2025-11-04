class Solution {
    int gcd(int n, int m) {
        int r = 0;
        while(m > 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
    
    public int[] solution(int n, int m) {
        int [] answer = new int[2];
        if(n < m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        answer[0] = gcd(n,m);
        answer[1] = n*m/answer[0];
        return answer;
    }
}