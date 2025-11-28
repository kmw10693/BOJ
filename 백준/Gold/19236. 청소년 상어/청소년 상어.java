import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[][] fish = new int[4][4];
    static Fish[] fishes = new Fish[17];

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                dir = dir - 1;

                fish[i][j] = num;
                fishes[num] = new Fish(i, j, dir, 1, num);
            }
        }

        // 상어
        int sx =0, sy=0;
        int dir = fishes[fish[0][0]].dir;
        fishes[fish[0][0]].alive = 0;
        int sum = fish[0][0];
        fish[0][0] = -1;
        dfs(sx, sy, dir, sum);
        System.out.println(ans);
    }
    public static void dfs(int sx, int sy, int dir, int sum) {
        ans = Math.max(ans, sum);
        int[][] tempfish = new int[4][4];
        for(int i=0; i<4; i++) {
            System.arraycopy(fish[i], 0, tempfish[i], 0, fish.length);
        }

        Fish[] tempfishes = new Fish[17];
        for(int i=1; i<=16; i++) {
            tempfishes[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].dir, fishes[i].alive, fishes[i].num);
        }

        movefish();
        // 상어 움직임
        for(int i=1; i<4; i++) {
            int nxtX = sx + dx[dir] * i;
            int nxtY = sy + dy[dir] * i;
            if(nxtX < 0 || nxtX >=4 || nxtY < 0 || nxtY >= 4) continue;
            if(fish[nxtX][nxtY] == 0) continue;

            int nxtNum = fish[nxtX][nxtY];
            int nxtDir = fishes[nxtNum].dir;

            fishes[nxtNum].alive = 0;
            fish[sx][sy] = 0;
            fish[nxtX][nxtY] = -1;
            dfs(nxtX, nxtY, nxtDir, sum+nxtNum);
            fishes[nxtNum].alive = 1;
            fish[sx][sy] = -1;
            fish[nxtX][nxtY] = nxtNum;
        }

        for(int i=0; i<4; i++) {
            System.arraycopy(tempfish[i], 0, fish[i], 0, fish.length);
        }

        for(int i=1; i<=16; i++) {
            fishes[i] = new Fish(tempfishes[i].x, tempfishes[i].y, tempfishes[i].dir, tempfishes[i].alive, tempfishes[i].num);
        }
    }
    static void movefish() {
        for(int i=1; i<=16; i++) {
            int cnt = 0;
            if(fishes[i].alive == 0) continue;
            int dir = fishes[i].dir;
            while (cnt++ < 8) {
                int nxtX = fishes[i].x + dx[dir];
                int nxtY = fishes[i].y + dy[dir];

                if(nxtX < 0 || nxtX >= 4 || nxtY < 0 || nxtY >= 4) {
                    dir = (dir + 1) % 8;
                    continue;
                }
                if(fish[nxtX][nxtY] == -1) {
                    dir = (dir + 1) % 8;
                    continue;
                }

                // 물고기가 빈경우
                if(fish[nxtX][nxtY] == 0) {
                    fish[fishes[i].x][fishes[i].y] = 0;
                    fishes[i] = new Fish(nxtX, nxtY, dir, fishes[i].alive, i);
                    fish[nxtX][nxtY] = i;
                }
                else {
                    // 처음 물고기
                    int curX = fishes[i].x;
                    int curY = fishes[i].y;

                    fishes[i] = new Fish(nxtX, nxtY, dir, fishes[i].alive, i);
                    int destNum = fish[nxtX][nxtY];
                    fishes[destNum] = new Fish(curX, curY, fishes[destNum].dir, fishes[destNum].alive, destNum);

                    fish[curX][curY] = destNum;
                    fish[nxtX][nxtY] = i;
                    // 대상 물고기
                }
                break;
            }
        }
    }
    static class Fish {
        int x, y;
        int dir;
        int alive, num; // 살아있으면 1
        Fish(int x, int y, int dir, int alive, int num) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.alive = alive;
            this.num = num;
        }
    }
}