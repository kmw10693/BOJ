import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다.
    static int N, M;
    static int[][] map;
    static long ans = -0x7f7f7f7f;

    // dfs 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 방문 배열
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];

        // 첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.
        // N*M*4^5
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(1, i, j, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(ans);
    }

    public static void dfs(int count, int x, int y, int sum) {
        // 종료 조건
        if (count == 4) {
            // 최댓값 초기화
            ans = Math.max(ans, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nxtX = x + dx[i];
            int nxtY = y + dy[i];

            // 범위 제한
            if (nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= M) continue;
            // visited도 ㅊ
            if(visited[nxtX][nxtY]) continue;

            // visited도 해야지
            visited[nxtX][nxtY] = true;

            // 두번째 돌았을때는 현재 좌표를 넣어줘야 함. 일종의 트릭
            if (count == 2) {
                // 근데 이렇게 하면 방문 할 수 있지 않나. visited 배열의 위반?
                dfs(count+1, x, y, sum + map[nxtX][nxtY]);
            }

            // 아닐떄는 그냥 dfs
            dfs(count+1, nxtX, nxtY, sum + map[nxtX][nxtY]);
            visited[nxtX][nxtY] = false;
        }
    }
}