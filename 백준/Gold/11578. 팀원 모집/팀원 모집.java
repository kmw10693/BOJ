import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] scoremap;
    static int ans = 0x7fffffff;
    static int[] visited;
    static boolean[] numvis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        scoremap = new int[M][50];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int O = Integer.parseInt(st.nextToken());
            for(int j=0; j<O; j++) {
                scoremap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=M; i++) {
            visited = new int[N];
            numvis = new boolean[M];
            dfs(0, i);
        }
        if(ans == 0x7fffffff) System.out.println(-1);
        else System.out.println(ans);
    }
    public static void dfs(int cnt, int last) {
        if(cnt == last) {
            for(int i=0; i<visited.length; i++) {
                if(visited[i] == 0) return;
            }
            ans = Math.min(ans, last);
            return;
        }

        for(int i=0; i<scoremap.length; i++) {
            if(numvis[i]) continue;
            for(int j=0; j<50; j++) {
                if(scoremap[i][j] == 0) break;
                visited[scoremap[i][j]-1]++;
            }
            numvis[i] = true;
            dfs(cnt+1, last);
            numvis[i] = false;
            for(int j=0; j<50; j++) {
                if(scoremap[i][j] == 0) break;
                visited[scoremap[i][j]-1]--;
            }
        }
    }
}