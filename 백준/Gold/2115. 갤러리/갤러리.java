import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N+1][M+1];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int result = 0;
        for(int i=0; i<N-1; i++) {
            int count1 =0;
            for(int j=0; j<M; j++) {
                // 위가 X이고 아래가 .인 경우
                if(map[i][j] == 'X' && map[i+1][j] == '.') {
                    count1++;
                }
                else {
                    result += (count1/2);
                    count1 = 0;
                }
            }
            result += (count1/2);
        }

        for(int i=1; i<N; i++) {
            int count2 = 0;
            for(int j=0; j<M; j++) {
                if(map[i][j] == 'X' && map[i-1][j] == '.') {
                    count2++;
                }
                else {
                    result += (count2/2);
                    count2 = 0;
                }
            }
            result += (count2/2);
        }

        for(int i=0; i<M-1; i++) {
            int count3 = 0;
            for(int j=0; j<N; j++) {
                if(map[j][i] == 'X' && map[j][i+1] == '.') {
                    count3++;
                } else {
                    result += (count3/2);
                    count3 = 0;
                }
            }
            result += (count3/2);
        }

        for(int i=1; i<M; i++) {
            int count4 = 0;
            for(int j=0; j<N; j++) {
                if(map[j][i] == 'X' && map[j][i-1] == '.') {
                    count4++;
                } else {
                    result += (count4/2);
                    count4 = 0;
                }
            }
            result += (count4/2);
        }
        System.out.println(result);
    }
}