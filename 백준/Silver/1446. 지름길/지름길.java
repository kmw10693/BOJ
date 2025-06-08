import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N, D;
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[][] load = new int[N + 1][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            load[i][0] = Integer.parseInt(st.nextToken());
            load[i][1] = Integer.parseInt(st.nextToken());
            load[i][2] = Integer.parseInt(st.nextToken());
        }

        // dp 배열
        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i - 1] +1, dp[i]);
            for(int j=0; j<N; j++) {
                if(load[j][1] == i) {
                    dp[i] = Math.min(dp[i], dp[load[j][0]] + load[j][2]);
                }
            }
        }
        System.out.print(dp[D]);
    }
}