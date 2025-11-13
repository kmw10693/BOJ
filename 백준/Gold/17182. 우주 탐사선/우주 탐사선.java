import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist;
    static int N,K, ans = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0; k<N; k++){
            for(int j=0; j<N; j++) {
                for(int i=0; i<N; i++) {
                    if(dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        visited = new boolean[N];
        visited[K] = true;
        perm(1, K, 0);
        System.out.println(ans);
    }
    static void perm(int cnt, int prev, int d) {
        if(cnt == N) ans = Math.min(ans, d);

        for(int i=0; i<N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            perm(cnt+1, i, d + dist[prev][i]);
            visited[i] = false;
        }
    }
}