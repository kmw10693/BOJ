import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m, ans;
        ans = Integer.MAX_VALUE;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int sumValue = 0;
        int[] memory = new int[n];
        int[] time = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
            sumValue += time[i];
        }

        int[][] dp = new int[n][sumValue+1];

        for(int i=0; i<n; i++) {
            int timeV = time[i];
            int me = memory[i];

            for(int j=0; j<=sumValue; j++) {
                if(i == 0) {
                    if(timeV <= j) {
                        dp[i][j] = me;
                    }
                }
                else {
                    if(timeV <= j) {
                        dp[i][j] = Math.max(dp[i-1][j-timeV] + me, dp[i-1][j]);
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }

                if(dp[i][j] >= m) {
                    ans = Math.min(ans, j);
                }
            }
        }

        System.out.println(ans);
    }
}