import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N,M;
    static int[][] map;
    static int ans = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                for(int k=-N; k<=N; k++) {
                    for(int l=-M; l<=M; l++) {
                        if(k == 0 && l == 0) continue;
                        int startX = i;
                        int startY = j;
                        int num = 0;
                        while (startX >= 0 && startX < N && startY >= 0 && startY < M) {
                            num = num * 10 + map[startX][startY];
                            if(check(num)) ans = Math.max(ans, num);
                            startX += k;
                            startY += l;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
    private static boolean check(int num) {
        int tmp = (int)Math.sqrt(num);
        return tmp * tmp == num;
    }
}