import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int color;
    static int nocolor;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i=0; i<N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int j=0; j<N; j++) {
                map[i][j] = charArray[j];
            }
        }

        // 적록 색약이 아닌 경우
        color();
        // 적록 색약인 경우
        notcolor();
        StringBuilder sb = new StringBuilder();
        sb.append(color);
        sb.append(" ");
        sb.append(nocolor);
        System.out.print(sb);
    }
    public static void color() {
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    color++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
    }
    public static void notcolor() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'R'|| map[i][j] == 'G') map[i][j] = 'W';
            }
        }

        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) {
                    nocolor++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
    }
    public static void dfs(int x, int y, char c) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nxtX = x + dx[i];
            int nxtY = y + dy[i];
            if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) continue;
            if(map[nxtX][nxtY] != c || visited[nxtX][nxtY]) continue;
            dfs(nxtX, nxtY, c);
        }
    }
}