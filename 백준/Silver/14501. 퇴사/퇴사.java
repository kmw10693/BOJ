import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tarr = new int[N+1];
        int[] parr = new int[N+1];
        int[] dp = new int[N+2];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tarr[i] = Integer.parseInt(st.nextToken());
            parr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i번째 부터 시작할때 최대 수익
        for(int i=N; i>=1; i--) {
            if(i + tarr[i] <= N+1) {
                dp[i] = Math.max(parr[i] + dp[i+tarr[i]], dp[i+1]);
            } else {
                dp[i] = dp[i+1];
            }
        }
        System.out.println(dp[1]);
    }
}