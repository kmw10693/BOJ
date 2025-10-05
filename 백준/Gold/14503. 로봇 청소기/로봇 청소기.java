import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int x,y,count;
    static int[][] map;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int r,c,d;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[y][x];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        count = 1;
        for(int i=0; i<y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r,c,d);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int dir) {
        // 현재 위치 청소
        map[r][c] = -1;

        // 현재 위치에서 현재 방향 기준으로 왼쪽 방향부터 탐색
        for(int i=0; i<4; i++) {
            dir = (dir+3) % 4;
            int ny = r + dy[dir];
            int nx = c + dx[dir];

            if(ny >= 0 && ny < y && nx >=0 && nx < x && map[ny][nx] == 0) {
                count++;
                dfs(ny, nx, dir);
                return;
            }
        }

        int back = (dir+2) % 4;
        int by = r + dy[back];
        int bx = c + dx[back];

        if(by >= 0 && by < y && bx>=0 && bx<x && map[by][bx] != 1) {
            dfs(by, bx, dir);
        }

    }
}