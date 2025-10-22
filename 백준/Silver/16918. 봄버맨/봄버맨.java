import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boom[][] map;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new boom[r][c];

        for(int i=0; i<r; i++) {
            String str = br.readLine();
            for(int j=0; j<c; j++) {
                map[i][j] = new boom(str.charAt(j), 0);
            }
        }

        int seconds = 1;
        boolean button = false;

        while (seconds < n) {
            seconds++;
            if(!button) {
                plant(r,c,seconds);
            } else if(button) {
                explode(r,c,seconds);
            }
            button = !button;
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(map[i][j].status);
            }
            System.out.println();
        }
    }
    public static void plant(int r, int c, int s){
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                boom now = map[i][j];
                char nowStatus = now.status;

                if(nowStatus == '.') {
                    boom newBoom = new boom('O', s);
                    map[i][j] = newBoom;
                }
            }
        }
    }

    public static void explode(int r, int c, int s) {
        boolean[][] flag = new boolean[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                boom now = map[i][j];
                char nowStatus = now.status;
                int nowTime = now.time;

                if(nowStatus == 'O' && s - nowTime >= 3) {
                    flag[i][j] = true;
                    for(int t=0; t<4; t++) {
                        int nr = i + dr[t];
                        int nc = j + dc[t];

                        if(nr >=0 && nr <r && nc>=0 && nc<c) {
                            flag[nr][nc] = true;
                        }
                    }
                }
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(flag[i][j]) {
                    boom remove = new boom('.', 0);
                    map[i][j] = remove;
                }
            }
        }
    }

    private static class boom {
        char status;
        int time;
        public boom (char status, int time) {
            this.status = status;
            this.time = time;
        }
    }
}