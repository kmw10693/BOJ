import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, K;

    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        dp = new int[N+1][N+1];

        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(j == 1) dp[i][j] = i;
                else dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) %1000000003;
            }
        }

        if(K == 1) {
            System.out.println(N);
        }
        else {
            System.out.println((dp[N-3][K-1] + dp[N-1][K]) % 1000000003);
        }


    }
}