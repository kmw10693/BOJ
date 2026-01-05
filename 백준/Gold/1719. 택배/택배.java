import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n,m;
    static int[][] map, pointMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        pointMap = new int[n+1][n+1];

        // map 초기화
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                map[i][j] = 100000;
            }
        }

        // pointmap 초기화
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                pointMap[i][j] = j;
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a,b,w;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map[b][a] = map[a][b] = Math.min(map[a][b], w);
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        pointMap[i][j] = pointMap[i][k];
                    }
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j) System.out.print("-");
                else {
                    System.out.print(pointMap[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}