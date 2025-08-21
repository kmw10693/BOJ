import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int[] W;
    static int[] V;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N][K + 1];
        W = new int[N];
        V = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<K+1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(N - 1, K));
    }

    private static int knapsack(int N, int K) {
        if (N < 0) return 0;

        if (dp[N][K] == -1) {
            if (W[N] > K) {
                dp[N][K] = knapsack(N - 1, K);
            } else {
                dp[N][K] = Math.max(knapsack(N - 1, K), knapsack(N - 1, K - W[N]) + V[N]);
            }
        }

        return dp[N][K];
    }
}