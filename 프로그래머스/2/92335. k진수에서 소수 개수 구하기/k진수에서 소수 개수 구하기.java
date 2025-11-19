import java.util.*;

class Solution {
    public int solution(int n, int k) {
        // 소수 바꾸기
        String temp = "";
        while(n != 0) {
            temp = n%k + temp;
            n /= k;
        }
        int answer =0;
        String[] temps = temp.split("0");
        for(int i=0; i<temps.length; i++) {
            if(temps[i].equals("")) continue;
            if(isPrime(Long.parseLong(temps[i])) == 1) answer++;
        }
        return answer;
    }
    public int isPrime(Long k) {
        if(k < 2) return 0;
        for(int i=2; i<=Math.sqrt(k); i++) {
            if(k%i == 0) return 0;
        }
        return 1;
    }
}