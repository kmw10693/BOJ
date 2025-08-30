import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] files;
    static int[][] dp;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int K = Integer.parseInt(br.readLine());
            files = new int[K+1];
            dp = new int[K+1][K+1];
            sum = new int[K+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k=1; k<=K; k++) {
                files[k] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[k], Integer.MAX_VALUE);
                sum[k] = sum[k-1] + files[k];
            }
            sb.append(mergefiles(1, K)).append('\n');
        }
        System.out.print(sb.toString());
    }
    private static int mergefiles(int start, int end) {
        if (dp[start][end] == Integer.MAX_VALUE) {
            if(start == end) {
                dp[start][end] = 0;
            } else if (start+1 == end) {
                dp[start][end] = files[start] + files[end];
            } else {
                int subSum = sum[end] - sum[start-1];
                dp[start][end] = mergefiles(start+1, end) + subSum;
                for(int i=start+1; i<end; i++) {
                    dp[start][end] = Math.min(dp[start][end], mergefiles(start, i) +  mergefiles(i + 1, end) + subSum);
                }
            }
        }
        return dp[start][end];
    }
}