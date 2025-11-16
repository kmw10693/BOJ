import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<Integer>();
            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] dp = new int[n+1][h+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=h; j++) {
                for(int block: list[i]) {
                    if(j==block) dp[i][j]++;
                    if(j > block) {
                        dp[i][j] += dp[i-1][j-block];
                    }
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }
        System.out.println(dp[n][h]);
    }
}