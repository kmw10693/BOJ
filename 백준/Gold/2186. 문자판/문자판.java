import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static int[][][] dp;
    static String ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        ans = br.readLine();
        dp = new int[N][M][ans.length()];

        int cnt = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=0; k<ans.length(); k++) dp[i][j][k] = -1;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == ans.charAt(0)) cnt += dfs(i, j, 0);
            }
        }
        System.out.println(cnt);
    }
    private static int dfs(int x, int y, int cnt) {
        if(dp[x][y][cnt] != -1) return dp[x][y][cnt];
        if(cnt == ans.length()-1) return dp[x][y][cnt] = 1;

        dp[x][y][cnt] = 0;

        for(int i=0; i<4; i++) {
            for(int j=1; j<=K; j++) {
                int nxtX = x + (dx[i] * j);
                int nxtY = y + (dy[i] * j);

                if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >=M) continue;
                if(map[nxtX][nxtY] == ans.charAt(cnt+1)) {
                    dp[x][y][cnt] += dfs(nxtX, nxtY, cnt+1);
                }
            }
        }
        return dp[x][y][cnt];
    }
}