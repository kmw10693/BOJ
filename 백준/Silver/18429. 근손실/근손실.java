import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] map;
    static int[] visited;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N];
        visited = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            if(map[i] - K < 0) continue;
            visited[i] = 1;
            dfs(1, map[i]-K);
            visited[i] = 0;
        }
        System.out.println(ans);
    }
    public static void dfs(int count, int sum) {
        if(count == N) {
            if(sum >= 0) ans++;
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[i] == 1) continue;
            if(sum + map[i] < K) continue;
            visited[i] = 1;
            dfs(count+1, sum+map[i]-K);
            visited[i] = 0;
        }
    }
}