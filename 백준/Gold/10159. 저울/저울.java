import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            map[y][x] = -1;
        }

        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                    if(map[i][k] == -1 && map[k][j] == -1) map[i][j] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            int cnt = 0;
            for(int j=1; j<=N; j++) {
                if(map[i][j] == 1 || map[i][j] == -1) cnt++;
            }
            sb.append(N-cnt-1 + "\n");
        }
        System.out.print(sb);
    }
}