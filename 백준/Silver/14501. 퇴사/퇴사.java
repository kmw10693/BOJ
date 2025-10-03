import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int ans = -0x7f7f7f7f;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[100][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        // 시간복잡도
        System.out.println(ans);
    }

    public static void dfs(int index, int sum) {
        // 종료 조건
        if(index >= N) {
            ans = Math.max(ans, sum);
            return;
        }

        if(index + map[index][0] <= N) {
            dfs(index + map[index][0], sum + map[index][1]);
        } else {
            dfs(index + map[index][0], sum);
        }
        dfs(index+1, sum);
    }
}