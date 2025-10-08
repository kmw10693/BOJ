import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    public static boolean[] visited;

    //링크 팀의 능력치의 차이를 최소로 하려고 한다.
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 맵 입력
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 예를 들어, 1, 2번이 스타트 팀, 3, 4번이 링크 팀에 속한 경우에 두 팀의 능력치는 아래와 같다.
        // 백트래킹 N/2 하기
        // 인덱스, 개수
        visited = new boolean[N+1];
        backtrack(0, 0);

        System.out.println(ans);
    }

    public static void backtrack(int index, int cnt) {
        // 종료 조건 n == n/2일때 계산
        if(cnt == N/2) {
            diff();
            return;
        }

        // N번 돌리면서, 백트래킹
        for(int i=index; i<N; i++) {
            // visit 배열 만들어야 함
            if(!visited[i]) {
                visited[i] = true;
                backtrack(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
    public static void diff() {
        //  능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다.
        //  Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(visited[i] && visited[j]) {
                    sum1 += (map[i][j] + map[j][i]);
                }
                if(!visited[i] && !visited[j]) {
                    sum2 += (map[i][j] + map[j][i]);
                }
            }
        }
        ans = Math.min(Math.abs(sum1-sum2), ans);
    }
}