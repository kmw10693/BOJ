import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, R;
    static int[] damage;
    static int[] extra;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        damage = new int[S+1];
        extra = new int[R+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++){
            damage[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<R; j++) {
            extra[j] = Integer.parseInt(st.nextToken());
            for(int i=0; i<S; i++) {
                if(extra[j] == damage[i]) {
                    extra[j] = 0;
                    damage[i] = 0;
                    break;
                }
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<S; j++) {
                if(extra[i] != 0 && (extra[i] == damage[j] - 1 || extra[i] == damage[j] + 1) && (damage[j] != 0)) {
                    damage[j] = 0;
                    extra[i] = 0;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<S; i++) {
            if(damage[i] != 0) ans++;
        }
        System.out.println(ans);
    }
}