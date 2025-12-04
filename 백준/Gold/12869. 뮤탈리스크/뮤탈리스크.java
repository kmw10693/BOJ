import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][][] dp;
    static int[] map = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[map[0]+1][map[1]+1][map[2]+1];
        for(int i=0; i<map[0]+1; i++) {
            for(int j=0; j<map[1]+1; j++) {
                for(int k=0; k<map[2]+1; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(dfs(map[0], map[1], map[2]));
    }

    public static int dfs(int first, int second, int third) {
        first = Math.max(first, 0);
        second = Math.max(second, 0);
        third = Math.max(third, 0);

        if(first == 0 && second == 0 && third == 0) return 0;

        if(dp[first][second][third] != -1) {
            return dp[first][second][third];
        }

        int result = 0x7fffffff;
        result = Math.min(result, dfs(first-9, second-3, third-1) + 1);
        result = Math.min(result, dfs(first-9, second-1, third-3) + 1);
        result = Math.min(result, dfs(first-3, second-9, third-1) + 1);
        result = Math.min(result, dfs(first-3, second-1, third-9) + 1);
        result = Math.min(result, dfs(first-1, second-9, third-3) + 1);
        result = Math.min(result, dfs(first-1, second-3, third-9) + 1);

        return dp[first][second][third] = result;
    }
}