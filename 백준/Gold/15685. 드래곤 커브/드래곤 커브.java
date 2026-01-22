import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Curve[] curves;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        curves = new Curve[n];
        // map은 100x100임
        map = new boolean[101][101];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            curves[i] = new Curve(x, y, d, g);
        }
        // 드래곤 커브 그리기
        for(int i=0; i<n; i++) {
            draw(i);
        }
        // 정답
        int ans = 0;
        // 네 꼭짓점이 모두 드래곤 커브의 일부인지 판단 (0,0) ~ (99, 99)
        for(int i=0; i<=99; i++) {
            for(int j=0; j<=99; j++) {
                // 4 방향의 꼭짓점이 찍혀있는지 확인
                int curX = i, curY = j;
                int dir = 0;
                boolean check = true;
                for(int k=0; k<4; k++) {
                    if(!map[curX][curY]) {
                        check = false;
                        break;
                    }
                    curX += dx[dir];
                    curY += dy[dir];

                    // 반시계 방향으로 돌리기
                    dir--;
                    if(dir < 0) dir = 3;
                }
                if(check) ans++;
            }
        }

        System.out.print(ans);
    }

    static void draw(int index) {
        // 처음부터 방향을 기억해놓기
        List<Integer> dir = new ArrayList<>();
        Curve curve = curves[index];
        // 0번째 넣기
        dir.add(curve.d);

        for(int i=0; i<curve.g; i++) {
            // 임시 방향 넣어두기
            List<Integer> tempDir = new ArrayList<>();
            for(int j=dir.size()-1; j>=0; j--) {
                tempDir.add((dir.get(j) + 1) % 4);
            }
            dir.addAll(tempDir);
        }

        // 방향 읽어서 map에 꼭짓점 찍기
        map[curve.y][curve.x] = true;
        // 처음 좌표
        int firstX = curve.y;
        int firstY = curve.x;
        for(int i=0; i<dir.size(); i++) {
            // 각 방향으로 1 이동한뒤 꼭짓점 찍으면 됨
            firstX += dx[dir.get(i)];
            firstY += dy[dir.get(i)];
            map[firstX][firstY] = true;
        }
    }

    static class Curve {
        int x, y, d, g;
        Curve(int x, int y, int d, int g){
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
        }
    }
}