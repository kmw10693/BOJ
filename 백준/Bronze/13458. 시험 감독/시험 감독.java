import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, B, C;
    static int[] map;
    static long ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ans = N;
        for(int i=0; i<N; i++) {
            if(map[i] - B > 0) {
                map[i] -= B;
            }
            else map[i] = 0;
        }
        for(int i=0; i<N; i++) {
            // 나머지가 0이 아닌 경우
            if(map[i] % C != 0) ans += (map[i] / C) + 1;
            else ans += (map[i]/C);
        }
        System.out.println(ans);
    }
}